package com.web_services.instant_pot.service.address;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.web_services.instant_pot.dal.address.AddressDAL;
import com.web_services.instant_pot.domain.address.Address;
import com.web_services.instant_pot.service.address.representation.AddressRepresentation;
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
//	public Address getAddressByID(Long id) {
//		AddressDAL ad = new AddressDAL();
//		return ad.getAddressByID(id);
//	}
//	
//	public Address createAddress(String streetAddress, String city, String state, String zip) {
//		AddressDAL ad = new AddressDAL();
//		return ad.createAddress(streetAddress, city, state, zip);
//	}
//	
//	public Address updateAddress(Long id, String streetAddress, String city, String state, String zip) {
//		AddressDAL ad = new AddressDAL();
//		return ad.updateAddress(id, streetAddress, city, state, zip);
//	}
//	
//	public Address removeAddressFromCustomer(Long addressID, Long customerID) {	
//		AddressDAL ad = new AddressDAL();
//		return ad.removeAddressFromCustomer(addressID, customerID);
//	}
//	
//	public Address removeAddressFromPartner(Long addressID, Long partnerID) {	
//		AddressDAL ad = new AddressDAL();
//		return ad.removeAddressFromPartner(addressID, partnerID);
//	}
//	
//	public Address addAddressToCustomer(Long addressID, Long customerID) {	
//		AddressDAL ad = new AddressDAL();
//		return ad.addAddressToCustomer(addressID, customerID);
//	}
//	
//	public Address addAddressToPartner(Long addressID, Long partnerID) {	
//		AddressDAL ad = new AddressDAL();
//		return ad.addAddressToPartner(addressID, partnerID);
//	}
//	
//	public Address deleteAddress(Long id){
//		AddressDAL ad = new AddressDAL();
//		return ad.deleteAddress(id);
//	}
}
