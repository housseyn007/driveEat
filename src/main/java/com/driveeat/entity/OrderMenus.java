package com.driveeat.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "OrderMenus")
public class OrderMenus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderMenuId;

	@ManyToOne
	@JoinColumn(name = "menuId", insertable = false, updatable = false)
	private Menus menus;

	@ManyToOne
	@JoinColumn(name = "orderId", insertable = false, updatable = false)
	@NotNull
	private Orders orders;

	@NotNull
	private float price;

	@NotNull
	private int quantity;

	public OrderMenus() {
		super();
	}

	public OrderMenus(Menus menus, Orders orders, @NotNull float price, @NotNull int quantity) {
		super();
		this.menus = menus;
		this.orders = orders;
		this.price = price;
		this.quantity = quantity;
	}

	public Integer getOrderMenuId() {
		return orderMenuId;
	}

	public void setOrderMenuId(Integer orderMenuId) {
		this.orderMenuId = orderMenuId;
	}

	public Menus getMenus() {
		return menus;
	}

	public void setMenus(Menus menus) {
		this.menus = menus;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
