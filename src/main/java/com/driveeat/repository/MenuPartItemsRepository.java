package com.driveeat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.driveeat.entity.MenuPartItems;
import com.driveeat.entity.MenuParts;
import com.driveeat.entity.Menus;

public interface MenuPartItemsRepository extends JpaRepository<MenuPartItems, Integer> {
	public List<MenuPartItems> findByMenuParts(MenuParts mp);

}
