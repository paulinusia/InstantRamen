package com.web_services.instant_pot.service.payment.workflow;

import com.web_services.instant_pot.domain.payment.Payment;
import com.web_services.instant_pot.domain.payment.PaymentLogic;
import com.web_services.instant_pot.service.payment.representation.PaymentRepresentation;
import com.web_services.instant_pot.service.payment.representation.PaymentRequest;

public class PaymentActivity {
	private static PaymentLogic pl = new PaymentLogic();
	
	public PaymentRepresentation createPayment(PaymentRequest paymentRequest) {
		Payment payment =  pl.createPayment(paymentRequest.getType(), paymentRequest.getCardNumber(), paymentRequest.getExpirationDate(), paymentRequest.getSecurityCode());
		PaymentRepresentation paymentRepresentation = new PaymentRepresentation();
		paymentRepresentation.setCardNumber(payment.getCardNumber());
		paymentRepresentation.setType(payment.getType());
		paymentRepresentation.setExpirationDate(payment.getExpirationDate());
		paymentRepresentation.setSecurityCode(payment.getSecurityCode());
		return paymentRepresentation;
	}
}
