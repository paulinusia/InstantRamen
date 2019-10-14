package com.web_services.instant_pot.domain.partner;

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
import com.web_services.instant_pot.domain.product.Product;

@Entity
public class Partner extends AddressOwner implements Serializable {
	@Id
	@Column (name="partner_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="productOwner")
	private HashSet<Product> inventory = new HashSet<Product>();
	
	private String description;
	
	private String partnerType;
	
	private long phoneNumber;
	
	public Partner(String name, String partnerType, String description) {
		this.name = name;
		this.partnerType = partnerType;
		this.description = description;
	}
	
	public Partner() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashSet<Product> getProducts() {
		return inventory;
	}

	public void setProducts(HashSet<Product> products) {
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

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "Partner Details: ID=" + this.id + "Name=" + this.name + ", Description= " + this.description + ", Partner Type= '" + this.partnerType + "', Phone Number= " + this.phoneNumber;
	}
}
