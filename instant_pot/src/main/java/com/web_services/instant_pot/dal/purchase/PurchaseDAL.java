package com.web_services.instant_pot.dal.purchase;
import java.util.HashSet;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	
	public Purchase newPurchase(Long customerID, Long productID, String purchaseDetail, String purchaseStatus, Long pay, Long addressID) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    Customer customer = session.get(Customer.class, customerID);
	    Product product = session.get(Product.class, productID);
	    Address address = session.get(Address.class, addressID);
	    Payment payment = session.get(Payment.class, pay);
		Purchase purchase = new Purchase(customer, product, purchaseDetail, purchaseStatus, payment, address);
	    Transaction tx = session.beginTransaction();
	    session.save(purchase); 
		session.save(productID);
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


	public Set<Purchase> getAllPurchasesByCustomer(Long customerID) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Query query = session.createQuery("from Purchase where fk_purchase_owner=:customerID").setParameter("customerID", customerID);
	    
	    List<Purchase> purchases = query.list();
	    
	    Set<Purchase> purchaseSet = new HashSet<Purchase>(purchases);
	    
	    
		session.close();
		return purchaseSet;
	}

	public Set<Purchase> getAllPurchasesByProduct(Long productID) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Query query = session.createQuery("from Purchase where fk_product=:productID").setParameter("productID", productID);
	    List<Purchase> purchases = query.list();
	    Set<Purchase> purchaseSet = new HashSet<Purchase>(purchases);
	    
		session.close();
		return purchaseSet;
	}




	


}
