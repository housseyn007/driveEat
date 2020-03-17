package com.driveeat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.driveeat.entity.Payments;

public interface PaymentsRepository extends JpaRepository<Payments, Integer> {

}
