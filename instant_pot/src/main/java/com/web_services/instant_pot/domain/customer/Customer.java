package com.web_services.instant_pot.domain.customer;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.web_services.instant_pot.domain.address.Address;
import com.web_services.instant_pot.domain.address.AddressOwner;
import com.web_services.instant_pot.domain.payment.Payment;
import com.web_services.instant_pot.domain.purchase.Purchase;
import com.web_services.instant_pot.domain.review.Review;

@Entity
public class Customer implements Serializable {
	@Id
	@Column (name="customer_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
		
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private long phoneNumber;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "customer_payment", joinColumns = { @JoinColumn(name = "customer_id" ) }, inverseJoinColumns = { @JoinColumn(name = "payment_id") })
	private Set<Payment> payments = new HashSet<Payment>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "customer_address", joinColumns = { @JoinColumn(name = "customer_id" ) }, inverseJoinColumns = { @JoinColumn(name = "address_id") })
	private Set<Address> addresses = new HashSet<Address>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy="customer")
	private Set<Review> reviews = new HashSet<Review>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="purchaseOwner")
	private Set<Purchase> purchases = new HashSet<Purchase>();
	
	public Customer() {}
	
	public Customer(String firstName, String lastName, String email, long phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

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
	
	public Set<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(HashSet<Purchase> purchases) {
		this.purchases = purchases;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(HashSet<Review> reviews) {
		this.reviews = reviews;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Customer Details: ID = " + this.id + ", Name = " + this.firstName + " " + this.lastName;
	}

}
