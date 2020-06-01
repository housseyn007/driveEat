package com.driveeat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.driveeat.entity.Restaurants;

public interface RestaurantsRepository extends JpaRepository<Restaurants, Integer> {

	public Restaurants findByRestaurantId(Integer id);

}