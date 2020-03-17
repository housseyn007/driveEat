package com.driveeat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Products")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;

	@NotNull
	private String name;
	private String composition;
	private int preparationTime;
	@NotNull
	@Column(name = "TVA", columnDefinition = "Decimal(10,2) default '100.00'")
	private double TVA;
	@NotNull
	@Column(name = "price", columnDefinition = "Decimal(10,2) default '100.00'")
	private double price;

	@ManyToOne
	@JoinColumn(name = "restaurantId", insertable = false, updatable = false)
	@NotNull
	private Restaurants restaurants;
	@Column(columnDefinition = "enum('hot','cold')")
	@Enumerated(EnumType.STRING)
	@NotNull
	private HotCold temperature;
	@Column(columnDefinition = "tinyint(1) default 1")
	@NotNull
	private boolean immanquable;
	@Column(columnDefinition = "tinyint(1) default 1")
	@NotNull
	private boolean disabled;

	@ManyToOne
	@JoinColumn(name = "CategoryId", insertable = false, updatable = false)
	private Categories categories;

	public Products() {
		super();
	}

	public Products(@NotNull String name, String composition, int preparationTime, double tVA, double price,
			@NotNull Restaurants restaurants, @NotNull boolean immanquable, boolean disabled, Categories categories) {
		super();
		this.name = name;
		this.composition = composition;
		this.preparationTime = preparationTime;
		TVA = tVA;
		this.price = price;
		this.restaurants = restaurants;
		this.immanquable = immanquable;
		this.disabled = disabled;
		this.categories = categories;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComposition() {
		return composition;
	}

	public void setComposition(String composition) {
		this.composition = composition;
	}

	public int getPreparationTime() {
		return preparationTime;
	}

	public void setPreparationTime(int preparationTime) {
		this.preparationTime = preparationTime;
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

	public boolean isImmanquable() {
		return immanquable;
	}

	public void setImmanquable(boolean immanquable) {
		this.immanquable = immanquable;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

}
