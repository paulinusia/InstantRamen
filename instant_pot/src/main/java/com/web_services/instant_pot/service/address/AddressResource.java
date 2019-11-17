package com.web_services.instant_pot.service.address;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.web_services.instant_pot.service.address.representation.AddressRepresentation;
import com.web_services.instant_pot.service.address.representation.AddressRequest;
import com.web_services.instant_pot.service.address.workflow.AddressActivity;

@Path("/addressservice/")
public class AddressResource implements AddressService {
	private static AddressActivity aa = new AddressActivity();
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/customeraddresses/{id}")
	public Set<AddressRepresentation> getAllAddressForCustomer(@PathParam("id") Long customerID) {
		System.out.println("GET METHOD Request for all Addresses from Customer with ID: " + Long.toString(customerID));
		return aa.getAllAddressForCustomer(customerID);
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/partneraddresses/{id}")
	public Set<AddressRepresentation> getAllAddressForPartner(@PathParam("id") Long partnerID) {
		System.out.println("GET METHOD Request for all Addresses from Partner with ID: " + Long.toString(partnerID));
		return aa.getAllAddressForPartner(partnerID);
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/address/{id}")
	public AddressRepresentation getAddressByID(@PathParam("id") Long id) {
		System.out.println("GET METHOD Request for Address with ID: " + Long.toString(id));
		return aa.getAddressByID(id);
	}
	
	@POST
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/address")
	public AddressRepresentation createAddress(AddressRequest addressRequest) {
		System.out.println("POST METHOD Request to create new Address with street address: " + addressRequest.getStreetAddress());
		return aa.createAddress(addressRequest);
	}
	
	@PUT
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/address/{id}")
	public AddressRepresentation updateAddress(@PathParam("id") Long id, AddressRequest addressRequest) {
		System.out.println("PUT METHOD Request for Address with ID: " + Long.toString(id));
		return aa.updateAddress(id, addressRequest);
	}
	
	@DELETE
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/address/{id}")
	public AddressRepresentation deleteAddress(@PathParam("id") Long id) {
		System.out.println("DELETE METHOD Request for Address with ID: " + Long.toString(id));
		return aa.deleteAddress(id);
	}
}
