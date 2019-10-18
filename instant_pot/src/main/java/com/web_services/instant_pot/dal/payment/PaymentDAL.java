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
	
	public HashSet<Payment> getAllPayments() {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		
		Query query = session.createQuery("from Payment");
		List<Payment> payments = query.list();
		HashSet<Payment> paymentSet = new HashSet<Payment>(payments);
		
		session.close();
		return paymentSet;
	}
	
	public Payment createPayment(String payment, String paymentType, String description) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		
		Payment newPayment = new Payment();
		
		Transaction tx = session.beginTransaction();
		session.save(newPayment);
		tx.commit();
		session.close();
		
		return newPayment;
	}
	
	public Payment deletePayment(long id) {
		Payment moolah = new Payment();
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		
		moolah = session.get(Payment.class, id);
		if (moolah != null) {
			Transaction tx = session.beginTransaction();
			session.delete(moolah);
			tx.commit();
		}
		session.close();
		return moolah;
	}

}
