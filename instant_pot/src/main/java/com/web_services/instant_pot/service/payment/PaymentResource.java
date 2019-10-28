package com.web_services.instant_pot.service.payment;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.web_services.instant_pot.domain.payment.Payment;
import com.web_services.instant_pot.service.payment.representation.PaymentRepresentation;
import com.web_services.instant_pot.service.payment.representation.PaymentRequest;
import com.web_services.instant_pot.service.payment.workflow.PaymentActivity;

@Path("/paymentservice/")
public class PaymentResource implements PaymentService {

	@POST
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/payment")
	public PaymentRepresentation createPayment(PaymentRequest paymentRequest) {
		PaymentActivity paymentActivity = new PaymentActivity();
		return paymentActivity.createPayment(paymentRequest);
	}

}
