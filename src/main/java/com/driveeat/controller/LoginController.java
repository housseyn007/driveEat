package com.driveeat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/connexion")
	public String getLoginPage() {
		return "login_page";
	}

	@GetMapping("/déconnexion")
	public String getLogoutPage() {

		return "login_page";
	}
}
