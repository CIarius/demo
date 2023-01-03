package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customer_id")
	private Integer customerId;
	
	@Column(name="name")
	private String name; 

	@Column(name="address")	
	private String address;
	
	@Column(name="website")
	private String website;
	
	@Column(name="credit_limit")
	private Float creditLimit;

	public Customer() {
		super();
	}

	public Customer(String name, String address, String website, Float creditLimit) {
		this.name = name;
		this.address = address;
		this.website = website;
		this.creditLimit = creditLimit;
	}

	@Column(name="customer_id")
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerID) {
		this.customerId = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Float getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(Float creditLimit) {
		this.creditLimit = creditLimit;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", name=" + name + ", address=" + address + ", website=" + website
				+ ", creditLimit=" + creditLimit + "]";
	}
	
}
