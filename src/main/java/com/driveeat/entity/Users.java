package com.driveeat.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	@Size(min=2, max=80)
	@NotNull(message = "Veuillez entrer un prénom !")
	@Pattern(regexp = "[\\p{L} '-]+", message = "Veuillez entrer un prénom valide")
	private String firstName;

	@Size(min=2, max=80)
	@NotNull(message = "Veuillez entrer un nom !")
	@Pattern(regexp = "[\\p{L} '-]+", message = "Veuillez entrer un nom valide")
	private String lastName;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date creationDatetime;
	
	@Email
	@NotNull(message = "Veuillez entrer un email !")
	@Pattern(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", message = "Veuillez entrer un email valide")
	private String email;
	
	@Size(min=10, max=15)
	@Pattern(regexp = "(^((\\+)33|0)[1-9](\\d{2}){4}$)", message = "Veuillez entrer un numéro valide")
	private String phone;
	
	@Size(min=8, max=80)
	@NotNull(message = "Veuillez entrer un password !")
	private String password;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date birthday;
	
	@NotNull
	private String pushToken;
	private Integer mangopayUserId;
	private Integer mangopayUserId_dev;
	private Integer mangopayWalletId;
	private Integer mangopayWalletId_dev;
	
	public Users() {
		super();
	}

	public Users(Integer userId, @NotNull String firstName, @NotNull String lastName, @NotNull Date creationDatetime,
			@NotNull String email, String phone, @NotNull String password, Date birthday, @NotNull String pushToken,
			Integer mangopayUserId, Integer mangopayUserId_dev, Integer mangopayWalletId,
			Integer mangopayWalletId_dev) {
		super();
		this.userId = userId;
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

	public Integer getMangopayUserId() {
		return mangopayUserId;
	}

	public void setMangopayUserId(Integer mangopayUserId) {
		this.mangopayUserId = mangopayUserId;
	}

	public Integer getMangopayUserId_dev() {
		return mangopayUserId_dev;
	}

	public void setMangopayUserId_dev(Integer mangopayUserId_dev) {
		this.mangopayUserId_dev = mangopayUserId_dev;
	}

	public Integer getMangopayWalletId() {
		return mangopayWalletId;
	}

	public void setMangopayWalletId(Integer mangopayWalletId) {
		this.mangopayWalletId = mangopayWalletId;
	}

	public Integer getMangopayWalletId_dev() {
		return mangopayWalletId_dev;
	}

	public void setMangopayWalletId_dev(Integer mangopayWalletId_dev) {
		this.mangopayWalletId_dev = mangopayWalletId_dev;
	}
	
}



