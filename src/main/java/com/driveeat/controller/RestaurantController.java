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
import com.driveeat.entity.Menus;
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
	
	List<Menus> menus = new ArrayList<Menus>(); 
	menus = menusRepository.findByRestaurants(restaurantsRepository.getOne(id));		
	List<MenuPartProducts> listMenuPartProduct = new ArrayList<MenuPartProducts>();
	if(menus.size() > 0) {
	for(Menus m : menus) {	
	menuPartProducts = new MenuPartProducts();
	menuPartProducts.setMenu(m);
	List<MenuParts> menuPart = new ArrayList<MenuParts>();
	menuPart = menuPartsRepository.findByMenus(m);
    for (MenuParts mp : menuPart) {
    	partProduct = new PartProduct();
         partProduct.setMenuParts(mp);
         List<MenuPartItems> menuPartItem = new ArrayList<MenuPartItems>();
         menuPartItem = menuPartItemsRepository.findByMenuParts(mp);
         for (MenuPartItems mpi : menuPartItem) {
        	 partProduct.getProduct().add(mpi.getProducts());
		}
         menuPartProducts.getPartProduct().add(partProduct);  
	}
    listMenuPartProduct.add(menuPartProducts);
	}	
	}	
	model.addAttribute("restaurant", restaurantsRepository.getOne(id));
	model.addAttribute("timetablesDefinitions", timetablesDefinitionsRepository.findByRestaurants(restaurantsRepository.getOne(id)));
	model.addAttribute("menus", menusRepository.findByRestaurants(restaurantsRepository.getOne(id)));
	model.addAttribute("categories", menusRepository.findByMenuCategories(id));
	model.addAttribute("ListMenuPartProduct", listMenuPartProduct);
		
//		System.out.println(listMenuPartProduct.get(1).getMenu().getName());
//		System.out.println("-------------------------------");
//		for(PartProduct pp : listMenuPartProduct.get(1).getPartProduct()) {
//			System.out.println(pp.getMenuParts().getName());
//			pp.getMenuParts().isMandatory();
//			System.out.println("---------------------");
//			for (Products p : pp.getProduct() ) {
//				System.out.println(p.getName());
//			}
//			
//			
//			System.out.println("============================");
//		}
		
		
		
		
		
		return "restaurant";
	}
	
	
	
	

}
