package com.web_services.instant_pot.service.purchase.workflow;

import java.util.HashSet;
//import java.util.Iterator;
import java.util.Set;

import com.web_services.instant_pot.domain.purchase.Purchase;
import com.web_services.instant_pot.domain.purchase.PurchaseLogic;
import com.web_services.instant_pot.service.purchase.representation.PurchaseRepresentation;
import com.web_services.instant_pot.service.purchase.representation.PurchaseRequest;



public class PurchaseActivity {

	private static PurchaseLogic pl = new PurchaseLogic();
	
	public PurchaseRepresentation getPurchaseByID(Long id) {
		Purchase purchase = pl.getPurchaseByID(id);
		
		PurchaseRepresentation pRep = new PurchaseRepresentation();
		
		pRep.setAddressID(purchase.getAddress().getId());
		pRep.setProductID(purchase.getProduct().getId());
		pRep.setPurchaseDetail(purchase.getPurchaseDetail());
		pRep.setPurchaseOwner(purchase.getPurchaseOwner().getId());
		pRep.setPurchasePaymentID(purchase.getPurchasePayment().getId());
		pRep.setPurchaseStatus(purchase.getPurchaseStatus());
		
		return pRep;
	}
	
	
	
	public PurchaseRepresentation newPurchase(Long purchaseOwner, Long product, String purchaseDetail, String purchaseStatus, Long purchasePayment, Long address) {
	Purchase purchase = pl.newPurchase(purchaseOwner, product, purchaseDetail, purchaseStatus, purchasePayment, address);
	
	PurchaseRepresentation pRep = new PurchaseRepresentation();
	
	
	pRep.setPurchaseOwner(purchase.getPurchaseOwner().getId());
	pRep.setProductID(purchase.getProduct().getId());
	pRep.setPurchaseStatus(purchase.getPurchaseStatus());
	pRep.setPurchaseDetail(purchase.getPurchaseDetail());
	pRep.setPurchasePaymentID(purchase.getPurchasePayment().getId());
	pRep.setAddressID(purchase.getAddress().getId());
	
	return pRep;
	}
	
	
	
	public PurchaseRepresentation updatePurchaseDetail(Long id, String purchaseDetail) {
		Purchase purchase = pl.getPurchaseByID(id);
		
		PurchaseRepresentation pRep = new PurchaseRepresentation();
		
		pRep.setPurchaseDetail(purchaseDetail);
		
		pRep.setAddressID(purchase.getAddress().getId());
		pRep.setPurchaseOwner(purchase.getPurchaseOwner().getId());
		pRep.setProductID(purchase.getProduct().getId());
		pRep.setPurchaseStatus(purchase.getPurchaseStatus());
		pRep.setPurchasePaymentID(purchase.getPurchasePayment().getId());
		
		return pRep;
	}
	
	public PurchaseRepresentation updatePurchaseStatus(Long id, String purchaseStatus) {
		Purchase purchase = pl.getPurchaseByID(id);
		
		PurchaseRepresentation pRep = new PurchaseRepresentation();
		
		pRep.setPurchaseStatus(purchaseStatus);
		pRep.setAddressID(purchase.getAddress().getId());
		System.out.println("2");
		pRep.setPurchaseOwner(purchase.getPurchaseOwner().getId());
		pRep.setProductID(purchase.getProduct().getId());
		System.out.println("2");
		pRep.setPurchasePaymentID(purchase.getPurchasePayment().getId());
		pRep.setPurchaseDetail(purchase.getPurchaseDetail());
		
		
		return pRep;
		
	}
	
	private static PurchaseRepresentation getPurchaseRepresentation(Purchase purchase) {
		PurchaseRepresentation purchaseRepresentation = new PurchaseRepresentation();
		
		purchaseRepresentation.setId(purchase.getId());
		purchaseRepresentation.setAddressID(purchase.getAddress().getId());
		purchaseRepresentation.setPurchaseOwner(purchase.getPurchaseOwner().getId());
		purchaseRepresentation.setProductID(purchase.getProduct().getId());
		purchaseRepresentation.setPurchaseDetail(purchase.getPurchaseDetail());
		purchaseRepresentation.setPurchaseStatus(purchase.getPurchaseStatus());
		
		return purchaseRepresentation;
	}
	
	public Set<PurchaseRepresentation> getPurchasesFromCustomer(Long customerID){
			
			Set<PurchaseRepresentation> purchaseRepresentations = new HashSet<PurchaseRepresentation>();	
			Set<Purchase> purchases = pl.getAllPurchasesByCustomer(customerID);

		for (Purchase purchase : purchases) {
			PurchaseRepresentation purchaseRepresentation = getPurchaseRepresentation(purchase);
			purchaseRepresentations.add(purchaseRepresentation);
		}
		return purchaseRepresentations;
	}



	public PurchaseRepresentation newPurchase(PurchaseRequest request) {
		PurchaseLogic plr = new PurchaseLogic();
		Purchase purchase = plr.newPurchase(request.getpurchaseOwner(), request.getProductID(), request.getPurchaseDetail(), request.getPurchaseStatus(), request.getPurchasePaymentID(), request.getAddressID());
		PurchaseRepresentation pr = new PurchaseRepresentation();
		
		pr.setId(purchase.getId());
		
		pr.setAddressID(purchase.getAddress().getId());
		
		pr.setPurchaseOwner(purchase.getPurchaseOwner().getId());
		
		pr.setProductID(purchase.getProduct().getId());
		
		pr.setPurchaseDetail(purchase.getPurchaseDetail());
		
		pr.setPurchaseStatus(purchase.getPurchaseStatus());
		
		pr.setPurchasePaymentID(purchase.getPurchasePayment().getId());
		
		
		
		return pr;
	}
	
}