package com.web_services.instant_pot.domain.address;

import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.web_services.instant_pot.domain.purchase.Purchase;

public class Address {
	@Id
	@Column (name="address_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String streetAddress;
	
	private String city;
	
	private String state;
	
	private String zip;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "address")
	private AddressOwner addressOwner;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="address")
	private HashSet<Purchase> purchases = new HashSet<Purchase>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public AddressOwner getAddressOwner() {
		return addressOwner;
	}

	public void setAddressOwner(AddressOwner addressOwner) {
		this.addressOwner = addressOwner;
	}

	public HashSet<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(HashSet<Purchase> purchases) {
		this.purchases = purchases;
	}
	
}
