package com.driveeat.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.driveeat.entity.Users;
import com.driveeat.service.UsersService;

@Controller
public class RegistrationController {
	

	@Autowired
	private UsersService usersService;

	@GetMapping("/inscription")
	
	public String getRegistrationPage(Model model) {
		
		model.addAttribute("users", new Users());
		return "registration_form";
	}
	
	// Modified method to Add a new user User
	@PostMapping("/addUser")
  
	public String addNew(Model model, RedirectAttributes redir, @Valid Users users, BindingResult result) {

          System.out.println(users.getCreationDatetime());
          System.out.println(users.getBirthday());
          System.out.println(result.hasErrors());
		
		if (result.hasErrors()) {
			model.addAttribute("hasErrors", true);
			model.addAttribute("users", users);
			return "registration_form";
			
		}else {
		usersService.save(users);

		redir.addFlashAttribute("message",
				"L'inscription a été effectué avec succès! Vous pouvez maintenant vous connecter");

		return "redirect:/connexion";
		}
		
	
	}
}
