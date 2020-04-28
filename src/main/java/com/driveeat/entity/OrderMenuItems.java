package com.driveeat.entity;

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
@Table(name = "OrderMenuItems")
public class OrderMenuItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderMenuItemId;

	@ManyToOne
	@JoinColumn(name = "menuPartItemId", insertable = false, updatable = false,  foreignKey = @ForeignKey(name = "OrderMenuItems_ibfk_1"))
	@NotNull
	private MenuPartItems menuPartItems;

	@ManyToOne
	@JoinColumn(name = "orderMenuId", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "OrderMenuItems_ibfk_2"))
	@NotNull
	private OrderMenus orderMenus;

	private float priceIfSupplement;

	public OrderMenuItems() {
		super();
	}

	public OrderMenuItems(MenuPartItems menuPartItems, @NotNull OrderMenus orderMenus, float priceIfSupplement) {
		super();
		this.menuPartItems = menuPartItems;
		this.orderMenus = orderMenus;
		this.priceIfSupplement = priceIfSupplement;
	}

	public Integer getOrderMenuItemId() {
		return orderMenuItemId;
	}

	public void setOrderMenuItemId(Integer orderMenuItemId) {
		this.orderMenuItemId = orderMenuItemId;
	}

	public MenuPartItems getMenuPartItems() {
		return menuPartItems;
	}

	public void setMenuPartItems(MenuPartItems menuPartItems) {
		this.menuPartItems = menuPartItems;
	}

	public OrderMenus getOrderMenus() {
		return orderMenus;
	}

	public void setOrderMenus(OrderMenus orderMenus) {
		this.orderMenus = orderMenus;
	}

	public float getPriceIfSupplement() {
		return priceIfSupplement;
	}

	public void setPriceIfSupplement(float priceIfSupplement) {
		this.priceIfSupplement = priceIfSupplement;
	}

}
