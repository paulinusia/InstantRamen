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
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonManagedReference;

import com.web_services.instant_pot.domain.partner.Partner;
import com.web_services.instant_pot.domain.purchase.Purchase;
import com.web_services.instant_pot.domain.review.Review;

@Entity
public class Product implements Serializable {	
	@Id
	@Column (name="product_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="product")
	private Set<Review> reviews = new HashSet<Review>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_product_owner")
	private Partner productOwner;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	private Set<Purchase> purchases = new HashSet<Purchase>();
	
	private String productName;
	
	private String productDescription;
	
	private double cost;

	public Product() {}
	
	public Product(Partner productOwner, String productName, String productDescription, double cost) {
		this.productOwner = productOwner;
		this.productName = productName;
		this.productDescription = productDescription;
		this.cost = cost;
		}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

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

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(HashSet<Review> reviews) {
		this.reviews = reviews;
	}
	
	@Override
	public String toString() {
		return "Product Details: ID=" + this.id + ", Name=" + this.productName + ", Price=" + this.cost + ", Description= " + this.productDescription + ", Product Owner= " + this.productOwner.getName();
	}
}
