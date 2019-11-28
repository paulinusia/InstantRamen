package com.web_services.instant_pot.domain.payment;

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

import com.web_services.instant_pot.domain.address.Address;
import com.web_services.instant_pot.domain.customer.Customer;
import com.web_services.instant_pot.domain.purchase.Purchase;

@Entity
public class Payment implements Serializable {
	@Id
	@Column (name="payment_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String type;
	
	private Long cardNumber;
	
	private int expirationDate;
	
	private int securityCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_customer")
	private Customer paymentOwner;

//	@OneToMany(cascade = CascadeType.ALL, mappedBy="purchasePayment")
//	private Set<Purchase> purchases = new HashSet<Purchase>();
	
	public Payment(){}
	
	public Payment(String type, Long cardNumber, int expirationDate, int securityCode, Customer paymentOwner) {
		this.type = type;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.securityCode = securityCode;
		this.paymentOwner = paymentOwner;
	}

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

	public Customer getPaymentOwner() {
		return paymentOwner;
	}

	public void setPaymentOwner(Customer paymentOwner) {
		this.paymentOwner = paymentOwner;
	}
//
//	public Set<Purchase> getPurchases() {
//		return purchases;
//	}
//
//	public void setPurchases(Set<Purchase> purchases) {
//		this.purchases = purchases;
//	}
	
}
