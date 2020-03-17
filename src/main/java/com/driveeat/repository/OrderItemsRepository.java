package com.driveeat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.driveeat.entity.OrderItems;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Integer> {

}
