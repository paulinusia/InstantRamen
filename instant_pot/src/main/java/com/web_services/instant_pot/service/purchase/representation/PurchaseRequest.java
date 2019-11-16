package com.web_services.instant_pot.service.purchase.representation;

import java.util.Set;

import com.web_services.instant_pot.domain.address.Address;
import com.web_services.instant_pot.domain.customer.Customer;
import com.web_services.instant_pot.domain.payment.Payment;
import com.web_services.instant_pot.domain.product.Product;

public class PurchaseRequest {
	//purchaseOwner, products, purchaseDetail, purchaseStatus, purchasePayment, address);
	
	private Customer purchaseOwner;
	private Product product;
	private String purchaseDetail;
	private String purchaseStatus;
	private Payment purchasePayment;
	private Address address;

	public Customer getPurchaseOwner() {
		return purchaseOwner;
	}

	public void setPurchaseOwner(Customer purchaseOwner) {
		this.purchaseOwner = purchaseOwner;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getPurchaseDetail() {
		return purchaseDetail;
	}

	public void setPurchaseDetail(String purchaseDetail) {
		this.purchaseDetail = purchaseDetail;
		}
	
	public String getPurchaseStatus() {
		return purchaseStatus;
	}
	
	//Allows people to cancel their order if necessary
	public void setPurchaseStatus(String purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}
	
	public Payment getPurchasePayment() {
		return purchasePayment;
	}
	
	public void setPurchasePayment(Payment purchasePayment) {
		this.purchasePayment = purchasePayment;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
		
}
