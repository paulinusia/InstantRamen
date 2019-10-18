package com.web_services.instant_pot.dal.payment;

import java.util.HashSet;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.web_services.instant_pot.domain.payment.Payment;

public class PaymentDAL {
	public Payment getPaymentByID(long id) {
		Payment payment = new Payment();
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		
		payment = session.get(Payment.class, id);
		
		session.close();
		return payment;
	}

}
