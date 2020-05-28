package com.driveeat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.driveeat.entity.MenuCategories;
import com.driveeat.entity.Menus;
import com.driveeat.entity.Restaurants;

public interface MenusRepository extends JpaRepository<Menus, Integer> {
	public List<Menus> findByRestaurants(Restaurants r);
	@Query("SELECT m.menuCategories FROM Menus m WHERE m.restaurants.restaurantId = ?1 GROUP BY m.menuCategories ")
	public List<MenuCategories> findByMenuCategories(Integer id);
}
