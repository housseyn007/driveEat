package com.driveeat.config.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
@Entity
public class Restaurants {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer restaurantId;
	@NotNull
	private String name;
	@NotNull
	private String frontPicture;
	@NotNull
	private String localisation;
	@NotNull
	private String password;
	@NotNull
	@Column(unique = true)
	private String email;
	@NotNull
	private String corporatName;
	@NotNull
	private String address;
	@NotNull
	private String zipCode;
	@NotNull
	private String city;
	private float latitude;
	private float longitude;
	@Column(columnDefinition = "TEXT")
	@NotNull
	private String description;
	@NotNull
	private String siret;
	@NotNull
	private String mobilePhone;
	@NotNull
	private String landline;
	@NotNull
	private boolean acceptCash;
	@NotNull
	private boolean acceptCheck;
	@NotNull
	private boolean acceptRestaurantTicket;
	private String website;
	@NotNull
	private String facebookPageUrl;
	@NotNull
	private boolean tableRent;
	@NotNull
	private boolean printerRent;
	@NotNull
	private boolean scannerRent;
	@NotNull
	private boolean kitchenTableRent;
	@NotNull
	private String marketingFlyer;
	@NotNull
	private String marketingWrapper;
	@NotNull
	private String marketingRollUp;
	@NotNull
	private String marketingShowCase;
	private String token;
	@NotNull
	private String refreshToken;
	private Date tokenExpiringDatetime;
	@NotNull
	private String contact;
	private int mangopayUserId;
	private int mangopayWalletId;
	private int mangopayBankId;
	@NotNull
	private int mangopayUserId_dev;
	@NotNull
	private int mangopayWalletId_dev;
	@NotNull
	private int mangopayBankId_dev;
	@NotNull
	private boolean isActive;
	@NotNull
	private int maxOrdersAtATime;
	public Restaurants() {
		super();
	}
	public Restaurants(@NotNull String name, @NotNull String frontPicture, @NotNull String localisation,
			@NotNull String password, @NotNull String email, @NotNull String corporatName, @NotNull String address,
			@NotNull String zipCode, @NotNull String city, float latitude, float longitude, @NotNull String description,
			@NotNull String siret, @NotNull String mobilePhone, @NotNull String landline, @NotNull boolean acceptCash,
			@NotNull boolean acceptCheck, @NotNull boolean acceptRestaurantTicket, String website,
			@NotNull String facebookPageUrl, @NotNull boolean tableRent, @NotNull boolean printerRent,
			@NotNull boolean scannerRent, @NotNull boolean kitchenTableRent, @NotNull String marketingFlyer,
			@NotNull String marketingWrapper, @NotNull String marketingRollUp, @NotNull String marketingShowCase,
			String token, @NotNull String refreshToken, Date tokenExpiringDatetime, @NotNull String contact,
			int mangopayUserId, int mangopayWalletId, int mangopayBankId, @NotNull int mangopayUserId_dev,
			@NotNull int mangopayWalletId_dev, @NotNull int mangopayBankId_dev, @NotNull boolean isActive,
			@NotNull int maxOrdersAtATime) {
		super();
		this.name = name;
		this.frontPicture = frontPicture;
		this.localisation = localisation;
		this.password = password;
		this.email = email;
		this.corporatName = corporatName;
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
		this.description = description;
		this.siret = siret;
		this.mobilePhone = mobilePhone;
		this.landline = landline;
		this.acceptCash = acceptCash;
		this.acceptCheck = acceptCheck;
		this.acceptRestaurantTicket = acceptRestaurantTicket;
		this.website = website;
		this.facebookPageUrl = facebookPageUrl;
		this.tableRent = tableRent;
		this.printerRent = printerRent;
		this.scannerRent = scannerRent;
		this.kitchenTableRent = kitchenTableRent;
		this.marketingFlyer = marketingFlyer;
		this.marketingWrapper = marketingWrapper;
		this.marketingRollUp = marketingRollUp;
		this.marketingShowCase = marketingShowCase;
		this.token = token;
		this.refreshToken = refreshToken;
		this.tokenExpiringDatetime = tokenExpiringDatetime;
		this.contact = contact;
		this.mangopayUserId = mangopayUserId;
		this.mangopayWalletId = mangopayWalletId;
		this.mangopayBankId = mangopayBankId;
		this.mangopayUserId_dev = mangopayUserId_dev;
		this.mangopayWalletId_dev = mangopayWalletId_dev;
		this.mangopayBankId_dev = mangopayBankId_dev;
		this.isActive = isActive;
		this.maxOrdersAtATime = maxOrdersAtATime;
	}
	public Integer getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFrontPicture() {
		return frontPicture;
	}
	public void setFrontPicture(String frontPicture) {
		this.frontPicture = frontPicture;
	}
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCorporatName() {
		return corporatName;
	}
	public void setCorporatName(String corporatName) {
		this.corporatName = corporatName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSiret() {
		return siret;
	}
	public void setSiret(String siret) {
		this.siret = siret;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getLandline() {
		return landline;
	}
	public void setLandline(String landline) {
		this.landline = landline;
	}
	public boolean isAcceptCash() {
		return acceptCash;
	}
	public void setAcceptCash(boolean acceptCash) {
		this.acceptCash = acceptCash;
	}
	public boolean isAcceptCheck() {
		return acceptCheck;
	}
	public void setAcceptCheck(boolean acceptCheck) {
		this.acceptCheck = acceptCheck;
	}
	public boolean isAcceptRestaurantTicket() {
		return acceptRestaurantTicket;
	}
	public void setAcceptRestaurantTicket(boolean acceptRestaurantTicket) {
		this.acceptRestaurantTicket = acceptRestaurantTicket;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getFacebookPageUrl() {
		return facebookPageUrl;
	}
	public void setFacebookPageUrl(String facebookPageUrl) {
		this.facebookPageUrl = facebookPageUrl;
	}
	public boolean isTableRent() {
		return tableRent;
	}
	public void setTableRent(boolean tableRent) {
		this.tableRent = tableRent;
	}
	public boolean isPrinterRent() {
		return printerRent;
	}
	public void setPrinterRent(boolean printerRent) {
		this.printerRent = printerRent;
	}
	public boolean isScannerRent() {
		return scannerRent;
	}
	public void setScannerRent(boolean scannerRent) {
		this.scannerRent = scannerRent;
	}
	public boolean isKitchenTableRent() {
		return kitchenTableRent;
	}
	public void setKitchenTableRent(boolean kitchenTableRent) {
		this.kitchenTableRent = kitchenTableRent;
	}
	public String getMarketingFlyer() {
		return marketingFlyer;
	}
	public void setMarketingFlyer(String marketingFlyer) {
		this.marketingFlyer = marketingFlyer;
	}
	public String getMarketingWrapper() {
		return marketingWrapper;
	}
	public void setMarketingWrapper(String marketingWrapper) {
		this.marketingWrapper = marketingWrapper;
	}
	public String getMarketingRollUp() {
		return marketingRollUp;
	}
	public void setMarketingRollUp(String marketingRollUp) {
		this.marketingRollUp = marketingRollUp;
	}
	public String getMarketingShowCase() {
		return marketingShowCase;
	}
	public void setMarketingShowCase(String marketingShowCase) {
		this.marketingShowCase = marketingShowCase;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public Date getTokenExpiringDatetime() {
		return tokenExpiringDatetime;
	}
	public void setTokenExpiringDatetime(Date tokenExpiringDatetime) {
		this.tokenExpiringDatetime = tokenExpiringDatetime;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getMangopayUserId() {
		return mangopayUserId;
	}
	public void setMangopayUserId(int mangopayUserId) {
		this.mangopayUserId = mangopayUserId;
	}
	public int getMangopayWalletId() {
		return mangopayWalletId;
	}
	public void setMangopayWalletId(int mangopayWalletId) {
		this.mangopayWalletId = mangopayWalletId;
	}
	public int getMangopayBankId() {
		return mangopayBankId;
	}
	public void setMangopayBankId(int mangopayBankId) {
		this.mangopayBankId = mangopayBankId;
	}
	public int getMangopayUserId_dev() {
		return mangopayUserId_dev;
	}
	public void setMangopayUserId_dev(int mangopayUserId_dev) {
		this.mangopayUserId_dev = mangopayUserId_dev;
	}
	public int getMangopayWalletId_dev() {
		return mangopayWalletId_dev;
	}
	public void setMangopayWalletId_dev(int mangopayWalletId_dev) {
		this.mangopayWalletId_dev = mangopayWalletId_dev;
	}
	public int getMangopayBankId_dev() {
		return mangopayBankId_dev;
	}
	public void setMangopayBankId_dev(int mangopayBankId_dev) {
		this.mangopayBankId_dev = mangopayBankId_dev;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getMaxOrdersAtATime() {
		return maxOrdersAtATime;
	}
	public void setMaxOrdersAtATime(int maxOrdersAtATime) {
		this.maxOrdersAtATime = maxOrdersAtATime;
	}
	
	
	
	
}
