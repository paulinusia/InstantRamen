package com.web_services.instant_pot.service.purchase;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.web_services.instant_pot.domain.address.Address;
import com.web_services.instant_pot.domain.customer.Customer;
import com.web_services.instant_pot.domain.payment.Payment;
import com.web_services.instant_pot.domain.product.Product;
import com.web_services.instant_pot.service.product.representation.ProductRepresentation;
import com.web_services.instant_pot.service.product.workflow.ProductActivity;
import com.web_services.instant_pot.service.purchase.representation.PurchaseRepresentation;
import com.web_services.instant_pot.service.purchase.representation.PurchaseRequest;
import com.web_services.instant_pot.service.purchase.workflow.PurchaseActivity;

@Path("/purchaseservice/")
public class PurchaseResource implements PurchaseService{

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/purchase/{purchaseID}")
	public PurchaseRepresentation getPurchaseByID(@PathParam("purchaseID") Long purchaseID) {
	System.out.println("GET METHOD Request for Purchase by ID .............");
		PurchaseActivity pAct = new PurchaseActivity();
		return pAct.getPurchaseByID(purchaseID);
	}
	
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/purchase")
	public PurchaseRepresentation newPurchase(PurchaseRequest request) {
		System.out.println("GET METHOD Request for new Purchase .............");
		PurchaseActivity pAct = new PurchaseActivity();	
		return pAct.newPurchase(request);
	}
	
	@PUT
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/purchase/{id}")
	public PurchaseRepresentation updatePurchaseDetail(@PathParam("id") Long id, String purchaseDetail) {
		System.out.println("GET METHOD Request for updating purchase detail .............");
		PurchaseActivity pAct = new PurchaseActivity();
		return pAct.updatePurchaseDetail(id, purchaseDetail);
		
	}
	@PUT
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/purchaseStatusUpdate/{id}")
	public PurchaseRepresentation updatePurchaseStatus(@PathParam("id") Long id, String purchaseStatus) {
		System.out.println("GET METHOD Request for updating purchase status .............");
		PurchaseActivity pAct = new PurchaseActivity();	
		return pAct.updatePurchaseStatus(id, purchaseStatus);
		
	}
	
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/customerpurchases/{id}")
	public Set<PurchaseRepresentation> getPurchasesFromCustomer(@PathParam("id") Long customerID){
		System.out.println("GET METHOD Request for Purchases by customer .............");
		PurchaseActivity pAct = new PurchaseActivity();	
		return pAct.getPurchasesFromCustomer(customerID);
	}
	

}

