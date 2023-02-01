package com.evoke.amazon.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class AddressEntity {

	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	@Column(name = "street")
	private String street;
	@Column(name = "state_name")
	private String state;
	@Column(name = "pincode")
	private int pincode;
	@Column(name = "city")
	private String city;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
