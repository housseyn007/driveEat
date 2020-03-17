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
@Table(name = "OrderItems")
public class OrderItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderItemId;

	@ManyToOne
	@JoinColumn(name = "productId", insertable = false, updatable = false)
	private Products products;

	@ManyToOne
	@JoinColumn(name = "orderId", insertable = false, updatable = false)
	private Orders orders;

	@NotNull
	@Column(name = "price", columnDefinition = "Decimal(10,2) default '100.00'")
	private double price;

	@NotNull
	private int quantity;


	public OrderItems() {
	}
	

	public OrderItems(Products products, Orders orders, double price, int quantity) {
		this.products = products;
		this.orders = orders;
		this.price = price;
		this.quantity = quantity;
	}


	public Integer getOrderItemId() {
		return this.orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Products getProducts() {
		return this.products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}
