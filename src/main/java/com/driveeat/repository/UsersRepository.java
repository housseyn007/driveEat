package com.driveeat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.driveeat.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
