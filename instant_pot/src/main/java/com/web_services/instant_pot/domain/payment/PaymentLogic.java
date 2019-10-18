package com.web_services.instant_pot.domain.payment;

import java.util.HashSet;

import com.web_services.instant_pot.dal.payment.PaymentDAL;

public class PaymentLogic {
	
	public Payment getPayment(long id) {
		PaymentDAL payd = new PaymentDAL();
		Payment payment = payd.getPaymentByID(id);
		return payment;
		
	}
}