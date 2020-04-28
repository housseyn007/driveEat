package com.driveeat.entity;

import java.util.ArrayList;
import java.util.List;

public class MenuPartProducts {
	private Menus menu;
	private List<PartProduct> partProduct = new ArrayList<PartProduct>();
	public MenuPartProducts() {
		super();
	}
	public MenuPartProducts(Menus menu, List<PartProduct> partProduct) {
		super();
		this.menu = menu;
		this.partProduct = partProduct;
	}
	public Menus getMenu() {
		return menu;
	}
	public void setMenu(Menus menu) {
		this.menu = menu;
	}
	public List<PartProduct> getPartProduct() {
		return partProduct;
	}
	public void setPartProduct(List<PartProduct> partProduct) {
		this.partProduct = partProduct;
	}
   	

}
