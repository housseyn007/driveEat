package com.driveeat.repository;

import org.springframework.data.repository.CrudRepository;

import com.driveeat.entity.ConfirmationToken;

public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, String> {
	ConfirmationToken findByConfirmationToken(String confirmationToken);
}
