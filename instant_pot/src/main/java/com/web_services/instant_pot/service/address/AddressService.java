package com.web_services.instant_pot.service.address;

import java.util.Set;

import javax.jws.WebService;

//import com.web_services.instant_pot.domain.address.Address;
import com.web_services.instant_pot.service.address.representation.AddressRepresentation;
import com.web_services.instant_pot.service.address.representation.AddressRequest;

@WebService
public interface AddressService {
	public AddressRepresentation getAddressByID(Long id);
//	
	public AddressRepresentation createAddress(AddressRequest addressRequest);
//	
//	public Address updateAddress(Long id, String streetAddress, String city, String state, String zip);
//	
//	public Address deleteAddress(Long id);
	
	public Set<AddressRepresentation> getAllAddressForCustomer(Long customerID);
	
	public Set<AddressRepresentation> getAllAddressForPartner(Long partnerID);
}
