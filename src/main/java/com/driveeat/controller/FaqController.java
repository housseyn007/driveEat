package com.driveeat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FaqController {

	@GetMapping("/faqs")
	public String getFaqPage() {

		return "faq";
	}
}
