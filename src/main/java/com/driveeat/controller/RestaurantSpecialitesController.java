package com.driveeat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.driveeat.entity.Favourites;
import com.driveeat.entity.UserPrincipal;
import com.driveeat.repository.FavouritesRepository;
import com.driveeat.repository.RestaurantSpecialitiesRepository;
import com.driveeat.repository.SpecialitiesRepository;

@Controller
public class RestaurantSpecialitesController {
	@Autowired
	private RestaurantSpecialitiesRepository restaurantSpecialitiesRepository;
	@Autowired
	private SpecialitiesRepository specialities;

	@Autowired
	private FavouritesRepository favouritesRepository;

	private Favourites favourites;

	public List<Integer> listOfIdRestaurantChecked;

	@GetMapping("/restaurantSpecialites")
	public String showrestaurents(Model model, @RequestParam Integer id) {

		listOfIdRestaurantChecked = new ArrayList<Integer>();

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		favourites = new Favourites();

		if (principal instanceof UserPrincipal) {
			UserPrincipal userPricipal = (UserPrincipal) principal;
			for (Favourites favoriteRestaurant : favouritesRepository
					.getRestaurantsFavorites(userPricipal.getUserId())) {
				listOfIdRestaurantChecked.add(favoriteRestaurant.getRestaurants().getRestaurantId());

			}

		}

		model.addAttribute("ListOfIdRestaurantChecked", listOfIdRestaurantChecked);
		model.addAttribute("RestaurantSpecialites",
				restaurantSpecialitiesRepository.findBySpecialities(specialities.getOne(id)));

		return "restaurantSpecialites";
	}

}
