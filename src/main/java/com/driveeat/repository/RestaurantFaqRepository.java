package com.driveeat.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.driveeat.entity.RestaurantFaq;

public interface RestaurantFaqRepository extends JpaRepository<RestaurantFaq, Integer> {

}