package com.driveeat.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.driveeat.entity.Users;
import com.driveeat.service.UsersService;

@Controller
public class UsersController {

	@Autowired
	private UsersService usersService;

	@GetMapping("/utilisateurs")
	public String getRegistrationPage() {

		return "Users";
	}

	// Modified method to Add a new user User
	@PostMapping(value = "utilisateurs/ajouter-nouveau")
	public RedirectView addNew(Users users, RedirectAttributes redir, Date createDate, @RequestParam(value = "_csrf") String pushToken) {
		users.setCreationDatetime(createDate);
		users.setPushToken(pushToken);
		usersService.save(users);

		RedirectView redirectView = new RedirectView("/connexion", true);

		redir.addFlashAttribute("message",
				"L'inscription a été effectué avec succès! Vous pouvez maintenant vous connecter");

		return redirectView;
	}
}
