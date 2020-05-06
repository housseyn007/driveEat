package com.driveeat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {

	@GetMapping("/inscription")
	public String getRegistrationPage() {

		return "registration_form";
	}
}
