package com.driveeat.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
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
	@JoinColumn(name = "userId",  foreignKey = @ForeignKey(name = "Favourites_ibfk_1"))
	private Users users;

	@ManyToOne
	@JoinColumn(name = "menuId", foreignKey = @ForeignKey(name = "Favourites_ibfk_2"))
	private Menus menus;

	@ManyToOne
	@JoinColumn(name = "productId", foreignKey = @ForeignKey(name = "Favourites_ibfk_3"))
	private Products product;

	@ManyToOne
	@JoinColumn(name = "restaurantId", foreignKey = @ForeignKey(name = "Favourites_ibfk_4"))
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
