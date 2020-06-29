package com.driveeat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FavoriteController {

	@GetMapping("/utilisateurs/favoris")
	public String getFavoritePage() {
		return "favorite";
	}
}
