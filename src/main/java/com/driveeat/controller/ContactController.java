package com.driveeat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.driveeat.entity.Contact;

@Controller
public class ContactController {
	
	@GetMapping("/contact")
	public String getContactPage(Model model) {
		model.addAttribute("contact", new Contact());
		return "contact";
	}
}
