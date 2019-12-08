package com.web_services.instant_pot.domain.purchase;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.web_services.instant_pot.dal.product.ProductDAL;
import com.web_services.instant_pot.dal.purchase.PurchaseDAL;
import com.web_services.instant_pot.domain.address.Address;
import com.web_services.instant_pot.domain.customer.Customer;
import com.web_services.instant_pot.domain.partner.Partner;
import com.web_services.instant_pot.domain.payment.Payment;
import com.web_services.instant_pot.domain.product.Product;


public class PurchaseLogic {
	
	public Purchase getPurchaseByID(Long id) {
		PurchaseDAL pd = new PurchaseDAL();
		return pd.getPurchaseByID(id);
	}
	
	public Purchase newPurchase(Long CustomerID, Long productID, String purchaseDetail, String purchaseStatus, Long payment, Long addressID) {
		PurchaseDAL pd = new PurchaseDAL();
		return pd.newPurchase(CustomerID, productID, purchaseDetail, purchaseStatus, payment, addressID);
	}
	
	public Purchase updatePurchaseDetail(Long id, String purchaseDetail) {
		PurchaseDAL purchase = new PurchaseDAL();
	    return purchase.updatePurchaseDetail(id,purchaseDetail);
	}
	
	public Purchase updatePurchaseStatus(Long id, String purchaseStatus) {
		PurchaseDAL purchase = new PurchaseDAL();
	    return purchase.updatePurchaseStatus(id,purchaseStatus);
	}
	
	public Set<Purchase> getAllPurchasesByCustomer(Long customerID){
		PurchaseDAL pd = new PurchaseDAL();
		return pd.getAllPurchasesByCustomer(customerID);
	}

	public Set<Purchase> getAllPurchasesByProduct(Long productID){
		PurchaseDAL pd = new PurchaseDAL();
		return pd.getAllPurchasesByCustomer(productID);
	}
}
