package com.web_services.instant_pot.domain.purchase;

import java.util.HashSet;

import com.web_services.instant_pot.dal.product.ProductDAL;
import com.web_services.instant_pot.dal.purchase.PurchaseDAL;
import com.web_services.instant_pot.domain.customer.Customer;
import com.web_services.instant_pot.domain.partner.Partner;
import com.web_services.instant_pot.domain.product.Product;


public class PurchaseLogic {
	
	
	public static Purchase getPurchaseByID(long id) {
		PurchaseDAL pd = new PurchaseDAL();
		return pd.getPurchaseByID(id);
	}
	
	
	public Purchase updatePurchaseDetail(Long id, String purchaseDetail) {
		PurchaseDAL purchase = new PurchaseDAL();
	    return purchase.updatePurchaseDetail(id,purchaseDetail);

	}
	
	public Purchase updatePurchaseStatus(Long id, String purchaseStatus) {
		PurchaseDAL purchase = new PurchaseDAL();
	    return purchase.updatePurchaseDetail(id,purchaseStatus);

	}
	
	public HashSet<Product> getPurchasesFromCustomer(String customer){
		PurchaseDAL pd = new PurchaseDAL();
		return pd.getAllPurchasesByCustomer(customer);
	}

	

}
