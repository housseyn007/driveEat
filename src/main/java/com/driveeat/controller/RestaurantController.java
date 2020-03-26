package com.driveeat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestaurantController {

	@GetMapping("/restaurants")
	public String getRestaurantPage() {

		return "restaurant";
	}
}
