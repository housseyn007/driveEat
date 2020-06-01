package com.driveeat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyProfileController {

	@GetMapping("/mon-profil")
	public String getMyProfilePage() {
		return "my_profile";
	}
}
