package com.driveeat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.driveeat.entity.MenuPartItems;
import com.driveeat.entity.MenuPartProducts;
import com.driveeat.entity.MenuParts;
import com.driveeat.entity.PartProduct;
import com.driveeat.entity.Products;
import com.driveeat.repository.MenuPartItemsRepository;
import com.driveeat.repository.MenuPartsRepository;
import com.driveeat.repository.MenusRepository;
import com.driveeat.repository.RestaurantsRepository;
import com.driveeat.repository.TimetablesDefinitionsRepository;

@Controller
public class RestaurantController {

	@Autowired
	private RestaurantsRepository restaurantsRepository;
	@Autowired
	private TimetablesDefinitionsRepository timetablesDefinitionsRepository;
	@Autowired
	private MenusRepository menusRepository;
    
	@Autowired
	private MenuPartsRepository menuPartsRepository; 
	@Autowired
	private MenuPartItemsRepository menuPartItemsRepository;
	
	private MenuPartProducts menuPartProducts; 
	private PartProduct partProduct;
	@GetMapping("/restaurantSpecialites/restaurants")
	public String getRestaurantPage(Model model, @RequestParam Integer id) {
		model.addAttribute("restaurant", restaurantsRepository.getOne(id));
		model.addAttribute("timetablesDefinitions", timetablesDefinitionsRepository.findByRestaurants(restaurantsRepository.getOne(id)));
		model.addAttribute("menus", menusRepository.findByRestaurants(restaurantsRepository.getOne(id)));
		model.addAttribute("categories", menusRepository.findByMenuCategories(id));
    
	menuPartProducts = new MenuPartProducts();
	
	menuPartProducts.setMenu(menusRepository.getOne(282));
	
	List<MenuParts> mp = new ArrayList<MenuParts>();
	mp = menuPartsRepository.findByMenus(menusRepository.getOne(282));
    for (MenuParts menuParts : mp) {
    	partProduct = new PartProduct();
         partProduct.setMenuParts(menuParts);
         List<MenuPartItems> mpi = new ArrayList<MenuPartItems>();
         mpi = menuPartItemsRepository.findByMenuParts(menuParts);
         for (MenuPartItems menuPI : mpi) {
        	 partProduct.getProduct().add(menuPI.getProducts());
		}
         menuPartProducts.getPartProduct().add(partProduct);  
	}
		
		
		
		System.out.println(menuPartProducts.getMenu().getName());
		System.out.println("-------------------------------");
		for(PartProduct pp : menuPartProducts.getPartProduct()) {
			System.out.println(pp.getMenuParts().getName());
			System.out.println("---------------------");
			for (Products p : pp.getProduct() ) {
				System.out.println(p.getName());
			}
			
			
			System.out.println("============================");
		}
		
		
		
		
		
		return "restaurant";
	}
	
	
	
	

}
