package com.web_services.instant_pot.service.purchase;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


import com.web_services.instant_pot.service.product.workflow.ProductActivity;
import com.web_services.instant_pot.service.purchase.representation.PurchaseRepresentation;
import com.web_services.instant_pot.service.purchase.workflow.PurchaseActivity;

@Path("/productservice/")
public class PurchaseResource implements PurchaseService{

	@GET
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/products")
	public Set<PurchaseRepresentation> getProducts() {
		System.out.println("GET METHOD Request for all products .............");
		PurchaseActivity PurchaseActivity = new PurchaseActivity();
		return PurchaseActivity.getProducts();	
	}

}

