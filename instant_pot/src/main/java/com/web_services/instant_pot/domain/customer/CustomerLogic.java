package com.web_services.instant_pot.domain.customer;

import java.util.HashSet;

import com.web_services.instant_pot.dal.customer.CustomerDAL;

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
	
	public Customer createCustomer(String firstName, String lastName, String email, long phoneNumber) {
		CustomerDAL cd = new CustomerDAL();
		return cd.createCustomer(firstName, lastName, email, phoneNumber);
	}
	
	public Customer deleteCustomer(long id) {
		CustomerDAL cd = new CustomerDAL();
		Customer customer = cd.deleteCustomer(id);
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
}