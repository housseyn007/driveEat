package com.driveeat.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
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
@Table(name = "OrderStatusHistory")
public class OrderStatusHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderStatusHistoryId;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "orderId", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "OrderStatusHistory_ibfk_1"))
	private Orders orders;

	private String previousStatus;

	private String newStatus;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date datetime;


	public OrderStatusHistory() {
	}


	public OrderStatusHistory(Integer orderStatusHistoryId, @NotNull Orders orders, String previousStatus,
			String newStatus, @NotNull Date datetime) {
		super();
		this.orderStatusHistoryId = orderStatusHistoryId;
		this.orders = orders;
		this.previousStatus = previousStatus;
		this.newStatus = newStatus;
		this.datetime = datetime;
	}


	public Integer getOrderStatusHistoryId() {
		return orderStatusHistoryId;
	}


	public void setOrderStatusHistoryId(Integer orderStatusHistoryId) {
		this.orderStatusHistoryId = orderStatusHistoryId;
	}


	public Orders getOrders() {
		return orders;
	}


	public void setOrders(Orders orders) {
		this.orders = orders;
	}


	public String getPreviousStatus() {
		return previousStatus;
	}


	public void setPreviousStatus(String previousStatus) {
		this.previousStatus = previousStatus;
	}


	public String getNewStatus() {
		return newStatus;
	}


	public void setNewStatus(String newStatus) {
		this.newStatus = newStatus;
	}


	public Date getDatetime() {
		return datetime;
	}


	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}


	



}