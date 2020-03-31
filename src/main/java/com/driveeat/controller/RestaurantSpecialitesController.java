package com.driveeat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.driveeat.entity.RestaurantSpecialities;
import com.driveeat.entity.Specialities;
import com.driveeat.repository.RestaurantSpecialitiesRepository;
import com.driveeat.repository.SpecialitiesRepository;

@Controller
public class RestaurantSpecialitesController {
	@Autowired
	private RestaurantSpecialitiesRepository restaurantSpecialitiesRepository;
	@Autowired
	private SpecialitiesRepository specialities;

	@GetMapping("/restaurantSpecialites")
	public String showrestaurents(Model model, @RequestParam Integer id) {
		
		model.addAttribute("RestaurantSpecialites", restaurantSpecialitiesRepository.findBySpecialities(specialities.getOne(id)));
		return "restaurantSpecialites";
	}

}
