package com.web_services.instant_pot.domain.payment;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.web_services.instant_pot.dal.payment.PaymentDAL;
import com.web_services.instant_pot.domain.customer.Customer;

public class PaymentLogic {
	
	public Payment getPayment(long id) {
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
	
	public Payment createPayment(String type, Long cardNumber, int expDate, int securityCode) {
		PaymentDAL payd = new PaymentDAL();
		return payd.createPayment(type, cardNumber, expDate, securityCode);
	}
	
	public Payment deletePayment(long id) {
		PaymentDAL payd = new PaymentDAL();
		Payment payment = payd.deletePayment(id);
		return payment;
	}
	
	public Payment updateExpirationDate(long id, int expDate) {
		PaymentDAL payd = new PaymentDAL();
		Payment payment = payd.updateExpirationDate(id, expDate);
		return payment;
	}
	
	public Payment updateSecurityCode(long id, int securityCode) {
		PaymentDAL payd = new PaymentDAL();
		Payment payment = payd.updateSecurityCode(id, securityCode);
		return payment;
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