package com.driveeat.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.driveeat.entity.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, String> {
	Users findByEmailIgnoreCase(String email);
}
