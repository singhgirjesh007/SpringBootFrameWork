package com.countryservice.demo.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Country")
public class Country {
	
	@Id //for primay key
	@Column(name="id")
	int id;
	
	
	@Column(name="country")
	String countryName;
	
	@Column(name="country_name")
	String countryCapital;
	
	public Country() {
		
	}
	
	
	public Country(int id, String countryName, String countryCapital) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.countryName = countryName;
		this.countryCapital = countryCapital;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryCapital() {
		return countryCapital;
	}
	public void setCountryCapital(String countryCapital) {
		this.countryCapital = countryCapital;
	}

}
