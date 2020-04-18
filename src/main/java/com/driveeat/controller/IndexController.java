package com.driveeat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.driveeat.entity.Specialities;
import com.driveeat.repository.SpecialitiesRepository;

@Controller
public class IndexController {
	@Autowired
	private SpecialitiesRepository specialitiesRepository;
	List<Specialities> specialitiesList;

	@GetMapping("/")
	public String getSpecialities(Model model) {
		model.addAttribute("specialities", specialitiesRepository.findAll());
		return "index";
	}

}
