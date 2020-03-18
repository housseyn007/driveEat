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
@Table(name = "Users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDatetime;
	@Column(unique=true)
	@NotNull
	private String email;
	@Column(length = 20)
	private String phone;
	@NotNull
	private String password;
	@Temporal(TemporalType.DATE)
	private Date birthday;
	@NotNull
	private String pushToken;
	private int mangopayUserId;
	private int mangopayUserId_dev;
	private int mangopayWalletId;
	private int mangopayWalletId_dev;
	public Users() {
		super();
	}
	public Users(@NotNull String firstName, @NotNull String lastName, @NotNull Date creationDatetime,
			@NotNull String email, String phone, @NotNull String password, Date birthday, @NotNull String pushToken,
			int mangopayUserId, int mangopayUserId_dev, int mangopayWalletId, int mangopayWalletId_dev) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.creationDatetime = creationDatetime;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.birthday = birthday;
		this.pushToken = pushToken;
		this.mangopayUserId = mangopayUserId;
		this.mangopayUserId_dev = mangopayUserId_dev;
		this.mangopayWalletId = mangopayWalletId;
		this.mangopayWalletId_dev = mangopayWalletId_dev;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getCreationDatetime() {
		return creationDatetime;
	}
	public void setCreationDatetime(Date creationDatetime) {
		this.creationDatetime = creationDatetime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPushToken() {
		return pushToken;
	}
	public void setPushToken(String pushToken) {
		this.pushToken = pushToken;
	}
	public int getMangopayUserId() {
		return mangopayUserId;
	}
	public void setMangopayUserId(int mangopayUserId) {
		this.mangopayUserId = mangopayUserId;
	}
	public int getMangopayUserId_dev() {
		return mangopayUserId_dev;
	}
	public void setMangopayUserId_dev(int mangopayUserId_dev) {
		this.mangopayUserId_dev = mangopayUserId_dev;
	}
	public int getMangopayWalletId() {
		return mangopayWalletId;
	}
	public void setMangopayWalletId(int mangopayWalletId) {
		this.mangopayWalletId = mangopayWalletId;
	}
	public int getMangopayWalletId_dev() {
		return mangopayWalletId_dev;
	}
	public void setMangopayWalletId_dev(int mangopayWalletId_dev) {
		this.mangopayWalletId_dev = mangopayWalletId_dev;
	}
	

}
