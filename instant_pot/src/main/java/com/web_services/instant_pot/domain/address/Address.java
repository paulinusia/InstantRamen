package com.web_services.instant_pot.domain.address;

import java.io.Serializable;
//import java.util.HashSet;
//import java.util.Set;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.Transient;

//import org.codehaus.jackson.annotate.JsonIgnore;
//import org.hibernate.annotations.AnyMetaDef;
//import org.hibernate.annotations.ManyToAny;
//import org.hibernate.annotations.MetaValue;

import com.web_services.instant_pot.domain.customer.Customer;
import com.web_services.instant_pot.domain.partner.Partner;
//import com.web_services.instant_pot.domain.purchase.Purchase;

@Entity
public class Address implements Serializable {
	@Id
	@Column (name="address_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String streetAddress;
	
	private String city;
	
	private String state;
	
	private String zip;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_customer")
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_partner")
	private Partner partner;

//	@OneToMany(cascade = CascadeType.ALL, mappedBy="address")
//	private Set<Purchase> purchases = new HashSet<Purchase>();
	
	public Address(String streetAddress, String city, String state, String zip, Customer customer, Partner partner) {
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.customer = customer;
		this.partner = partner;
	}

	public Address() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
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

//	public Set<Purchase> getPurchases() {
//		return purchases;
//	}
//
//	public void setPurchases(Set<Purchase> purchases) {
//		this.purchases = purchases;
//	}
	
}
