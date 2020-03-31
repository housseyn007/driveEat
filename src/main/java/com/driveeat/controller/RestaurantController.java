package com.driveeat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.driveeat.entity.MenuCategories;
import com.driveeat.entity.Menus;
import com.driveeat.repository.MenusRepository;
import com.driveeat.repository.RestaurantsRepository;

@Controller
public class RestaurantController {

	@Autowired
	private RestaurantsRepository restaurantsRepository;
	@Autowired
	private MenusRepository menusRepository;



	@GetMapping("/restaurants")
	public String getRestaurantPage(Model model, @RequestParam Integer id) {
		model.addAttribute("restaurant", restaurantsRepository.getOne(id));
		model.addAttribute("menus", menusRepository.findByRestaurants(restaurantsRepository.getOne(id)));
        model.addAttribute("categories", menusRepository.findByMenuCategories(id));
        
		return "restaurant";
	}

}
