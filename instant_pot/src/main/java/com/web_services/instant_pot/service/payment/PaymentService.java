package com.web_services.instant_pot.service.payment;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.web_services.instant_pot.service.payment.representation.PaymentRepresentation;
import com.web_services.instant_pot.service.payment.representation.PaymentRequest;

@WebService
public interface PaymentService {
	public PaymentRepresentation getPayment(Long id);
	public PaymentRepresentation createPayment(PaymentRequest paymentRequest);
	public PaymentRepresentation updateCardNumber(Long id, PaymentRequest paymentRequest);
	Response deletePayment(Long paymentID);
}
