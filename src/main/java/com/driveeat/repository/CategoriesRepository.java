package com.driveeat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.driveeat.entity.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {

}
