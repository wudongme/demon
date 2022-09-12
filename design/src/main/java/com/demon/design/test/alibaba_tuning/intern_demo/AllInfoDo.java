package com.demon.design.test.alibaba_tuning.intern_demo;

/**
 *
 * @desc
 * @fileName AllInfoDo.java
 * @date 2022/9/5/0005 15:10
 * @author Dongmo.Wu
 */
public class AllInfoDo {
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public AllInfoDo(String city, String region, String countryCode) {
		this.city = city;
		this.region = region;
		this.countryCode = countryCode;
	}

	public AllInfoDo(String city, String region, String countryCode, double longitude, double latitude) {
		this.city = city;
		this.region = region;
		this.countryCode = countryCode;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	// 共享
	private String city;
	private String region;
	private String countryCode;

	double longitude;
	double latitude;
}
