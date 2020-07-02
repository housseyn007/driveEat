package com.driveeat.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.driveeat.entity.UserPrincipal;
import com.driveeat.entity.Users;
import com.driveeat.repository.UsersRepository;

@Controller
public class MyProfileController {

	@Autowired
	private UsersRepository usersRepository;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@GetMapping("/utilisateurs/mon-profil")
	public ModelAndView getMyProfilePage(ModelAndView modelAndView) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserPrincipal) {
			UserPrincipal userPricipal = (UserPrincipal) principal;
			Users userConnected = usersRepository.findById(userPricipal.getUserId()).get();
			modelAndView.addObject("users", userConnected);
		}

		modelAndView.setViewName("my_profile");

		return modelAndView;
	}

	@PostMapping("/utilisateurs/mise-a-jour-profile")
	public ModelAndView updateMyProfile(ModelAndView modelAndView, @Valid Users users, BindingResult result) {

		if (result.hasErrors()) {
			modelAndView.addObject("user", users);
			modelAndView.addObject("fail", "Une erreur a été détectée. Merci de rectifier vos informations .");
			modelAndView.setViewName("my_profile");

		} else {

			users.setPassword(encoder.encode(users.getPassword()));
			modelAndView.addObject("user", usersRepository.save(users));
			modelAndView.addObject("success", " Votre profil a bien été modifié .");
			modelAndView.setViewName("my_profile");
		}
		return modelAndView;
	}
}
