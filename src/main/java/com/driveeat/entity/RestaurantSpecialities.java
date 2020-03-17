package com.driveeat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "RestaurantSpecialities")
public class RestaurantSpecialities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer restaurantSpecialityId;

	@ManyToOne
	@JoinColumn(name = "restaurantId")
	@NotNull
	private Restaurants restaurants;

	@ManyToOne
	@JoinColumn(name = "specialityId")
	@NotNull
	private Specialities specialities;
	@Column(name = "`rank`")
	@NotNull
	private int rank;

	public RestaurantSpecialities() {
		super();
	}

	public RestaurantSpecialities(Restaurants restaurants, Specialities specialities, int rank) {
		super();
		this.restaurants = restaurants;
		this.specialities = specialities;
		this.rank = rank;
	}

	public Integer getRestaurantSpecialityId() {
		return restaurantSpecialityId;
	}

	public void setRestaurantSpecialityId(Integer restaurantSpecialityId) {
		this.restaurantSpecialityId = restaurantSpecialityId;
	}

	public Restaurants getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(Restaurants restaurants) {
		this.restaurants = restaurants;
	}

	public Specialities getSpecialities() {
		return specialities;
	}

	public void setSpecialities(Specialities specialities) {
		this.specialities = specialities;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}
