package com.driveeat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.driveeat.entity.Favourites;
import com.driveeat.entity.Restaurants;
import com.driveeat.entity.Users;

public interface FavouritesRepository extends JpaRepository<Favourites, Integer> {
	@Query(value = "SELECT F FROM Favourites F WHERE F.users.userId = ?1 AND F.restaurants.restaurantId != null")
	public List<Favourites> getRestaurantsFavorites(Integer idUser);

	@Query(value = "SELECT F FROM Favourites F WHERE F.users.userId = ?1 AND F.restaurants.restaurantId = ?2")
	public Favourites getByRestaurantsAndUser(Integer userId, Integer restaurantId);
	
}
