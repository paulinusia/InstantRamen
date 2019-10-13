package com.web_services.instant_pot.domain.product;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.web_services.instant_pot.domain.partner.Partner;
import com.web_services.instant_pot.domain.purchase.Purchase;
import com.web_services.instant_pot.domain.review.Review;

@Entity
public class Product implements Serializable {	
	@Id
	@Column (name="product_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String name;

	private double price;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="product")
	private HashSet<Review> reviews = new HashSet<Review>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_product_owner")
	private Partner productOwner;
	
	private String description;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "product_purchase", joinColumns = { @JoinColumn(name = "product_id" ) }, inverseJoinColumns = { @JoinColumn(name = "purchase_id") })
	private Set<Purchase> purchases;
	
	public Partner getProductOwner() {
		return productOwner;
	}

	public void setProductOwner(Partner productOwner) {
		this.productOwner = productOwner;
	}

	public Set<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(Set<Purchase> purchases) {
		this.purchases = purchases;
	}

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

	public HashSet<Review> getReviews() {
		return reviews;
	}

	public void setReviews(HashSet<Review> reviews) {
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
