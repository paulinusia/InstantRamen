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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.web_services.instant_pot.domain.address.Address;
import com.web_services.instant_pot.domain.customer.Customer;
import com.web_services.instant_pot.domain.product.Product;

@Entity
public class Purchase implements Serializable {
	@Id
	@Column (name="purchase_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_purchase_owner")
	

	private Customer purchaseOwner;
	
	private String purchaseDetail;
	
	private String purchaseStatus;
	
	private String purchasePayment;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "purchases")
	private Set<Product> products = new HashSet<Product>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_address")
	private Address address;
	
	public Purchase() {
		//auto
	}
	public Purchase(Long id, Customer purchaseOwner2, String purchaseDetail2, String purchaseStatus2, String purchasePayment2) {
		this.id = id;
		this.purchaseOwner = purchaseOwner2;
		this.purchaseDetail = purchaseDetail2;
		this.purchaseStatus = purchaseStatus2;
		this.purchasePayment = purchasePayment2;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
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

	public String getPurchasePayment() {
		return purchasePayment;
	}

	public void setPurchasePayment(String purchasePayment) {
		this.purchasePayment = purchasePayment;
	}
	
	@Override
	public String toString() {
		return "Purchase [id=" + id + ", purchaseOwner=" + purchaseOwner.getName() + ", purchaseDetail=" + purchaseDetail
				+ ", purchaseStatus=" + purchaseStatus + ", purchasePayment=" + purchasePayment + "]";
	}

}