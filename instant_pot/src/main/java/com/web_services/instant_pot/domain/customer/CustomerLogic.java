package com.web_services.instant_pot.domain.customer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.web_services.instant_pot.dal.customer.CustomerDAL;
import com.web_services.instant_pot.domain.address.Address;

public class CustomerLogic {
	
	public Customer getCustomer(long custID) {
		CustomerDAL cd = new CustomerDAL();
		Customer customer = cd.getCustomerByID(custID);
		return customer;
	}
	
	public HashSet<Customer> getAllCustomers() {
		CustomerDAL cd = new CustomerDAL();
		HashSet<Customer> customers = new HashSet<Customer>();
		customers = cd.getAllCustomers();
		return customers;
	}
	
	public Customer createCustomer(String firstName, String lastName, String email, Long phoneNumber) {
		CustomerDAL cd = new CustomerDAL();
		return cd.createCustomer(firstName, lastName, email, phoneNumber);
	}
	
	public Customer deleteCustomer(long id) {
		CustomerDAL cd = new CustomerDAL();
		Customer customer = cd.deleteCustomer(id);
		return customer;
	}
	
	public Customer updateCustomer(Long id, String firstName, String lastName, String email, Long phoneNumber) {
		CustomerDAL cd = new CustomerDAL();
		Customer customer = cd.updateCustomer(id, firstName, lastName, email, phoneNumber);
		return customer;
	}
	
	public Customer updateFirstName(String firstName, long id) {
		CustomerDAL cd = new CustomerDAL();
		Customer customer = cd.updateFirstName(firstName, id);
		return customer;
	}
	
	public Customer updateLastName(String lastName, long id) {
		CustomerDAL cd = new CustomerDAL();
		Customer customer = cd.updateLastName(lastName, id);
		return customer;
		
	}
	
	public Customer updateEmail(String email, long id) {
		CustomerDAL cd = new CustomerDAL();
		Customer customer = cd.updateEmail(email, id);
		return customer;
	}
	
	public Customer updatePhoneNumber(long phoneNumber, long id) {
		CustomerDAL cd = new CustomerDAL();
		Customer customer = cd.updatePhoneNumber(phoneNumber, id);
		return customer;
	}
	
//	public HashSet<Address> getAllAddressForCustomer(Long custID) {
//		CustomerDAL cd = new CustomerDAL();
//		return cd.getAllAddressForCustomer(custID);
//	}
}