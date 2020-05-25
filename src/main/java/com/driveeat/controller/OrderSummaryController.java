package com.driveeat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderSummaryController {

	@GetMapping("/recapitulatif-commande")
	public String getOrderSummaryPage() {
		return "order_summary";
	}
}
