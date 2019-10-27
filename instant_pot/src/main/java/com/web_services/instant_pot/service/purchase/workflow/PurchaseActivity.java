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
		pRep.setProducts(purchase.getProducts());
		pRep.setPurchaseDetail(purchase.getPurchaseDetail());
		pRep.setPurchaseOwner(purchase.getPurchaseOwner());
		pRep.setPurchasePayment(purchase.getPurchasePayment());
		pRep.setPurchaseStatus(purchase.getPurchaseStatus());
		
		return pRep;
	}
	
	
	
	public PurchaseRepresentation newPurchase(Customer purchaseOwner, HashSet<Product> products, String purchaseDetail, String purchaseStatus, Payment purchasePayment, Address address) {
	Purchase purchase = pl.newPurchase(purchaseOwner, products, purchaseDetail, purchaseStatus, purchasePayment, address);
	
	PurchaseRepresentation pRep = new PurchaseRepresentation();
	pRep.setPurchaseOwner(purchase.getPurchaseOwner());
	pRep.setProducts(purchase.getProducts());
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
		pRep.setProducts(purchase.getProducts());
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
		pRep.setProducts(purchase.getProducts());
		pRep.setPurchasePayment(purchase.getPurchasePayment());
		pRep.setPurchaseDetail(purchase.getPurchaseDetail());
		
		return pRep;
		
	}
	
	
	
	public HashSet<ProductRepresentation> getPurchasesFromCustomer(Long customer){
		
		HashSet<Product> purchases = pl.getPurchasesFromCustomer(customer);
		HashSet<ProductRepresentation> productRepresentations = new HashSet<ProductRepresentation>();
		ProductRepresentation pRep = new ProductRepresentation();
		
		
		
		for (Product product : purchases) {
		pRep.setCost(product.getCost());
		pRep.setId(product.getId());
		pRep.setProductDescription(product.getProductDescription());
		pRep.setProductName(product.getProductName());
		
		}
		return productRepresentations;
	}
	
}