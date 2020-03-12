
package com.driveeat.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Contact {

	// Replace with your email here:
	public static final String MY_EMAIL = "contact.driveat@gmail.com";

	// Replace password!!
	public static final String MY_PASSWORD = "DriveEat45*";

	// And receiver!
	public static final String FRIEND_EMAIL = "chaffai13@yahoo.fr";

	@Pattern(regexp = "[\\p{L} '-]+", message = "Veuillez entrer un prénom valide")
	private String firstName;

	@Pattern(regexp = "[\\p{L} '-]+", message = "Veuillez entrer un nom valide")
	private String lastName;

	@Pattern(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", message = "Veuillez entrer un email valide")
	private String mail;

	@Pattern(regexp = "(^((\\+)33|0)[1-9](\\d{2}){4}$)", message = "Veuillez entrer un numéro valide")
	private String phone;
	
	
	@Pattern(regexp = "^[\\S\\s]{1,50}$", message = "Nom du restaurant entre 1 et 50 caractères")
	private String restaurant;
	
	private String address;

	private String message;

	public Contact() {
		super();
	}

	public Contact(String firstName, String lastName, String mail, String phone, String restaurant, String address,
			String message) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.phone = phone;
		this.restaurant = restaurant;
		this.address = address;
		this.message = message;
	}

	public Contact(String firstName, String lastName, String mail, String phone, String message) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.phone = phone;
		this.message = message;
		this.restaurant = "no restaurant";
		this.address = "no address";
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}