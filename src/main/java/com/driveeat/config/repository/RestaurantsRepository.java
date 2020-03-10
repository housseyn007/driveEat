package com.driveeat.config.repository;

import com.driveeat.config.entity.Restaurants;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantsRepository extends JpaRepository<Restaurants, Integer> {

}
