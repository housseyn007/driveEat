package com.driveeat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.driveeat.entity.UserFaq;
import com.driveeat.repository.UserFaqRepository;

@Controller
public class FaqController {

	@Autowired
	private UserFaqRepository userFaqRepository;
	List<UserFaq> UserFaqList;
	
	@GetMapping("/faqs")
	public String getFaqPage(Model model) {
		model.addAttribute("faqs", userFaqRepository.findAll());
		return "faq";
	}
}


