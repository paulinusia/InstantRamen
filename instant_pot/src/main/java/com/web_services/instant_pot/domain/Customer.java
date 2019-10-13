package com.web_services.instant_pot.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer implements Serializable {
	@Id
	@Column (name="customer_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
		
	private String name;

	private String customerDetail;
	
	private String address;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="customer")
	private List<Review> reviews = new ArrayList<Review>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="purchaseOwner")
	private List<Purchase> purchases = new ArrayList<Purchase>();
	
	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public String getName() {
		return name;
	}	

	public void setName(String name) {
		this.name = name;
	}
	
	public String getCustomerDetail() {
		return customerDetail;
	}

	public void setCustomerDetail(String customerDetail) {
		this.customerDetail = customerDetail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Customer Details: ID=" + this.id + ", Name=" + this.name;
	}
}
