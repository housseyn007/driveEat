package com.driveeat.entity;

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
@Table(name = "MenuPartItems")
public class MenuPartItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer menuPartItemId;

	@ManyToOne
	@JoinColumn(name = "menuPartId", insertable = false, updatable = false,  foreignKey = @ForeignKey(name = "MenuPartItems_ibfk_1"))
	@NotNull
	private MenuParts menuParts;

	@ManyToOne
	@JoinColumn(name = "productId", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "MenuPartItems_ibfk_2"))
	@NotNull
	private Products products;

	@Column(columnDefinition = "tinyint(1) default 1")
	@NotNull
	private boolean supplement;

	public MenuPartItems() {
		super();
	}

	public MenuPartItems(@NotNull MenuParts menuParts, @NotNull Products products, @NotNull boolean supplement) {
		super();
		this.menuParts = menuParts;
		this.products = products;
		this.supplement = supplement;
	}

	public Integer getMenuPartItemId() {
		return menuPartItemId;
	}

	public void setMenuPartItemId(Integer menuPartItemId) {
		this.menuPartItemId = menuPartItemId;
	}

	public MenuParts getMenuParts() {
		return menuParts;
	}

	public void setMenuParts(MenuParts menuParts) {
		this.menuParts = menuParts;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public boolean isSupplement() {
		return supplement;
	}

	public void setSupplement(boolean supplement) {
		this.supplement = supplement;
	}
	
	
}
