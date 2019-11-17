package com.web_services.instant_pot.service.purchase.representation;

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
public class PurchaseRequest {
	//purchaseOwner, products, purchaseDetail, purchaseStatus, purchasePayment, address);
	
	private Long productID;
	private String purchaseDetail;
	private String purchaseStatus;
	private Long purchasePaymentID;
	private Long addressID;
	
	
	private Long purchaseOwner;
	
	public Long getpurchaseOwner() {
		return purchaseOwner;
	}
	public void setPurchaseOwner(Long purchaseOwner) {
		this.purchaseOwner = purchaseOwner;
	}
	public Long getProductID() {
		return productID;
	}
	public void setProductID(Long productID) {
		this.productID = productID;
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
	public Long getPurchasePaymentID() {
		return purchasePaymentID;
	}
	public void setPurchasePaymentID(Long purchasePaymentID) {
		this.purchasePaymentID = purchasePaymentID;
	}
	public Long getAddressID() {
		return addressID;
	}
	public void setAddressID(Long addressID) {
		this.addressID = addressID;
	}

	

	
		
}
