package com.driveeat.entity;

import java.util.ArrayList;
import java.util.List;

public class PartProduct {
	private MenuParts menuParts;
	private List<Products> product = new ArrayList<Products>();
	public PartProduct() {
		super();
	}
	public PartProduct(MenuParts menuParts, List<Products> product) {
		super();
		this.menuParts = menuParts;
		this.product = product;
	}
	public MenuParts getMenuParts() {
		return menuParts;
	}
	public void setMenuParts(MenuParts menuParts) {
		this.menuParts = menuParts;
	}
	public List<Products> getProduct() {
		return product;
	}
	public void setProduct(List<Products> product) {
		this.product = product;
	}
	

}
