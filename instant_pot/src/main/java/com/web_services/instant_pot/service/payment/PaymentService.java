package com.web_services.instant_pot.service.payment;

import javax.jws.WebService;

import com.web_services.instant_pot.domain.payment.Payment;
import com.web_services.instant_pot.service.payment.representation.PaymentRepresentation;
import com.web_services.instant_pot.service.payment.representation.PaymentRequest;

@WebService
public interface PaymentService {
	public PaymentRepresentation createPayment(PaymentRequest paymentRequest);
}
