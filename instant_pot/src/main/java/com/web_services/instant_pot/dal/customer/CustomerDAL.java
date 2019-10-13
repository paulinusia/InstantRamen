package com.web_services.instant_pot.dal.customer;

import java.util.HashSet;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.web_services.instant_pot.domain.customer.Customer;

public class CustomerDAL {
	
	public Customer getCustomerByID(long id) {
		Customer customer = new Customer();
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		
		customer = session.get(Customer.class, id);
		
		session.close();
		return customer;
	}
	
	public HashSet<Customer> getAllCustomers() {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		
		Query q = session.createQuery("from Customer");
		List<Customer> customers = q.list();
		HashSet<Customer> customerSet = new HashSet<Customer>(customers);
		
		session.close();
		return customerSet;
	}
	
	public Customer createCustomer(String firstName, String lastName, String email, long phoneNumber) {
		Customer newCust = new Customer();
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		session.save(newCust);
		tx.commit();
		session.close();
		
		return newCust;
	}
	
	public Customer deleteCustomer(long id) {
		Customer customer = new Customer();
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		
		customer = session.get(Customer.class, id);
		if (customer != null) {
			Transaction tx = session.beginTransaction();
			session.delete(customer);
			tx.commit();
		}
		session.close();
		return customer;
	}
	
	public Customer updateFirstName(String firstName, long id) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		
		Customer customer = session.get(Customer.class, id);
		if (customer != null) {
			customer.setFirstName(firstName);
			Transaction tx = session.beginTransaction();
			session.save(customer);
			tx.commit();
		}
		session.close();
		return customer;
	}
	
	public Customer updateLastName(String lastName, long id) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		
		Customer customer = session.get(Customer.class, id);
		if (customer != null) {
			customer.setLastName(lastName);
			Transaction tx = session.beginTransaction();
			session.save(customer);
			tx.commit();
		}
		session.close();
		return customer;
	}
	
	public Customer updateEmail(String email, long id) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		
		Customer customer = session.get(Customer.class, id);
		if (customer != null) {
			customer.setEmail(email);
			Transaction tx = session.beginTransaction();
			session.save(customer);
			tx.commit();
		}
		session.close();
		return customer;
	}
	
	public Customer updatePhoneNumber(long phoneNumber, long id) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		
		Customer customer = session.get(Customer.class, id);
		if (customer != null) {
			customer.setPhoneNumber(phoneNumber);
			Transaction tx = session.beginTransaction();
			session.save(customer);
			tx.commit();
		}
		session.close();
		return customer;
	}

}
