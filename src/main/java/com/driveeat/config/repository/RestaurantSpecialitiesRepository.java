package com.driveeat.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.driveeat.config.entity.RestaurantSpecialities;

public interface RestaurantSpecialitiesRepository extends JpaRepository<RestaurantSpecialities, Integer> {

}
