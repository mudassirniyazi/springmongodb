package com.example.springboot.mongodb.SpringbootMongocrudoperations.model;

public class Address {

	  private String streetaddress;
	  private String phone;
	
	  private String city;
		
	  private String pincode;
	  private String country;
	public String getStreetaddress() {
		return streetaddress;
	}
	public void setStreetaddress(String streetaddress) {
		this.streetaddress = streetaddress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Address() {
		
	}
	
	public Address(String streetaddress, String phone, String city, String pincode, String country) {
		super();
		this.streetaddress = streetaddress;
		this.phone = phone;
		this.city = city;
		this.pincode = pincode;
		this.country = country;
	}
				


}
