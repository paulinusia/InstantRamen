package com.web_services.instant_pot.dal.purchase;
import java.util.HashSet;


import java.util.HashSet;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.web_services.instant_pot.domain.address.Address;
import com.web_services.instant_pot.domain.customer.Customer;
import com.web_services.instant_pot.domain.partner.Partner;
import com.web_services.instant_pot.domain.payment.Payment;
import com.web_services.instant_pot.domain.product.Product;
import com.web_services.instant_pot.domain.purchase.Purchase; 

public class PurchaseDAL {
	
	public Purchase getPurchaseByID(Long id) {
		Purchase purchase = new Purchase();
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    purchase = session.get(Purchase.class, id);
	    
		session.close();
		return purchase;
	}

	
	public Purchase newPurchase(Customer purchaseOwner, HashSet<Product> products, String purchaseDetail, String purchaseStatus, Payment purchasePayment, Address address) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
		Purchase purchase = new Purchase(purchaseOwner, products, purchaseDetail, purchaseStatus, purchasePayment, address);
		
	    Transaction tx = session.beginTransaction();
	    session.save(purchase); 
	    tx.commit();
	    session.close(); 
		
	    return purchase;
	}
	

	
	public Purchase updatePurchaseDetail(Long id, String detail) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Purchase purchase = session.get(Purchase.class, id);
	    if (purchase != null) {
	    	purchase.setPurchaseDetail(detail);
	    	Transaction tx = session.beginTransaction();
	    	session.save(purchase);
		    tx.commit();
	    } 
	    session.close();
	    
	    return purchase;
	}
		
	
	
	public Purchase updatePurchaseStatus(Long id, String status) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Purchase purchase = session.get(Purchase.class, id);
	    if (purchase != null) {
	    	purchase.setPurchaseDetail(status);
	    	Transaction tx = session.beginTransaction();
	    	session.save(purchase);
		    tx.commit();
	    } 
	    session.close();
	    
	    return purchase;
	}


	public HashSet<Product> getAllPurchasesByCustomer(String customerID) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Query query = session.createQuery("from Purchase where customer_id=:customerID").setParameter("customerID", customerID);
	    List<Product> products = query.list();
	    HashSet<Product> productSet = new HashSet<Product>(products);
	    
		session.close();
		return productSet;
	}



	


}
