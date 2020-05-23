package com.driveeat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyOrdersController {

	@GetMapping("/Mes-Commandes")
	public String getFavoritePage() {
		return "MyOrders";
	}
}