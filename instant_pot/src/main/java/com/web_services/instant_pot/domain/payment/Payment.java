package com.web_services.instant_pot.domain.payment;

import java.io.Serializable;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.web_services.instant_pot.domain.address.Address;
import com.web_services.instant_pot.domain.customer.Customer;
import com.web_services.instant_pot.domain.purchase.Purchase;

public class Payment implements Serializable {
	@Id
	@Column (name="payment_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	
	private String type;
	
	private Long cardNumber;
	
	private int expirationDate;
	
	private int securityCode;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "payments")
	private HashSet<Customer> paymentOwners = new HashSet<Customer>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy="purchasePayment")
	private HashSet<Purchase> purchases = new HashSet<Purchase>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(int expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}

	public HashSet<Customer> getPaymentOwners() {
		return paymentOwners;
	}

	public void setPaymentOwners(HashSet<Customer> paymentOwners) {
		this.paymentOwners = paymentOwners;
	}
}
