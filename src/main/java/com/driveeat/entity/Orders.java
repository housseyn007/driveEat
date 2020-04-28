package com.driveeat.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "Orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	@NotNull
	@Column(name="price", columnDefinition="Decimal(10,2) default '0.00'")
	private double price;
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDatetime;
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date requestedDatetime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date completionDatetime;
	@Column(columnDefinition = "enum('toValidate','toPrepare','ready','refused','done','refunded','created')")
	@Enumerated(EnumType.STRING)
	@NotNull
	private StatusOfOrder status;
	@Column(columnDefinition = "enum('takeAway','onSite')")
	@Enumerated(EnumType.STRING)
	@NotNull
	private Type type;
	 @ManyToOne    
	 @JoinColumn(name="userId", insertable=false, updatable=false, foreignKey = @ForeignKey(name = "Orders_ibfk_2"))
	 @NotNull
     private Users users;
	 @ManyToOne    
	 @JoinColumn(name="restaurantId", insertable=false, updatable=false, foreignKey = @ForeignKey(name = "Orders_ibfk_1"))
     private Restaurants restaurant; 
	 @Column(columnDefinition = "TEXT")
	 @NotNull
	 private String comment;
	 @Column(columnDefinition="tinyint(1) default 0")
	 @NotNull
	 private boolean isPushNotificationSent;
	public Orders() {
		super();
	}
	public Orders(@NotNull double price, Date orderDatetime, @NotNull Date requestedDatetime, Date completionDatetime,
			@NotNull StatusOfOrder status, @NotNull Type type, @NotNull Users users, Restaurants restaurant,
			@NotNull String comment, @NotNull boolean isPushNotificationSent) {
		super();
		this.price = price;
		this.orderDatetime = orderDatetime;
		this.requestedDatetime = requestedDatetime;
		this.completionDatetime = completionDatetime;
		this.status = status;
		this.type = type;
		this.users = users;
		this.restaurant = restaurant;
		this.comment = comment;
		this.isPushNotificationSent = isPushNotificationSent;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getOrderDatetime() {
		return orderDatetime;
	}
	public void setOrderDatetime(Date orderDatetime) {
		this.orderDatetime = orderDatetime;
	}
	public Date getRequestedDatetime() {
		return requestedDatetime;
	}
	public void setRequestedDatetime(Date requestedDatetime) {
		this.requestedDatetime = requestedDatetime;
	}
	public Date getCompletionDatetime() {
		return completionDatetime;
	}
	public void setCompletionDatetime(Date completionDatetime) {
		this.completionDatetime = completionDatetime;
	}
	public StatusOfOrder getStatus() {
		return status;
	}
	public void setStatus(StatusOfOrder status) {
		this.status = status;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Restaurants getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurants restaurant) {
		this.restaurant = restaurant;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public boolean isPushNotificationSent() {
		return isPushNotificationSent;
	}
	public void setPushNotificationSent(boolean isPushNotificationSent) {
		this.isPushNotificationSent = isPushNotificationSent;
	}
	
	
	

}
