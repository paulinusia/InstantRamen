package com.web_services.instant_pot.service.review.representation;

import com.web_services.instant_pot.domain.customer.Customer;
import com.web_services.instant_pot.domain.product.Product;

public class ReviewRequest {
	private Long id;
	
	private Customer customer;
	
	private int rating;

	private Long timestamp;
	
	private String body;
	
	private Product product;
	

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

}
