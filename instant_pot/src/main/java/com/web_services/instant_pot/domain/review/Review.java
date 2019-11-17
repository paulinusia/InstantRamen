package com.web_services.instant_pot.domain.review;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;

import com.web_services.instant_pot.domain.customer.Customer;
import com.web_services.instant_pot.domain.product.Product;

@Entity
public class Review implements Serializable {
	@Id
	@Column (name="review_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_product")
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_customer")
	private Customer customer;
	
	private int rating;

	private Long timestamp;
	
	private String body;
	

	
	public Review() {}

	public Review(Customer customers, Product products, int rating, String reviewBody, Long timestamp) {
		this.customer = customers;
		this.product = products;
		this.rating = rating;
		this.body = reviewBody;
		this.timestamp = timestamp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getReviewRating() {
		return rating;
	}
	
	public void setReviewRating(int rating) {
		this.rating = rating;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	

	
	
	@Override
	public String toString() {
		return "Review Details: ID=" + this.id + "Product=" + this.product.getProductName() +  ", Customer=" + this.customer.getName() + ", Rating= " + this.rating + ", Comment= '" + this.body + ", Timestamp= '" + this.timestamp ;
	}
}
