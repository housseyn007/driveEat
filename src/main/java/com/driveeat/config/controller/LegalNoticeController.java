package com.driveeat.config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LegalNoticeController {
	@GetMapping("/mentions-legales")
	public String getLegalNoticePage() {
		return "legal_notice";
	}
}
