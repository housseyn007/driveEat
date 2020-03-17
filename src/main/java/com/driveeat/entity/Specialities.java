package com.driveeat.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Specialities")
public class Specialities {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer specialityId;
	@NotNull
	private String specialityName;
	@NotNull
	private String imagePath;
	@NotNull
	private int ranking;

	public Specialities() {
		super();
	}

	public Specialities(@NotNull String specialityName, @NotNull String imagePath, @NotNull int ranking) {
		super();
		this.specialityName = specialityName;
		this.imagePath = imagePath;
		this.ranking = ranking;
	}

	public Integer getSpecialityId() {
		return specialityId;
	}

	public void setSpecialityId(Integer specialityId) {
		this.specialityId = specialityId;
	}

	public String getSpecialityName() {
		return specialityName;
	}

	public void setSpecialityName(String specialityName) {
		this.specialityName = specialityName;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

}
