package com.driveeat.entity;

import java.util.Date;

import javax.persistence.Column;
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
@Table(name = "Cards")
public class Cards {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cardId;

	@ManyToOne
	@JoinColumn(name = "userId", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "Cards_ibfk_1"))
	@NotNull
	private Users users;

	@NotNull
	private String token;
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date endOfValidity;

	@NotNull
	private String preRegistrationData;

	@NotNull
	private String registrationData;

	@NotNull
	private String accessKey;

	private String mangoId;

	@Column(nullable = true)
	private int mangopayCardId;

	@Column(nullable = true)
	private int mangopayCardId_dev;

	public Cards() {
		super();
	}

	public Cards(@NotNull String token, @NotNull Date endOfValidity, @NotNull Users users,
			@NotNull String preRegistrationData, @NotNull String registrationData, @NotNull String accessKey,
			String mangoId, int mangopayCardId, int mangopayCardId_dev) {
		super();
		this.token = token;
		this.endOfValidity = endOfValidity;
		this.users = users;
		this.preRegistrationData = preRegistrationData;
		this.registrationData = registrationData;
		this.accessKey = accessKey;
		this.mangoId = mangoId;
		this.mangopayCardId = mangopayCardId;
		this.mangopayCardId_dev = mangopayCardId_dev;
	}

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getEndOfValidity() {
		return endOfValidity;
	}

	public void setEndOfValidity(Date endOfValidity) {
		this.endOfValidity = endOfValidity;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getPreRegistrationData() {
		return preRegistrationData;
	}

	public void setPreRegistrationData(String preRegistrationData) {
		this.preRegistrationData = preRegistrationData;
	}

	public String getRegistrationData() {
		return registrationData;
	}

	public void setRegistrationData(String registrationData) {
		this.registrationData = registrationData;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getMangoId() {
		return mangoId;
	}

	public void setMangoId(String mangoId) {
		this.mangoId = mangoId;
	}

	public int getMangopayCardId() {
		return mangopayCardId;
	}

	public void setMangopayCardId(int mangopayCardId) {
		this.mangopayCardId = mangopayCardId;
	}

	public int getMangopayCardId_dev() {
		return mangopayCardId_dev;
	}

	public void setMangopayCardId_dev(int mangopayCardId_dev) {
		this.mangopayCardId_dev = mangopayCardId_dev;
	}

}