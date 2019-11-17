package com.web_services.instant_pot.service.customer;

import java.util.Set;

import javax.ws.rs.Path;

import com.web_services.instant_pot.service.customer.representation.CustomerRepresentation;
import com.web_services.instant_pot.service.customer.representation.CustomerRequest;

@Path("/customerservice/")
public class CustomerResource implements CustomerService {

	public CustomerRepresentation getCustomerById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<CustomerRepresentation> getCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	public CustomerRepresentation createCustomer(CustomerRequest customerRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	public CustomerRepresentation updateCustomer(Long id, CustomerRequest customerRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	public CustomerRepresentation deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
