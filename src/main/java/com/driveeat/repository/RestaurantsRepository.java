package com.driveeat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.driveeat.entity.Restaurants;

public interface RestaurantsRepository extends JpaRepository<Restaurants, Integer> {


}
