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
	
	private static PaymentRepresentation getPaymentRepresentation(Payment payment) {
		PaymentRepresentation paymentRepresentation = new PaymentRepresentation();
		paymentRepresentation.setCardNumber(payment.getCardNumber());
		paymentRepresentation.setType(payment.getType());
		paymentRepresentation.setExpirationDate(payment.getExpirationDate());
		paymentRepresentation.setSecurityCode(payment.getSecurityCode());
		return paymentRepresentation;
	}
	
	
	public PaymentRepresentation getPayment(Long paymentID) {
		PaymentLogic pd = new PaymentLogic();
		Payment payment = pd.getPayment(paymentID);
		
		PaymentRepresentation paymentRep = new PaymentRepresentation();
		
		paymentRep.setId(payment.getId());
		paymentRep.setCardNumber(payment.getCardNumber());
		paymentRep.setType(payment.getType());
		paymentRep.setExpirationDate(payment.getExpirationDate());
		paymentRep.setSecurityCode(payment.getSecurityCode());
		return paymentRep;
	}
	

	
	public PaymentRepresentation updateCardNumber(Long id, PaymentRequest paymentRequest) {
		PaymentLogic pd = new PaymentLogic();
		
		
		return getPaymentRepresentation(pd.updateCardNumber(id, paymentRequest.getType(), paymentRequest.getCardNumber(), paymentRequest.getExpirationDate(), paymentRequest.getSecurityCode()));
		
		
	}
		
	
	public String deletePayment(Long paymentID) {
		PaymentLogic pd = new PaymentLogic();
		
		pd.deletePayment(paymentID);
		
		return "OK";
	}
	
}
