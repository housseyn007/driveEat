package com.driveeat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.driveeat.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer>{

}
