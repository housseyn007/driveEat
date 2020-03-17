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
@Table(name = "MenuParts")
public class MenuParts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer menuPartId;

	@NotNull
	private String name;

	@ManyToOne
	@JoinColumn(name = "menuId", insertable = false, updatable = false)
	private Menus menus;

	@Column(columnDefinition = "tinyint(1) default 1")
	@NotNull
	private boolean mandatory;

	@NotNull
	private int itemsAllowed;

	public MenuParts() {
		super();
	}

	public MenuParts(@NotNull String name, Menus menus, @NotNull boolean mandatory, @NotNull int itemsAllowed) {
		super();
		this.name = name;
		this.menus = menus;
		this.mandatory = mandatory;
		this.itemsAllowed = itemsAllowed;
	}

	public Integer getMenuPartId() {
		return menuPartId;
	}

	public void setMenuPartId(Integer menuPartId) {
		this.menuPartId = menuPartId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Menus getMenus() {
		return menus;
	}

	public void setMenus(Menus menus) {
		this.menus = menus;
	}

	public boolean isMandatory() {
		return mandatory;
	}

	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}

	public int getItemsAllowed() {
		return itemsAllowed;
	}

	public void setItemsAllowed(int itemsAllowed) {
		this.itemsAllowed = itemsAllowed;
	}

}
