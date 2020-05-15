package com.driveeat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.driveeat.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

	Users findByEmail(String email);
}
