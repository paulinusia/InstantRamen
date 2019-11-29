package com.web_services.instant_pot.domain.payment;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.web_services.instant_pot.dal.payment.PaymentDAL;
import com.web_services.instant_pot.domain.customer.Customer;
import com.web_services.instant_pot.service.payment.representation.PaymentRequest;

public class PaymentLogic {
	
	public Payment getPayment(Long id) {
		PaymentDAL payd = new PaymentDAL();
		Payment payment = payd.getPaymentByID(id);
		return payment;
	}
	
	public HashSet<Payment> getAllPayments() {
		PaymentDAL payd = new PaymentDAL();
		HashSet<Payment> payments = new HashSet<Payment>();
		payments = payd.getAllPayments();
		return payments;
	}
	
	public Payment createPayment(String type, Long cardNumber, int expDate, int securityCode, Long customerId) {
		PaymentDAL payd = new PaymentDAL();
		return payd.createPayment(type, cardNumber, expDate, securityCode, customerId);
	}
	
	public Payment deletePayment(Long id) {
		PaymentDAL payd = new PaymentDAL();
		Payment payment = payd.deletePayment(id);
		return payment;
	}
	
	public Payment updateExpirationDate(Long id, int expDate) {
		PaymentDAL payd = new PaymentDAL();
		Payment payment = payd.updateExpirationDate(id, expDate);
		return payment;
	}
	
	public Payment updateSecurityCode(Long id, int securityCode) {
		PaymentDAL payd = new PaymentDAL();
		Payment payment = payd.updateSecurityCode(id, securityCode);
		return payment;
	}
	
	// main update method
	public Payment updateCardNumber(Long id, String type, Long cardNumber, int expDate, int securityCode) {
		PaymentDAL payd = new PaymentDAL();
		return payd.updateCardNumber(id, type, cardNumber, expDate, securityCode);
		
	}
	
	public Set<Payment> getAllPaymentForCustomer(Long id) {
		PaymentDAL payd = new PaymentDAL();
		Set<Payment> payments = payd.getAllPaymentForCustomer(id);
		return payments;
	}
//	
//	public Payment addPaymentToCustomer(Long paymentID, Long customerID) {	
//		PaymentDAL payd = new PaymentDAL();
//		return payd.addPaymentToCustomer(paymentID, customerID);
//	}
//	
//	public Payment removePaymentFromCustomer(Long paymentID, Long customerID) {	
//		PaymentDAL payd = new PaymentDAL();
//		return payd.removePaymentFromCustomer(paymentID, customerID);
//	}


}