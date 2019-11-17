package com.web_services.instant_pot.service.review.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.web_services.instant_pot.domain.customer.Customer;
import com.web_services.instant_pot.domain.product.Product;

@XmlRootElement(name = "Review")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class ReviewRepresentation {
	private Long id;
	private Long customerID;
	private int rating;
	private Long timestamp;
	private String body;
	private Long productID;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}
	
	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}
	
	
	public int getReviewRating() {
		return rating;
	}
	
	public void setReviewRating(int rating) {
		this.rating = rating;
	}
	
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Long getTimestamp() {
		return timestamp;
	}
	

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
		
	
}
