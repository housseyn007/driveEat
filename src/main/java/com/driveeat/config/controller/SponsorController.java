package com.driveeat.config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SponsorController {

	@GetMapping("/sponsors")
	public String getSponsorPage() {
		return "sponsor";
	}
}
