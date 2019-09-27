package com.web_services.instant_pot.model;

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
public class Partner implements Serializable {
	@Id
	@Column (name="partner_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="productOwner")
	private List<Product> inventory = new ArrayList<Product>();
	
	private String description;
	
	private String partnerType;
	
	private String phoneNumber;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return inventory;
	}

	public void setProducts(List<Product> products) {
		this.inventory = products;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPartnerType() {
		return partnerType;
	}

	public void setPartnerType(String partnerType) {
		this.partnerType = partnerType;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "Partner Details: ID=" + this.id + "Name=" + this.name + ", Description= " + this.description + ", Partner Type= '" + this.partnerType + "', Phone Number= " + this.phoneNumber;
	}
}
