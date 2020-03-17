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
@Table(name = "Cards")
public class Cards {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cardId;

	@NotNull
	private String token;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date endOfValidity;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "userId", insertable = false, updatable = false)
	private Users users;

	private int mangopayCardId;

	private int mangopayCardId_dev;

	@NotNull
	private String preRegistrationData;

	@NotNull
	private String registrationData;

	@NotNull
	private String accessKey;

	private String mangoId;


	public Cards() {
	}

	public Cards(String token, Date endOfValidity, Users users, int mangopayCardId, int mangopayCardId_dev, String preRegistrationData, String registrationData, String accessKey, String mangoId) {
		this.token = token;
		this.endOfValidity = endOfValidity;
		this.users = users;
		this.mangopayCardId = mangopayCardId;
		this.mangopayCardId_dev = mangopayCardId_dev;
		this.preRegistrationData = preRegistrationData;
		this.registrationData = registrationData;
		this.accessKey = accessKey;
		this.mangoId = mangoId;
	}


	public Integer getCardId() {
		return this.cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getEndOfValidity() {
		return this.endOfValidity;
	}

	public void setEndOfValidity(Date endOfValidity) {
		this.endOfValidity = endOfValidity;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public int getMangopayCardId() {
		return this.mangopayCardId;
	}

	public void setMangopayCardId(int mangopayCardId) {
		this.mangopayCardId = mangopayCardId;
	}

	public int getMangopayCardId_dev() {
		return this.mangopayCardId_dev;
	}

	public void setMangopayCardId_dev(int mangopayCardId_dev) {
		this.mangopayCardId_dev = mangopayCardId_dev;
	}

	public String getPreRegistrationData() {
		return this.preRegistrationData;
	}

	public void setPreRegistrationData(String preRegistrationData) {
		this.preRegistrationData = preRegistrationData;
	}

	public String getRegistrationData() {
		return this.registrationData;
	}

	public void setRegistrationData(String registrationData) {
		this.registrationData = registrationData;
	}

	public String getAccessKey() {
		return this.accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	public String getMangoId() {
		return this.mangoId;
	}

	public void setMangoId(String mangoId) {
		this.mangoId = mangoId;
	}
	

}
