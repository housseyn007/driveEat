package com.driveeat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.driveeat.entity.Cards;

public interface CardsRepository extends JpaRepository<Cards, Integer> {

}