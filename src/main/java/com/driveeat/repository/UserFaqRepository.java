package com.driveeat.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.driveeat.entity.UserFaq;

public interface UserFaqRepository extends JpaRepository<UserFaq, Integer> {

}