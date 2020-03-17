package com.driveeat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "MenuCategories")
public class MenuCategories {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer menuCategoryId;
	@NotNull
	private String name;
	@Column(columnDefinition = "tinyint(1) default 1")
	@NotNull
	private boolean isVisible;

	public MenuCategories() {
		super();
	}

	public MenuCategories(@NotNull String name, @NotNull boolean isVisible) {
		super();
		this.name = name;
		this.isVisible = isVisible;
	}

	public Integer getMenuCategoryId() {
		return menuCategoryId;
	}

	public void setMenuCategoryId(Integer menuCategoryId) {
		this.menuCategoryId = menuCategoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

}
