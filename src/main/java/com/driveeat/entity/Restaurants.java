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
@Table(name = "Restaurants")
public class Restaurants {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	private String corporateName;
	@NotNull
	private String address;
	@NotNull
	private String zipCode;
	@NotNull
	private String city;
	private Float latitude;
	private Float longitude;
	@Column(columnDefinition = "TEXT")
	@NotNull
	private String description;
	@NotNull
	private String siret;
	@NotNull
	private String mobilePhone;
	@NotNull
	private String landline;
	@Column(columnDefinition = "tinyint(1) default 1")
	@NotNull
	private boolean acceptCash;
	@Column(columnDefinition = "tinyint(1) default 1")
	@NotNull
	private boolean acceptCheck;
	@Column(columnDefinition = "tinyint(1) default 1")
	@NotNull
	private boolean acceptRestaurantTicket;
	private String website;
	@NotNull
	private String facebookPageUrl;
	@Column(columnDefinition = "tinyint(1) default 1")
	@NotNull
	private boolean tabletRent;
	@Column(columnDefinition = "tinyint(1) default 1")
	@NotNull
	private boolean printerRent;
	@Column(columnDefinition = "tinyint(1) default 1")
	@NotNull
	private boolean scannerRent;
	@Column(columnDefinition = "tinyint(1) default 1")
	@NotNull
	private boolean kitchenTabletRent;
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
	@Temporal(TemporalType.TIMESTAMP)
	private Date tokenExpiringDatetime;;
	@NotNull
	private String contact;
	private Integer mangopayUserId;
	private Integer mangopayWalletId;
	private Integer mangopayBankId;
	@NotNull
	private Integer mangopayUserId_dev;
	@NotNull
	private Integer mangopayWalletId_dev;
	@NotNull
	private Integer mangopayBankId_dev;
	@Column(columnDefinition = "tinyint(1) default 1")
	@NotNull
	private boolean isActive;
	@NotNull
	private Integer maxOrdersAtATime;

	public Restaurants() {
		super();
	}

	public Restaurants(Integer restaurantId, @NotNull String name, @NotNull String frontPicture,
			@NotNull String localisation, @NotNull String password, @NotNull String email,
			@NotNull String corporateName, @NotNull String address, @NotNull String zipCode, @NotNull String city,
			Float latitude, Float longitude, @NotNull String description, @NotNull String siret,
			@NotNull String mobilePhone, @NotNull String landline, @NotNull boolean acceptCash,
			@NotNull boolean acceptCheck, @NotNull boolean acceptRestaurantTicket, String website,
			@NotNull String facebookPageUrl, @NotNull boolean tabletRent, @NotNull boolean printerRent,
			@NotNull boolean scannerRent, @NotNull boolean kitchenTabletRent, @NotNull String marketingFlyer,
			@NotNull String marketingWrapper, @NotNull String marketingRollUp, @NotNull String marketingShowCase,
			String token, @NotNull String refreshToken, Date tokenExpiringDatetime, @NotNull String contact,
			Integer mangopayUserId, Integer mangopayWalletId, Integer mangopayBankId,
			@NotNull Integer mangopayUserId_dev, @NotNull Integer mangopayWalletId_dev,
			@NotNull Integer mangopayBankId_dev, @NotNull boolean isActive, @NotNull Integer maxOrdersAtATime) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.frontPicture = frontPicture;
		this.localisation = localisation;
		this.password = password;
		this.email = email;
		this.corporateName = corporateName;
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
		this.tabletRent = tabletRent;
		this.printerRent = printerRent;
		this.scannerRent = scannerRent;
		this.kitchenTabletRent = kitchenTabletRent;
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

	public String getCorporateName() {
		return corporateName;
	}

	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
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

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
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

	public boolean isTabletRent() {
		return tabletRent;
	}

	public void setTabletRent(boolean tabletRent) {
		this.tabletRent = tabletRent;
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

	public boolean isKitchenTabletRent() {
		return kitchenTabletRent;
	}

	public void setKitchenTabletRent(boolean kitchenTabletRent) {
		this.kitchenTabletRent = kitchenTabletRent;
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

	public Integer getMangopayUserId() {
		return mangopayUserId;
	}

	public void setMangopayUserId(Integer mangopayUserId) {
		this.mangopayUserId = mangopayUserId;
	}

	public Integer getMangopayWalletId() {
		return mangopayWalletId;
	}

	public void setMangopayWalletId(Integer mangopayWalletId) {
		this.mangopayWalletId = mangopayWalletId;
	}

	public Integer getMangopayBankId() {
		return mangopayBankId;
	}

	public void setMangopayBankId(Integer mangopayBankId) {
		this.mangopayBankId = mangopayBankId;
	}

	public Integer getMangopayUserId_dev() {
		return mangopayUserId_dev;
	}

	public void setMangopayUserId_dev(Integer mangopayUserId_dev) {
		this.mangopayUserId_dev = mangopayUserId_dev;
	}

	public Integer getMangopayWalletId_dev() {
		return mangopayWalletId_dev;
	}

	public void setMangopayWalletId_dev(Integer mangopayWalletId_dev) {
		this.mangopayWalletId_dev = mangopayWalletId_dev;
	}

	public Integer getMangopayBankId_dev() {
		return mangopayBankId_dev;
	}

	public void setMangopayBankId_dev(Integer mangopayBankId_dev) {
		this.mangopayBankId_dev = mangopayBankId_dev;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getMaxOrdersAtATime() {
		return maxOrdersAtATime;
	}

	public void setMaxOrdersAtATime(Integer maxOrdersAtATime) {
		this.maxOrdersAtATime = maxOrdersAtATime;
	}
	
	
	
	
}
