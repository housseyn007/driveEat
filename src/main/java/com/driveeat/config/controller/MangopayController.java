package com.driveeat.config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MangopayController {
	@GetMapping("/cgu-mangopay")
	public String getMangopayPage() {
		return "mangopay";
	}
}
