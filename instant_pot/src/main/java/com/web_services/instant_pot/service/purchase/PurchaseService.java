package com.web_services.instant_pot.service.purchase;

//import java.util.HashSet;
import java.util.Set;

import javax.jws.WebService;


import com.web_services.instant_pot.service.purchase.representation.PurchaseRepresentation;
import com.web_services.instant_pot.service.purchase.representation.PurchaseRequest;

@WebService
public interface PurchaseService {
	
	public PurchaseRepresentation newPurchase(PurchaseRequest request);
	public PurchaseRepresentation getPurchaseByID(Long id);
	public PurchaseRepresentation  updatePurchaseDetail(Long id, String purchaseDetail);
	public PurchaseRepresentation updatePurchaseStatus(Long id, String purchaseStatus);
	public Set<PurchaseRepresentation> getPurchasesFromCustomer(Long customerID);
	public Set<PurchaseRepresentation> getPurchasesByProduct(Long productID);
}
