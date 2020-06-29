package com.driveeat.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TimetablesExceptions")
public class TimetablesExceptions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer timetablesExceptionId;

	@NotNull
	private int restaurantId;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;

	@Column(columnDefinition = "tinyint default '0'")
	@NotNull
	private boolean disabled;

	public TimetablesExceptions() {
		super();
	}

	public TimetablesExceptions(Integer timetablesExceptionId, @NotNull int restaurantId, @NotNull Date startTime,
			@NotNull Date endTime, @NotNull boolean disabled) {
		super();
		this.timetablesExceptionId = timetablesExceptionId;
		this.restaurantId = restaurantId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.disabled = disabled;
	}

	public Integer getTimetablesExceptionId() {
		return timetablesExceptionId;
	}

	public void setTimetablesExceptionId(Integer timetablesExceptionId) {
		this.timetablesExceptionId = timetablesExceptionId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
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

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

}