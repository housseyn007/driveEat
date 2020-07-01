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
			modelAndView.addObject("user", userConnected);
		}

		modelAndView.setViewName("my_profile");

		return modelAndView;
	}

	@PostMapping("/utilisateurs/mise-a-jour-profile")
	public ModelAndView updateMyProfile(ModelAndView modelAndView, @Valid Users user, BindingResult result) {
		
		if (result.hasErrors()) {
			modelAndView.addObject("hasErrors", true);
			modelAndView.addObject("user", user);
			modelAndView.setViewName("my_profile");
		}else {

		user.setPassword(encoder.encode(user.getPassword()));  
        modelAndView.addObject("user", usersRepository.save(user));
		modelAndView.setViewName("my_profile");
		}
		return modelAndView;
	}
}
