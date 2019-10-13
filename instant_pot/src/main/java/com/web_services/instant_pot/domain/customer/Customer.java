package com.web_services.instant_pot.domain.customer;

import java.io.Serializable;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.web_services.instant_pot.domain.address.AddressOwner;
import com.web_services.instant_pot.domain.purchase.Purchase;
import com.web_services.instant_pot.domain.review.Review;

@Entity
public class Customer extends AddressOwner implements Serializable {
	@Id
	@Column (name="customer_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
		
	private String name;

	private String customerDetail;
	
	private String address;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="customer")
	private HashSet<Review> reviews = new HashSet<Review>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="purchaseOwner")
	private HashSet<Purchase> purchases = new HashSet<Purchase>();
	
	public HashSet<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(HashSet<Purchase> purchases) {
		this.purchases = purchases;
	}

	public HashSet<Review> getReviews() {
		return reviews;
	}

	public void setReviews(HashSet<Review> reviews) {
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
