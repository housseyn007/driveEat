package com.driveeat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.driveeat.entity.MenuParts;
import com.driveeat.entity.Menus;

public interface MenuPartsRepository extends JpaRepository<MenuParts, Integer> {
	public List<MenuParts> findByMenus(Menus m);
	

}
