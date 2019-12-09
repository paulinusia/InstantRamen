package com.web_services.instant_pot.service.purchase.workflow;

import java.util.HashSet;
//import java.util.Iterator;
import java.util.Set;

import com.web_services.instant_pot.domain.purchase.Purchase;
import com.web_services.instant_pot.domain.purchase.PurchaseLogic;
import com.web_services.instant_pot.service.link.Link;
import com.web_services.instant_pot.service.purchase.representation.PurchaseRepresentation;
import com.web_services.instant_pot.service.purchase.representation.PurchaseRequest;



public class PurchaseActivity {

	private static PurchaseLogic pl = new PurchaseLogic();
	
	public PurchaseRepresentation getPurchaseByID(Long id) {
		Purchase purchase = pl.getPurchaseByID(id);
		PurchaseRepresentation pRep = getPurchaseRepresentation(purchase);
		Set<Link> links = new HashSet<>();
		links.add(new Link("updatePurchaseStatus", "/purchaseservice/purchasestatus/" + pRep.getId() + "/", null));
		links.add(new Link("updatePurchaseDetail", "/purchaseservice/purchasedetail/" + pRep.getId() + "/", null));
		pRep.setLinks(links);
		return pRep;
	}
	
	
	public PurchaseRepresentation updatePurchaseDetail(Long id, String purchaseDetail) {
		Purchase purchase = pl.updatePurchaseDetail(id, purchaseDetail);
		PurchaseRepresentation pRep = getPurchaseRepresentation(purchase);
		Set<Link> links = new HashSet<>();
		links.add(new Link("updatePurchaseStatus", "/purchaseservice/purchasestatus/" + pRep.getId() + "/", null));
		pRep.setLinks(links);
		return pRep;
	}
	
	public PurchaseRepresentation updatePurchaseStatus(Long id, String purchaseStatus) {
		Purchase purchase = pl.updatePurchaseStatus(id, purchaseStatus);
		PurchaseRepresentation pRep = getPurchaseRepresentation(purchase);
		Set<Link> links = new HashSet<>();
		links.add(new Link("updatePurchaseDetail", "/purchaseservice/purchasedetail/" + pRep.getId() + "/", null));
		pRep.setLinks(links);
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
			purchaseRepresentations.add(getPurchaseRepresentation(purchase));
		}
		return purchaseRepresentations;
	}

	public Set<PurchaseRepresentation> getPurchasesByProduct(Long productID){
		Set<PurchaseRepresentation> purchaseRepresentations = new HashSet<PurchaseRepresentation>();	
		Set<Purchase> purchases = pl.getAllPurchasesByProduct(productID);
		for (Purchase purchase : purchases) {
			purchaseRepresentations.add(getPurchaseRepresentation(purchase));
		}
		return purchaseRepresentations;
	}
	
	public PurchaseRepresentation newPurchase(PurchaseRequest request) {
		Purchase purchase = pl.newPurchase(request.getpurchaseOwner(), request.getProductID(), request.getPurchaseDetail(), request.getPurchaseStatus(), request.getPurchasePaymentID(), request.getAddressID());
		PurchaseRepresentation pRep = getPurchaseRepresentation(purchase);
		Set<Link> links = new HashSet<>();
		links.add(new Link("updatePurchaseStatus", "/purchaseservice/purchasestatus/" + pRep.getId() + "/", null));
		links.add(new Link("updatePurchaseDetail", "/purchaseservice/purchasedetail/" + pRep.getId() + "/", null));
		pRep.setLinks(links);
		return pRep;
	}
	
}