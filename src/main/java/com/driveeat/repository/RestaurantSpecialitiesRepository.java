package com.driveeat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.driveeat.entity.RestaurantSpecialities;
import com.driveeat.entity.Restaurants;
import com.driveeat.entity.Specialities;

public interface RestaurantSpecialitiesRepository extends JpaRepository<RestaurantSpecialities, Integer> {
	
	public List<RestaurantSpecialities> findBySpecialities(Specialities id);
	public List<RestaurantSpecialities> findByRestaurants(Restaurants id);
	
	@Query("SELECT rs FROM RestaurantSpecialities rs WHERE (rs.restaurants.latitude BETWEEN ?1 AND ?2) AND (rs.restaurants.longitude BETWEEN ?3 AND ?4)")
	public List<RestaurantSpecialities> getCyrcleOfRestaurants(Float lat_1, Float lat_2, Float lng_1, Float lng_2 );


}
