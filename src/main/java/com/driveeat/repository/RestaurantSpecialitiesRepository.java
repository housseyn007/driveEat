package com.driveeat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.driveeat.entity.RestaurantSpecialities;
import com.driveeat.entity.Specialities;

public interface RestaurantSpecialitiesRepository extends JpaRepository<RestaurantSpecialities, Integer> {
	public List<RestaurantSpecialities> findBySpecialities(Specialities id);

}
