package com.web_services.instant_pot.service.purchase.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.web_services.instant_pot.dal.purchase.PurchaseDAL;
import com.web_services.instant_pot.domain.product.ProductLogic;
import com.web_services.instant_pot.domain.purchase.Purchase;
import com.web_services.instant_pot.domain.purchase.PurchaseLogic;
import com.web_services.instant_pot.service.purchase.representation.PurchaseRepresentation;



public class PurchaseActivity {

	private static PurchaseLogic pl = new PurchaseLogic();
	
	public PurchaseRepresentation getPurchaseByID(Long id) {
		PurchaseDAL pd = new PurchaseDAL();
		
	}

}