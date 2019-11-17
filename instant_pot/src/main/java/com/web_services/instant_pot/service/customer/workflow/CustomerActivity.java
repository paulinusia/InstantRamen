package com.web_services.instant_pot.service.customer.workflow;

import com.web_services.instant_pot.domain.customer.Customer;
import com.web_services.instant_pot.domain.customer.CustomerLogic;
import com.web_services.instant_pot.service.customer.representation.CustomerRepresentation;

public class CustomerActivity {
	CustomerLogic customerLogic = new CustomerLogic();
	public CustomerRepresentation getCustomerById(Long id) {
		return getCustomerRepresentation(customerLogic.getCustomerById(id));
	}
	
	private static CustomerRepresentation getCustomerRepresentation(Customer customer) {
		CustomerRepresentation cRep = new CustomerRepresentation();
		cRep.setEmail(customer.getEmail());
		cRep.setFirstName(customer.getFirstName());
		cRep.setId(customer.getId());
		cRep.setLastName(customer.getLastName());
		cRep.setPhoneNumber(customer.getPhoneNumber());
		return cRep;
	}
}
