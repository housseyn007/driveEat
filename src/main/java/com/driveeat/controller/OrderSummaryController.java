package com.driveeat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.driveeat.repository.RestaurantsRepository;

@Controller
public class OrderSummaryController {
    @Autowired
    RestaurantsRepository restaurantsRepository;
	@PostMapping("/recapitulatif-commande")
	public String getOrderSummaryPage(Model model, Integer restaurantId, String summaryOrder) {
		model.addAttribute("restaurant", restaurantsRepository.findById(restaurantId).get());
		model.addAttribute("summaryOrder", summaryOrder);

		return "order_summary";
	}
}
