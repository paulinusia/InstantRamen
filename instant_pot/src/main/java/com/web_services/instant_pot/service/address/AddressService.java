package com.web_services.instant_pot.service.address;

import java.util.Set;

import javax.jws.WebService;

import com.web_services.instant_pot.domain.address.Address;
import com.web_services.instant_pot.service.address.representation.AddressRepresentation;

@WebService
public interface AddressService {
//	public Address getAddressByID(Long id);
//	
//	public Address createAddress(String streetAddress, String city, String state, String zip);
//	
//	public Address updateAddress(Long id, String streetAddress, String city, String state, String zip);
//	
//	public Address removeAddressFromCustomer(Long addressID, Long customerID);
//	
//	public Address removeAddressFromPartner(Long addressID, Long partnerID);
//	
//	public Address addAddressToCustomer(Long addressID, Long customerID);
//	
//	public Address addAddressToPartner(Long addressID, Long partnerID);
//	
//	public Address deleteAddress(Long id);
	
	public Set<AddressRepresentation> getAllAddressForCustomer(Long customerID);
}
