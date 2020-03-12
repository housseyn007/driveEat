package com.driveeat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataProtectionController {
	@GetMapping("/protection-données")
	public String getDataProtectionPage() {
		return "data_protection";
	}
}
