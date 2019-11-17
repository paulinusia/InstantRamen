package com.web_services.instant_pot.dal.payment;

import java.util.HashSet;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.web_services.instant_pot.domain.address.Address;
import com.web_services.instant_pot.domain.customer.Customer;
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
	
	public Payment createPayment(String type, Long cardNumber, int expDate, int securityCode) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		
		Payment newPayment = new Payment(type, cardNumber, expDate, securityCode);
		
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
	
	public Payment updateExpirationDate(long id, int expDate) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		
		Payment p = session.get(Payment.class, id);
		if (p != null) {
			p.setExpirationDate(expDate);
			Transaction tx = session.beginTransaction();
			session.save(p);
			tx.commit();
		}
		session.close();
		return p;
	}
	
	public Payment updateSecurityCode(long id, int securityCode) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		
		Payment p = session.get(Payment.class, id);
		if (p != null) {
			p.setSecurityCode(securityCode);
			Transaction tx = session.beginTransaction();
			session.save(p);
			tx.commit();
		}
		session.close();
		return p;
	}
	
//	public Payment addPaymentToCustomer(Long paymentID, Long customerID) {	
//		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//	    Session session = sf.openSession();
//	    
//	    Customer customer = session.get(Customer.class, customerID);
//	    Payment payment = session.get(Payment.class, paymentID);
//	    payment.setPaymentOwner(customer);
//	    customer.getPayments().add(payment);
//	    
//	    Transaction tx = session.beginTransaction();
//	    session.save(payment);
//	    session.save(customer);
//	    tx.commit(); 
//	    session.close();
//	  
//	    return payment;
//	}
//	
//	public Payment removePaymentFromCustomer(Long paymentID, Long customerID) {	
//		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//	    Session session = sf.openSession();
//	    
//	    Customer customer = session.get(Customer.class, customerID);
//	    Payment payment = session.get(Payment.class, paymentID);
//	    payment.setPaymentOwner(null);
//	    customer.getPayments().remove(payment);
//	    
//	    Transaction tx = session.beginTransaction();
//	    session.save(payment);
//	    session.save(customer);
//	    tx.commit(); 
//	    session.close();
//	  
//	    return payment;
//	}

}
