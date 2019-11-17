package com.web_services.instant_pot.service.customer;

import java.util.Set;

import com.web_services.instant_pot.service.customer.representation.CustomerRepresentation;
import com.web_services.instant_pot.service.customer.representation.CustomerRequest;

public interface CustomerService {
	public CustomerRepresentation getCustomerById(Long id);
	public Set<CustomerRepresentation> getCustomers();
	public CustomerRepresentation createCustomer(CustomerRequest customerRequest);
	public CustomerRepresentation updateCustomer(Long id, CustomerRequest customerRequest);
	public CustomerRepresentation deleteCustomer(Long id);
}
