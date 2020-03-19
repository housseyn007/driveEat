package com.driveeat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "UserFaq")
public class UserFaq {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userFaqId;

	@Length(max = 1000)  
	@NotNull
	private String question;

	@Column(columnDefinition = "TEXT")
	@NotNull
	private String answer;

	@Column(name = "`rank`", columnDefinition = "int default '1'")
	@NotNull
	private int rank;

	public UserFaq() {
		super();
	}

	public UserFaq(@Length(max = 1000) @NotNull String question, @NotNull String answer, @NotNull int rank) {
		super();
		this.question = question;
		this.answer = answer;
		this.rank = rank;
	}

	public Integer getUserFaqId() {
		return userFaqId;
	}

	public void setUserFaqId(Integer userFaqId) {
		this.userFaqId = userFaqId;
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