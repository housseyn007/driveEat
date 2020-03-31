package com.driveeat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.driveeat.repository.RestaurantsRepository;

@Controller
public class RestaurantController {

	@Autowired
	private RestaurantsRepository restaurantsRepository;

	@GetMapping("/restaurants")
	public String getRestaurantPage(Model model, @RequestParam Integer id) {

		model.addAttribute("restaurant", restaurantsRepository.getOne(id));

		return "restaurant";
	}

}
