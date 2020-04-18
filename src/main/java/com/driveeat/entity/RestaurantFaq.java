package com.driveeat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "RestaurantFaq")
public class RestaurantFaq {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer restaurantFaqId;

	@NotNull
	private String question;

	@Column(columnDefinition = "TEXT")
	@NotNull
	private String answer;

	@Column(name = "`rank`")
	@NotNull
	private int rank;

	public RestaurantFaq() {
		super();
	}

	public RestaurantFaq(@NotNull String question, @NotNull String answer, @NotNull int rank) {
		super();
		this.question = question;
		this.answer = answer;
		this.rank = rank;
	}

	public Integer getRestaurantFaqId() {
		return restaurantFaqId;
	}

	public void setRestaurantFaqId(Integer restaurantFaqId) {
		this.restaurantFaqId = restaurantFaqId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
	
}