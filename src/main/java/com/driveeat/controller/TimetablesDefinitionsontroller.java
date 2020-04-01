package com.driveeat.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.driveeat.entity.TimetablesDefinitions;
import com.driveeat.service.TimetablesDefinitionsService;

@Controller
@RequestMapping("/restaurant_horaire")
public class TimetablesDefinitionsontroller {

	@Autowired
	private TimetablesDefinitionsService timetablesDefinitionsService;

	@RequestMapping("/getAll")
	public String getAll(Model model) {
		List<TimetablesDefinitions> timetablesDefinitions = timetablesDefinitionsService.getAll();
		model.addAttribute("timetablesDefinitions", timetablesDefinitions);

		return "restaurant_horaire";
	}

	@RequestMapping("/getOne")
	@ResponseBody
	public Optional<TimetablesDefinitions> getOne(Integer id) {
		return timetablesDefinitionsService.getOne(id);
	}

	@RequestMapping(value = "/update", method = { RequestMethod.POST })
	public String update(TimetablesDefinitions timetablesDefinitions) {
		timetablesDefinitionsService.update(timetablesDefinitions);
		return "redirect:/restaurant_horaire/getAll";
	}

}
