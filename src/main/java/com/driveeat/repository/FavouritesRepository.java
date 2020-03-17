package com.driveeat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.driveeat.entity.Favourites;

public interface FavouritesRepository extends JpaRepository<Favourites, Integer> {

}
