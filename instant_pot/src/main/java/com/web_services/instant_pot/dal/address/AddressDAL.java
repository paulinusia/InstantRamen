package com.web_services.instant_pot.dal.address;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.web_services.instant_pot.domain.address.Address;
import com.web_services.instant_pot.domain.customer.Customer;
import com.web_services.instant_pot.domain.partner.Partner;
import com.web_services.instant_pot.domain.product.Product;
import com.web_services.instant_pot.domain.review.Review;

public class AddressDAL {
		
		public Address getAddressByID(Long id) {
			Address address = new Address();
			
			SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		    Session session = sf.openSession();
		    
		    address = session.get(Address.class, id);
		    
			session.close();
			return address;
		}
		
		// create address
		
		public Address addAddressToCustomer(Long addressID, Long customerID) {	
			SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		    Session session = sf.openSession();
		    
		    Customer customer = session.get(Customer.class, customerID);
		    Address address = session.get(Address.class, addressID);
		    address.getAddressOwners().add(customer);
		    
		    Transaction tx = session.beginTransaction();
		    session.save(address);
		    tx.commit(); 
		    session.close();
		  
		    return address;
		}
		
		public Address addAddressToPartner(Long addressID, Long partnerID) {	
			SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		    Session session = sf.openSession();
		    
		    Partner partner = session.get(Partner.class, partnerID);
		    Address address = session.get(Address.class, addressID);
		    address.getAddressOwners().add(partner);
		    
		    Transaction tx = session.beginTransaction();
		    session.save(address);
		    tx.commit(); 
		    session.close();
		  
		    return address;
		}
		
		public Address deleteReview(Long id){
			Address address = new Address();
			
			SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		    Session session = sf.openSession();
		    
		    address = session.get(Address.class, id);
		    if (address != null) {
		    	Transaction tx = session.beginTransaction();
		    	session.delete(address);
			    tx.commit();
		    } 
			session.close();
			return address;
		}	
}