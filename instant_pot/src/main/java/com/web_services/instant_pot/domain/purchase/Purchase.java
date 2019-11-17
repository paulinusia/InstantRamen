package com.web_services.instant_pot.domain.purchase;

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

import com.web_services.instant_pot.domain.address.Address;
import com.web_services.instant_pot.domain.customer.Customer;
import com.web_services.instant_pot.domain.payment.Payment;
import com.web_services.instant_pot.domain.product.Product;

@Entity
public class Purchase implements Serializable {
	@Id
	@Column (name="purchase_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_purchase_owner")
	private Customer purchaseOwner;
	
	private String purchaseDetail;
	
	private String purchaseStatus;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_purchase_payment")
	private Payment purchasePayment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_product")
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_address")
	private Address address;
	
	public Purchase() {
		//auto
	}
	public Purchase(Customer purchaseOwner, Product product, String purchaseDetail, String purchaseStatus, Payment purchasePayment, Address address) {
		this.purchaseOwner = purchaseOwner;
		this.product = product;
		this.purchaseDetail = purchaseDetail;
		this.purchaseStatus = purchaseStatus;
		this.purchasePayment = purchasePayment;
		this.address = address;
	}

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

	public String getPurchaseStatus() {
		return purchaseStatus;
	}

	public void setPurchaseStatus(String purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}
	
	
	
	@Override
	public String toString() {
		return "Purchase [id=" + id + ", purchaseOwner=" + purchaseOwner.getName() + ", purchaseDetail=" + purchaseDetail
				+ ", purchaseStatus=" + purchaseStatus + ", purchasePayment=" + purchasePayment + "]";
	}
	
}