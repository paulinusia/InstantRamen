package com.web_services.instant_pot.dal.address;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.web_services.instant_pot.domain.address.Address;
import com.web_services.instant_pot.domain.customer.Customer;
import com.web_services.instant_pot.domain.partner.Partner;
import com.web_services.instant_pot.domain.product.Product;
import com.web_services.instant_pot.domain.purchase.Purchase;
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
		
		public Address createAddress(String streetAddress, String city, String state, String zip) {
			Address newAddress = new Address(streetAddress, city, state, zip);
			
			SessionFactory sf = (SessionFactory) new Configuration().configure().buildSessionFactory();
			Session session = sf.openSession();
            
			Transaction tx = session.beginTransaction();
			session.save(newAddress);
			tx.commit();
			session.close();
			
			return newAddress;
		}
		
		public Address updateAddress(Long id, String streetAddress, String city, String state, String zip) {
			SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			Session session = sf.openSession();
			
			Address address = session.get(Address.class, id);
			if (address != null) {
				address.setStreetAddress(streetAddress);
				address.setCity(city);
				address.setState(state);
				address.setZip(zip);
				Transaction tx = session.beginTransaction();
				session.save(address);
				tx.commit();
			}
			session.close();
			return address;
		}
		
//		public Address removeAddressFromCustomer(Long addressID, Long customerID) {	
//			SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//		    Session session = sf.openSession();
//		    
//		    Customer customer = session.get(Customer.class, customerID);
//		    Address address = session.get(Address.class, addressID);
//		    address.setCustomer(null);
//		    
//		    Transaction tx = session.beginTransaction();
//		    session.save(address);
//		    session.save(customer);
//		    tx.commit(); 
//		    session.close();
//		  
//		    return address;
//		}
//		
//		public Address removeAddressFromPartner(Long addressID, Long partnerID) {	
//			SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//		    Session session = sf.openSession();
//		    
//		    Partner partner = session.get(Partner.class, partnerID);
//		    Address address = session.get(Address.class, addressID);
//		    address.setPartner(null);
//		    partner.getAddresses().remove(address);
//		    
//		    Transaction tx = session.beginTransaction();
//		    session.save(address);
//		    session.save(partner);
//		    tx.commit(); 
//		    session.close();
//		  
//		    return address;
//		}
//		
//		public Address addAddressToCustomer(Long addressID, Long customerID) {	
//			SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//		    Session session = sf.openSession();
//		    
//		    Customer customer = session.get(Customer.class, customerID);
//		    Address address = session.get(Address.class, addressID);
//		    address.setCustomer(customer);
//		    customer.getAddresses().add(address);
//		    Transaction tx = session.beginTransaction();
//		    session.save(address);
//		    session.save(customer);
//		    tx.commit(); 
//		    session.close();
//		    
//		    return address;
//		}
//		
//		public Address addAddressToPartner(Long addressID, Long partnerID) {	
//			SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//		    Session session = sf.openSession();
//		    
//		    Partner partner = session.get(Partner.class, partnerID);
//		    Address address = session.get(Address.class, addressID);
//		    address.setPartner(partner);
//		    partner.getAddresses().add(address);
//		    
//		    Transaction tx = session.beginTransaction();
//		    session.save(address);
//		    session.save(partner);
//		    tx.commit(); 
//		    session.close();
//		  
//		    return address;
//		}
		
		public Address deleteAddress(Long id){
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
		
		public Set<Address> getAllAddressForCustomer(Long customerID) {
			
			SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		    Session session = sf.openSession();
		    
		    Query query = session.createQuery("from Address where fk_customer=:customerID").setParameter("customerID", customerID);
		    List<Address> addresses = query.list();
		    Set<Address> addressSet = new HashSet<Address>(addresses);
		    
			session.close();
			return addressSet;
		}
}
