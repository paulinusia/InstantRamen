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
public class Customer implements Serializable {
	@Id
	@Column (name="customer_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
		
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy="customer")
	private List<Review> reviews = new ArrayList<Review>();

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Customer Details: ID=" + this.id + ", Name=" + this.name;
	}
}
