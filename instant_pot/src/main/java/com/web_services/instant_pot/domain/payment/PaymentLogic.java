package com.web_services.instant_pot.domain.payment;

import java.util.HashSet;

import com.web_services.instant_pot.dal.payment.PaymentDAL;

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
	
	public Payment createPayment(String payment, String paymentType, String description) {
		PaymentDAL pd = new PaymentDAL();
		return pd.createPayment(payment, paymentType, description);
	}
	
	public Payment deletePayment(long id) {
		PaymentDAL pd = new PaymentDAL();
		Payment payment = pd.deletePayment(id);
		return payment;
	}
}