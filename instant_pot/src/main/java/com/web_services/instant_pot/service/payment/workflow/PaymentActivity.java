package com.web_services.instant_pot.service.payment.workflow;

import java.util.HashSet;
import java.util.Set;

import com.web_services.instant_pot.domain.payment.Payment;
import com.web_services.instant_pot.domain.payment.PaymentLogic;
import com.web_services.instant_pot.service.link.Link;
import com.web_services.instant_pot.service.payment.representation.PaymentRepresentation;
import com.web_services.instant_pot.service.payment.representation.PaymentRequest;

public class PaymentActivity {
	private static PaymentLogic pl = new PaymentLogic();
	
	public PaymentRepresentation createPayment(PaymentRequest paymentRequest) {
		Payment payment =  pl.createPayment(paymentRequest.getType(), paymentRequest.getCardNumber(), paymentRequest.getExpirationDate(), paymentRequest.getSecurityCode(), paymentRequest.getCustomerId());
		PaymentRepresentation pRep = getPaymentRepresentation(payment);
		Set<Link> links = new HashSet<>();
		links.add(new Link("updatePayment", "/paymentservice/payment/" + pRep.getId(), "application/InstantPot.Payment+xml|json"));
		links.add(new Link("deletePayment", "/paymentservice/payment/" + pRep.getId(), null));
		pRep.setLinks(links);
		return pRep;
	}
	
	private static PaymentRepresentation getPaymentRepresentation(Payment payment) {
		PaymentRepresentation paymentRepresentation = new PaymentRepresentation();
		paymentRepresentation.setId(payment.getId());
		paymentRepresentation.setCustomerId(payment.getPaymentOwner().getId());
		paymentRepresentation.setCardNumber(payment.getCardNumber());
		paymentRepresentation.setType(payment.getType());
		paymentRepresentation.setExpirationDate(payment.getExpirationDate());
		paymentRepresentation.setSecurityCode(payment.getSecurityCode());
		return paymentRepresentation;
	}
	
	
	public PaymentRepresentation getPayment(Long paymentID) {
		PaymentLogic pd = new PaymentLogic();
		Payment payment = pd.getPayment(paymentID);
		
		PaymentRepresentation pRep = getPaymentRepresentation(payment);
		Set<Link> links = new HashSet<>();
		links.add(new Link("updatePayment", "/paymentservice/payment/" + pRep.getId(), "application/InstantPot.Payment+xml|json"));
		links.add(new Link("deletePayment", "/paymentservice/payment/" + pRep.getId(), null));
		pRep.setLinks(links);
		return pRep;
	}
	

	
	public PaymentRepresentation updateCardNumber(Long id, PaymentRequest paymentRequest) {
		PaymentLogic pd = new PaymentLogic();
		PaymentRepresentation pRep = getPaymentRepresentation(pd.updateCardNumber(id, paymentRequest.getType(), paymentRequest.getCardNumber(), paymentRequest.getExpirationDate(), paymentRequest.getSecurityCode()));
		Set<Link> links = new HashSet<>();
		links.add(new Link("deletePayment", "/paymentservice/payment/" + pRep.getId(), null));
		pRep.setLinks(links);
		return pRep;
	}
		
	
	public String deletePayment(Long paymentID) {
		PaymentLogic pd = new PaymentLogic();
		
		pd.deletePayment(paymentID);
		
		return "OK";
	}
	
}
