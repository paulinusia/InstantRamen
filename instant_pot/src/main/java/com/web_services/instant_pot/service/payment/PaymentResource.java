package com.web_services.instant_pot.service.payment;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.web_services.instant_pot.domain.payment.Payment;
import com.web_services.instant_pot.service.payment.representation.PaymentRepresentation;
import com.web_services.instant_pot.service.payment.representation.PaymentRequest;
import com.web_services.instant_pot.service.payment.workflow.PaymentActivity;
import com.web_services.instant_pot.service.purchase.workflow.PurchaseActivity;
import com.web_services.instant_pot.service.review.representation.ReviewRepresentation;

@Path("/paymentservice/")
public class PaymentResource implements PaymentService {
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/payments/{paymentID}")
	public 	PaymentRepresentation getPayment(@PathParam("paymentID") Long paymentID) {
		System.out.println(paymentID);
		System.out.println("GET METHOD Request for Payment by ID .............");
		PaymentActivity pAct = new PaymentActivity();
		return pAct.getPayment(paymentID);
	}

	@POST
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/payment")
	public PaymentRepresentation createPayment(PaymentRequest paymentRequest) {
		PaymentActivity paymentActivity = new PaymentActivity();
		return paymentActivity.createPayment(paymentRequest);
	}

	@PUT
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/payments/{paymentID}")
	public PaymentRepresentation updateCardNumber(@PathParam("paymentID") Long id, PaymentRequest paymentRequest) {
		System.out.println("GET METHOD Request for updating payment card number .............");
		PaymentActivity pAct = new PaymentActivity();
		return pAct.updateCardNumber(id, paymentRequest);
		

	}
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/payments/{paymentID}")
	public Response deletePayment(@PathParam("paymentID") Long paymentID) {
		System.out.println("GET METHOD Request for deleting a payment .............");
		PaymentActivity pAct = new PaymentActivity();
		String res = pAct.deletePayment(paymentID);
		if (pAct.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}



}
