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
		
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private long phoneNumber;
	
	private String address;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="customer")
	private HashSet<Review> reviews = new HashSet<Review>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="purchaseOwner")
	private HashSet<Purchase> purchases = new HashSet<Purchase>();
	
	public Customer() {}
	
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
	
	public String getName() {
		return firstName + " " + lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(long number) {
		phoneNumber = number;	
	}
	
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Customer Details: ID = " + this.id + ", Name = " + this.firstName + " " + this.lastName;
	}

}
