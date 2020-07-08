package com.driveeat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.driveeat.entity.Favourites;
import com.driveeat.entity.UserPrincipal;
import com.driveeat.repository.FavouritesRepository;
import com.driveeat.repository.RestaurantsRepository;
import com.driveeat.repository.UsersRepository;

@Controller
public class FavoriteController {

	@Autowired
	private FavouritesRepository favouritesRepository;

	private Favourites favourites;

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private RestaurantsRepository restaurantsRepository;
	
	private String listOfIdRestaurantChecked ;

	@GetMapping("/utilisateurs/favoris")
	public String getFavoritePage(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserPrincipal) {
			UserPrincipal userPricipal = (UserPrincipal) principal;
            model.addAttribute("ListOfRestaurantFavorite", favouritesRepository.getRestaurantsFavorites(userPricipal.getUserId()));
        
		}

		return "favorite";
	}

	@PostMapping("/restaurantSpecialites/ajout-favoris")
	public String addFavorite(Model model, Integer restaurantId, Integer specialityId) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		favourites = new Favourites();
		if (principal instanceof UserPrincipal) {
			UserPrincipal userPricipal = (UserPrincipal) principal;
			favourites.setUsers(usersRepository.findById(userPricipal.getUserId()).get());
			favourites.setRestaurants(restaurantsRepository.findById(restaurantId).get());
			favouritesRepository.save(favourites);
		
			
			for (Favourites favoriteRestaurant : favouritesRepository.getRestaurantsFavorites(userPricipal.getUserId())) {
				listOfIdRestaurantChecked += favoriteRestaurant.getRestaurants().getRestaurantId() +" " ;
			}
			  
        
		}
		
		
		

		return "redirect:/restaurantSpecialites?id=" + specialityId;
	}
}
