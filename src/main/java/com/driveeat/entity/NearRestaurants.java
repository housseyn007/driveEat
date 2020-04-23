package com.driveeat.entity;

import java.util.ArrayList;
import java.util.List;

public class NearRestaurants {
	private Float distance;
	private Restaurants restaurants;
	private List<Specialities> specialities = new ArrayList<Specialities>();

	public NearRestaurants() {
		super();
	}

	public NearRestaurants(Float distance, Restaurants restaurants, List<Specialities> specialities) {
		super();
		this.distance = distance;
		this.restaurants = restaurants;
		this.specialities = specialities;
	}

	public Float getDistance() {
		return distance;
	}

	public void setDistance(Float distance) {
		this.distance = distance;
	}

	public Restaurants getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(Restaurants restaurants) {
		this.restaurants = restaurants;
	}

	public List<Specialities> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(List<Specialities> specialities) {
		this.specialities = specialities;
	}

}
