package com.web_services.instant_pot.service.purchase;

import java.util.Set;

import javax.jws.WebService;

import com.web_services.instant_pot.service.purchase.representation.PurchaseRepresentation;

@WebService
public interface PurchaseService {
	public Set<PurchaseRepresentation> getProducts();
}
