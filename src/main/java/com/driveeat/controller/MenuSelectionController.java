package com.driveeat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuSelectionController {

	@GetMapping("/restaurantSpecialites/restaurants/menu-selection")
	public String getMenuSelection() {

		return "menu_selection";
	}
}
