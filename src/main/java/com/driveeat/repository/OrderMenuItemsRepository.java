package com.driveeat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.driveeat.entity.OrderMenuItems;

public interface OrderMenuItemsRepository extends JpaRepository<OrderMenuItems, Integer> {

}
