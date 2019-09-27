package com.web_services.instant_pot.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product implements Serializable {	
	@Id
	@Column (name="product_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String name;

	private double price;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="product")
	private List<Review> reviews = new ArrayList<Review>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_product_owner")
	private Partner productOwner;
	
	private String description;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Product Details: ID=" + this.id + ", Name=" + this.name + ", Price=" + this.price + ", Description= " + this.description + ", Product Owner= " + this.productOwner.getName();
	}
}
