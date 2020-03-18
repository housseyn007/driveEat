package com.driveeat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Comments")
public class Comments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer commentId;
	@ManyToOne
	@JoinColumn(name = "userId", insertable = false, updatable = false)
	@NotNull
	private Users user;
	@ManyToOne
	@JoinColumn(name = "restaurantId", insertable = false, updatable = false)
	@NotNull
	private Restaurants restaurant;
	private String commentText;
	 @Column(columnDefinition = "enum('1','2','3','4','5')")
	 @Enumerated(EnumType.ORDINAL)
	 @NotNull
	 private Grade  grade;
	public Comments() {
		super();
	}
	public Comments(@NotNull Users user, @NotNull Restaurants restaurant, String commentText, @NotNull Grade grade) {
		super();
		this.user = user;
		this.restaurant = restaurant;
		this.commentText = commentText;
		this.grade = grade;
	}
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Restaurants getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurants restaurant) {
		this.restaurant = restaurant;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	 
}
