package com.driveeat.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orderStatusHistory")
public class OrderStatusHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderStatusHistoryId;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "orderId", insertable = false, updatable = false)
	private Orders orders;

	private String peviousStatus;

	private String newStatus;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date datetime;


	public OrderStatusHistory() {
	}


	public OrderStatusHistory(Orders orders, String peviousStatus, String newStatus, Date datetime) {
		this.orders = orders;
		this.peviousStatus = peviousStatus;
		this.newStatus = newStatus;
		this.datetime = datetime;
	}


	public Integer getOrderStatusHistoryId() {
		return this.orderStatusHistoryId;
	}

	public void setOrderStatusHistoryId(Integer orderStatusHistoryId) {
		this.orderStatusHistoryId = orderStatusHistoryId;
	}

	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public String getPeviousStatus() {
		return this.peviousStatus;
	}

	public void setPeviousStatus(String peviousStatus) {
		this.peviousStatus = peviousStatus;
	}

	public String getNewStatus() {
		return this.newStatus;
	}

	public void setNewStatus(String newStatus) {
		this.newStatus = newStatus;
	}

	public Date getDatetime() {
		return this.datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}




}
