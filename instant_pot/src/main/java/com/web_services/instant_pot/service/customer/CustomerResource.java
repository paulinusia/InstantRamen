package com.web_services.instant_pot.service.customer;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.web_services.instant_pot.service.customer.representation.CustomerRepresentation;
import com.web_services.instant_pot.service.customer.representation.CustomerRequest;
import com.web_services.instant_pot.service.customer.workflow.CustomerActivity;

@Path("/customerservice/")
public class CustomerResource implements CustomerService {
	private static CustomerActivity customerActivity = new CustomerActivity();
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/customer/{id}")
	public CustomerRepresentation getCustomerById(@PathParam("id") Long id) {
		System.out.println("GET METHOD Request for Customer with ID: " + Long.toString(id));
		return customerActivity.getCustomerById(id);
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/customers")
	public Set<CustomerRepresentation> getCustomers() {
		System.out.println("GET METHOD Request for all Customers .............");
		return customerActivity.getCustomers();
	}

	@POST
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/customer")
	public CustomerRepresentation createCustomer(CustomerRequest customerRequest) {
		System.out.println("POST METHOD Request to create new customer with name: " + customerRequest.getFirstName() + " " + customerRequest.getLastName());
		return customerActivity.createCustomer(customerRequest);
	}

	@PUT
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/customer/{id}")
	public CustomerRepresentation updateCustomer(@PathParam("id") Long id, CustomerRequest customerRequest) {
		System.out.println("POST METHOD Request to create update customer with id: " + Long.toString(id));
		return customerActivity.updateCustomer(id, customerRequest);
		
	}

//	@DELETE
//	@Consumes({"application/xml" , "application/json"})
//	@Produces({"application/xml" , "application/json"})
//	@Path("/customer/{id}")
//	public CustomerRepresentation deleteCustomer(@PathParam("id") Long id) {
//		System.out.println("DELETE METHOD Request for review with ID: " + Long.toString(id));
//		
//		return  CustomerActivity.deleteCustomer(id);
//	}

}
