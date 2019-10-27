package com.web_services.instant_pot.service.purchase;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
import com.web_services.instant_pot.service.purchase.workflow.PurchaseActivity;

@Path("/purchaseservice/")
public class PurchaseResource implements PurchaseService{

	@GET
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/purchase/{purchaseID}")
	public PurchaseRepresentation getPurchaseByID(Long purchaseID) {
	System.out.println("GET METHOD Request for Purchase by ID .............");
		PurchaseActivity pAct = new PurchaseActivity();
		return pAct.getPurchaseByID(purchaseID);
	}
	@GET
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/purchase")
	public PurchaseRepresentation newPurchase(Customer purchaseOwner, HashSet<Product> products, String purchaseDetail, String purchaseStatus, Payment purchasePayment, Address address) {
		System.out.println("GET METHOD Request for new Purchase .............");
		PurchaseActivity pAct = new PurchaseActivity();	
		return pAct.newPurchase(purchaseOwner, products, purchaseDetail, purchaseStatus, purchasePayment, address);
	}
	@GET
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/purchase")
	public Response updatePurchaseDetail(Long id, String purchaseDetail) {
		System.out.println("GET METHOD Request for updating purchase detail .............");
		PurchaseActivity pAct = new PurchaseActivity();
		pAct.updatePurchaseDetail(id, purchaseDetail);
		if (pAct.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}
	@GET
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/purchase")
	public Response updatePurchaseStatus(Long id, String purchaseStatus) {
		System.out.println("GET METHOD Request for updating purchase status .............");
		PurchaseActivity pAct = new PurchaseActivity();	
		pAct.updatePurchaseStatus(id, purchaseStatus);
		if (pAct.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}
	@GET
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/purchase/{customerID}")
	public HashSet<ProductRepresentation> getPurchasesFromCustomer(Long customerID){
		System.out.println("GET METHOD Request for Purchases by customer .............");
		PurchaseActivity pAct = new PurchaseActivity();	
		return pAct.getPurchasesFromCustomer(customerID);
	}
	

}

