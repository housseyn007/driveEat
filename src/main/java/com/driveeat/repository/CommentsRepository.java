package com.driveeat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.driveeat.entity.Comments;

public interface CommentsRepository extends JpaRepository<Comments, Integer>{

}
