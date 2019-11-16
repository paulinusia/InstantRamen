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

@WebService
public interface PurchaseService {
	

	public PurchaseRepresentation getPurchaseByID(Long id);
	public PurchaseRepresentation newPurchase(Customer purchaseOwner, Product product, String purchaseDetail, String purchaseStatus, Payment purchasePayment, Address address);
	//public Response updatePurchaseDetail(Long id, String purchaseDetail);
	//public Response updatePurchaseStatus(Long id, String purchaseStatus);
	public HashSet<ProductRepresentation> getPurchasesFromCustomer(Long customerID);
	
}
