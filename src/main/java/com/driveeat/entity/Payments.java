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
@Table(name = "Payments")
public class Payments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentId;

	@ManyToOne
	@JoinColumn(name = "orderId", insertable = false, updatable = false)
	private Orders orders;
	
	@NotNull
	private String status;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date paymentDatetime;

	@ManyToOne
	@JoinColumn(name = "cardId", insertable = false, updatable = false)
	private Cards cards;

	private String payinId;

	public Payments() {
	}


	public Payments(Orders orders, String status, Date paymentDatetime, Cards cards, String payinId) {
		this.orders = orders;
		this.status = status;
		this.paymentDatetime = paymentDatetime;
		this.cards = cards;
		this.payinId = payinId;
	}


	public Integer getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getPaymentDatetime() {
		return this.paymentDatetime;
	}

	public void setPaymentDatetime(Date paymentDatetime) {
		this.paymentDatetime = paymentDatetime;
	}

	public Cards getCards() {
		return this.cards;
	}

	public void setCards(Cards cards) {
		this.cards = cards;
	}

	public String getPayinId() {
		return this.payinId;
	}

	public void setPayinId(String payinId) {
		this.payinId = payinId;
	}

}