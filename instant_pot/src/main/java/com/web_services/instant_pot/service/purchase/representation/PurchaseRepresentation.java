package com.web_services.instant_pot.service.purchase.representation;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.web_services.instant_pot.domain.address.Address;
import com.web_services.instant_pot.domain.customer.Customer;
import com.web_services.instant_pot.domain.payment.Payment;
import com.web_services.instant_pot.domain.product.Product;

@XmlRootElement(name = "Purchase")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class PurchaseRepresentation {
	private Long id;
	
	private Customer purchaseOwner;
	
	private String purchaseDetail;
	
	private String purchaseStatus;
	
	private Payment purchasePayment;
	
	private Address address;
	
	private Product product;
	

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public void setPurchasePayment(Payment purchasePayment) {
		this.purchasePayment = purchasePayment;
	}
	
	public Payment getPurchasePayment() {
		return purchasePayment;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getPurchaseOwner() {
		return purchaseOwner;
	}

	public void setPurchaseOwner(Customer purchaseOwner) {
		this.purchaseOwner = purchaseOwner;
	}

	public String getPurchaseDetail() {
		return purchaseDetail;
	}

	public void setPurchaseDetail(String purchaseDetail) {
		this.purchaseDetail = purchaseDetail;
	}

	//Allows people to cancel their order if necessary
	public String getPurchaseStatus() {
		return purchaseStatus;
	}

	public void setPurchaseStatus(String purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}
	


}
