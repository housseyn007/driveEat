package com.driveeat.entity;

import com.driveeat.entity.RestaurantSpecialities;

public class NearRestaurants{
	private Float distance;
	private RestaurantSpecialities restaurantSpecialities;
	public NearRestaurants() {
		super();
	}
	public NearRestaurants(Float distance, RestaurantSpecialities restaurantsSpecialities) {
		super();
		this.distance = distance;
		this.restaurantSpecialities = restaurantsSpecialities;
	}
	public Float getDistance() {
		return distance;
	}
	public void setDistance(Float distance) {
		this.distance = distance;
	}
	public RestaurantSpecialities getRestaurantSpecialities() {
		return restaurantSpecialities;
	}
	public void setRestaurantSpecialities(RestaurantSpecialities restaurantsSpecialities) {
		this.restaurantSpecialities = restaurantsSpecialities;
	}


	

}
