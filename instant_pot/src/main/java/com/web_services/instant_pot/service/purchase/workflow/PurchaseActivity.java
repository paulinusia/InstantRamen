package com.web_services.instant_pot.service.purchase.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.web_services.instant_pot.dal.purchase.PurchaseDAL;
import com.web_services.instant_pot.domain.address.Address;
import com.web_services.instant_pot.domain.customer.Customer;
import com.web_services.instant_pot.domain.payment.Payment;
import com.web_services.instant_pot.domain.product.Product;
import com.web_services.instant_pot.domain.product.ProductLogic;
import com.web_services.instant_pot.domain.purchase.Purchase;
import com.web_services.instant_pot.domain.purchase.PurchaseLogic;
import com.web_services.instant_pot.service.product.representation.ProductRepresentation;
import com.web_services.instant_pot.service.purchase.representation.PurchaseRepresentation;



public class PurchaseActivity {

	private static PurchaseLogic pl = new PurchaseLogic();
	
	public PurchaseRepresentation getPurchaseByID(Long id) {
		Purchase purchase = pl.getPurchaseByID(id);
		
		PurchaseRepresentation pRep = new PurchaseRepresentation();
		
		pRep.setAddress(purchase.getAddress());
		pRep.setId(purchase.getId());
		pRep.setProduct(purchase.getProduct());
		pRep.setPurchaseDetail(purchase.getPurchaseDetail());
		pRep.setPurchaseOwner(purchase.getPurchaseOwner());
		pRep.setPurchasePayment(purchase.getPurchasePayment());
		pRep.setPurchaseStatus(purchase.getPurchaseStatus());
		
		return pRep;
	}
	
	
	
	public PurchaseRepresentation newPurchase(Customer purchaseOwner, Product product, String purchaseDetail, String purchaseStatus, Payment purchasePayment, Address address) {
	Purchase purchase = pl.newPurchase(purchaseOwner, product, purchaseDetail, purchaseStatus, purchasePayment, address);
	
	PurchaseRepresentation pRep = new PurchaseRepresentation();
	pRep.setPurchaseOwner(purchase.getPurchaseOwner());
	pRep.setProduct(purchase.getProduct());
	pRep.setPurchaseDetail(purchase.getPurchaseDetail());
	pRep.setPurchaseStatus(purchase.getPurchaseStatus());
	pRep.setPurchasePayment(purchase.getPurchasePayment());
	pRep.setAddress(purchase.getAddress());
	
	return pRep;
	}
	
	
	
	public PurchaseRepresentation updatePurchaseDetail(Long id, String purchaseDetail) {
		Purchase purchase = pl.getPurchaseByID(id);
		
		PurchaseRepresentation pRep = new PurchaseRepresentation();
		
		pRep.setPurchaseDetail(purchaseDetail);
		
		pRep.setAddress(purchase.getAddress());
		pRep.setPurchaseOwner(purchase.getPurchaseOwner());
		pRep.setProduct(purchase.getProduct());
		pRep.setPurchaseStatus(purchase.getPurchaseStatus());
		pRep.setPurchasePayment(purchase.getPurchasePayment());
		
		return pRep;
	}
	
	public PurchaseRepresentation updatePurchaseStatus(Long id, String purchaseStatus) {
		Purchase purchase = pl.getPurchaseByID(id);
		
		PurchaseRepresentation pRep = new PurchaseRepresentation();
		
		pRep.setPurchaseStatus(purchaseStatus);
		pRep.setAddress(purchase.getAddress());
		pRep.setPurchaseOwner(purchase.getPurchaseOwner());
		pRep.setProduct(purchase.getProduct());
		pRep.setPurchasePayment(purchase.getPurchasePayment());
		pRep.setPurchaseDetail(purchase.getPurchaseDetail());
		
		return pRep;
		
	}
	
	private static PurchaseRepresentation getPurchaseRepresentation(Purchase purchase) {
		PurchaseRepresentation purchaseRepresentation = new PurchaseRepresentation();
		
		purchaseRepresentation.setId(purchase.getId());
		purchaseRepresentation.setAddress(purchase.getAddress());
		purchaseRepresentation.setPurchaseOwner(purchase.getPurchaseOwner());
		purchaseRepresentation.setProduct(purchase.getProduct());
		purchaseRepresentation.setPurchaseDetail(purchase.getPurchaseDetail());
		purchaseRepresentation.setPurchaseStatus(purchase.getPurchaseStatus());
		
		return purchaseRepresentation;
	}
	
	public Set<PurchaseRepresentation> getPurchasesFromCustomer(Long customerID){
			Set<Purchase> purchases = new HashSet<Purchase>();
			Set<PurchaseRepresentation> purchaseRepresentations = new HashSet<PurchaseRepresentation>();	
			purchases = pl.getAllPurchasesByCustomer(customerID);

		for (Purchase purchase : purchases) {
			PurchaseRepresentation purchaseRepresentation = getPurchaseRepresentation(purchase);
			purchaseRepresentations.add(purchaseRepresentation);
		}
		return purchaseRepresentations;
	}
	
}