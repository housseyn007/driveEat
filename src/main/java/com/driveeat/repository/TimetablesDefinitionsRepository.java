package com.driveeat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.driveeat.entity.Restaurants;
import com.driveeat.entity.TimetablesDefinitions;

public interface TimetablesDefinitionsRepository extends JpaRepository<TimetablesDefinitions, Integer>{
	public List<TimetablesDefinitions> findByRestaurants(Restaurants id);

}
