package com.driveeat.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Favourites")
public class Favourites {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer favouriteId;

	@ManyToOne
	@JoinColumn(name = "userId", insertable = false, updatable = false)
	private Users users;

	@ManyToOne
	@JoinColumn(name = "menuId", insertable = false, updatable = false)
	private Menus menus;

	@ManyToOne
	@JoinColumn(name = "productId", insertable = false, updatable = false)
	private Products product;

	@ManyToOne
	@JoinColumn(name = "restaurantId", insertable = false, updatable = false)
	private Restaurants restaurants;

	public Favourites() {
		super();
	}

	public Favourites(Users users, Menus menus, Products product, Restaurants restaurants) {
		super();
		this.users = users;
		this.menus = menus;
		this.product = product;
		this.restaurants = restaurants;
	}

	public Integer getFavouriteId() {
		return favouriteId;
	}

	public void setFavouriteId(Integer favouriteId) {
		this.favouriteId = favouriteId;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Menus getMenus() {
		return menus;
	}

	public void setMenus(Menus menus) {
		this.menus = menus;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public Restaurants getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(Restaurants restaurants) {
		this.restaurants = restaurants;
	}

	
}
