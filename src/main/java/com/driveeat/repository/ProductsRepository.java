package com.driveeat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.driveeat.entity.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

}
