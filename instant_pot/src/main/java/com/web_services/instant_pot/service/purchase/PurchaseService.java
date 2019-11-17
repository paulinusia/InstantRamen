package com.web_services.instant_pot.service.purchase;

import java.util.HashSet;
import java.util.Set;

import javax.jws.WebService;

import com.web_services.instant_pot.domain.address.Address;
import com.web_services.instant_pot.domain.customer.Customer;
import com.web_services.instant_pot.domain.payment.Payment;
import com.web_services.instant_pot.domain.product.Product;
import com.web_services.instant_pot.service.product.representation.ProductRepresentation;
import com.web_services.instant_pot.service.purchase.representation.PurchaseRepresentation;
import com.web_services.instant_pot.service.purchase.representation.PurchaseRequest;

@WebService
public interface PurchaseService {
	
	public PurchaseRepresentation newPurchase(PurchaseRequest request);
	public PurchaseRepresentation getPurchaseByID(Long id);
	public PurchaseRepresentation  updatePurchaseDetail(Long id, String purchaseDetail);
	public PurchaseRepresentation updatePurchaseStatus(Long id, String purchaseStatus);
	public Set<PurchaseRepresentation> getPurchasesFromCustomer(Long customerID);
	
}
