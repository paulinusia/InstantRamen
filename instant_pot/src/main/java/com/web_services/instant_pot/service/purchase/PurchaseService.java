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
	

	PurchaseRepresentation getPurchaseByID(Long id);
	PurchaseRepresentation newPurchase(Customer purchaseOwner, HashSet<Product> products, String purchaseDetail, String purchaseStatus, Payment purchasePayment, Address address);
	PurchaseRepresentation updatePurchaseDetail(Long id, String purchaseDetail);
	PurchaseRepresentation updatePurchaseStatus(Long id, String purchaseStatus);
	HashSet<ProductRepresentation> getPurchasesFromCustomer(Long customerID);
	
}
