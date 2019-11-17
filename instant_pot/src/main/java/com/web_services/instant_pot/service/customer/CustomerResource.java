package com.web_services.instant_pot.service.customer;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.web_services.instant_pot.service.customer.representation.CustomerRepresentation;
import com.web_services.instant_pot.service.customer.representation.CustomerRequest;

@Path("/customerservice/")
public class CustomerResource implements CustomerService {

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/customer")
	public CustomerRepresentation getCustomerById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/customer")
	public Set<CustomerRepresentation> getCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@POST
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/customer")
	public CustomerRepresentation createCustomer(CustomerRequest customerRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@PUT
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/customer/{id}")
	public CustomerRepresentation updateCustomer(Long id, CustomerRequest customerRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@DELETE
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/customer")
	public CustomerRepresentation deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
