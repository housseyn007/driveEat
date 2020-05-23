package com.driveeat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecapController {

	@GetMapping("/recapitulatif")
	public String getRecapPage() {

		return "recap_page";
	}
}
