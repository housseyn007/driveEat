package com.driveeat.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Menus")
public class Menus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer menuId;
	@NotNull
	private String name;
	private String description;
	@NotNull
	@Column(name = "TVA", columnDefinition = "Decimal(10,2) default '100.00'")
	private double TVA;
	@NotNull
	@Column(name = "price", columnDefinition = "Decimal(10,2) default '100.00'")
	private double price;

	@ManyToOne
	@JoinColumn(name = "restaurantId", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "Menus_ibfk_1"))
	@NotNull
	private Restaurants restaurants;

	@Column(columnDefinition = "tinyint(1) default 1")
	@NotNull
	private boolean disabled;

	@ManyToOne
	@JoinColumn(name = "menuCategoryId", insertable = false, updatable = false, nullable = false, foreignKey = @ForeignKey(name = "Menus_ibfk_2"))
	private MenuCategories menuCategories;

	public Menus() {
		super();
	}

	public Menus(@NotNull String name, String description, @NotNull double tVA, @NotNull double price,
			@NotNull Restaurants restaurants, @NotNull boolean disabled, MenuCategories menuCategories) {
		super();
		this.name = name;
		this.description = description;
		TVA = tVA;
		this.price = price;
		this.restaurants = restaurants;
		this.disabled = disabled;
		this.menuCategories = menuCategories;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getTVA() {
		return TVA;
	}

	public void setTVA(double tVA) {
		TVA = tVA;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Restaurants getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(Restaurants restaurants) {
		this.restaurants = restaurants;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public MenuCategories getMenuCategories() {
		return menuCategories;
	}

	public void setMenuCategories(MenuCategories menuCategories) {
		this.menuCategories = menuCategories;
	}

}
