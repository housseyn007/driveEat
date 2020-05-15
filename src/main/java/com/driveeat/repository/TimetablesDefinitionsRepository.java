package com.driveeat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.driveeat.entity.Restaurants;
import com.driveeat.entity.TimetablesDefinitions;
import com.driveeat.entity.Week;

public interface TimetablesDefinitionsRepository extends JpaRepository<TimetablesDefinitions, Integer>{	
	public List<TimetablesDefinitions> findByRestaurants(Restaurants r);
	@Query("SELECT T FROM TimetablesDefinitions T WHERE T.restaurants.restaurantId = ?1 AND T.day = ?2 ")
	public TimetablesDefinitions findByRestaurantsAndDay(Integer id , Week day);

}
