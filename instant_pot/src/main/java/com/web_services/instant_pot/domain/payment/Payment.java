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

import com.web_services.instant_pot.domain.address.Address;
import com.web_services.instant_pot.domain.customer.Customer;

public class Payment implements Serializable {
	@Id
	@Column (name="payment_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	
	private String type;
	
	private Long cardNumber;
	
	private String expirationDate;
	
	private String securityCode;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "payments")
	private HashSet<Customer> paymentOwners = new HashSet<Customer>();

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

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public HashSet<Customer> getPaymentOwners() {
		return paymentOwners;
	}

	public void setPaymentOwners(HashSet<Customer> paymentOwners) {
		this.paymentOwners = paymentOwners;
	}
}
