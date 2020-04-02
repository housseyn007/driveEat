package com.driveeat.entity;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "TimetablesDefinitions")
public class TimetablesDefinitions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer timetablesDefinitionId;
	@Column(columnDefinition = "enum('lundi','mardi','mercredi','jeudi','vendredi','samedi','dimanche') default 'lundi'")
	@Enumerated(EnumType.STRING)
	@NotNull
	private Week day;
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;
	@NotNull
	private String title;
	@ManyToOne
	@JoinColumn(name = "restaurantId", insertable = false, updatable = false)
	@NotNull
	private Restaurants restaurants;
	@Column(columnDefinition = "tinyint default 0")
	@NotNull
	private boolean disabled;
	public TimetablesDefinitions() {
		super();
	}
	public TimetablesDefinitions(@NotNull Week day, @NotNull Date startTime, @NotNull Date endTime,
			@NotNull String title, @NotNull Restaurants restaurants, @NotNull boolean disabled) {
		super();
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.title = title;
		this.restaurants = restaurants;
		this.disabled = disabled;
	}
	public Integer getTimetablesDefinitionId() {
		return timetablesDefinitionId;
	}
	public void setTimetablesDefinitionId(Integer timetablesDefinitionId) {
		this.timetablesDefinitionId = timetablesDefinitionId;
	}
	public Week getDay() {
		return day;
	}
	public void setDay(Week day) {
		this.day = day;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Restaurants getRestaurants() {
		return restaurants;
	}
	public void setRestaurants(Restaurants restaurants) {
		this.restaurants = restaurants;
	}
	public boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	
	

}
