package com.web_services.instant_pot.service.address.workflow;

import java.util.HashSet;
import java.util.Set;

import com.web_services.instant_pot.domain.address.Address;
import com.web_services.instant_pot.domain.address.AddressLogic;
import com.web_services.instant_pot.service.address.representation.AddressRepresentation;

public class AddressActivity {
	private static AddressLogic al = new AddressLogic();
	
	public AddressRepresentation getAddressByID(Long id) {
		Address address = al.getAddressByID(id);
		return getAddressRepresentation(address);
	}
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
	
	public Set<AddressRepresentation> getAllAddressForCustomer(Long customerID) {
		Set<AddressRepresentation> addressRepresentations = new HashSet<>();
		Set<Address> addresses = al.getAllAddressForCustomer(customerID);
		for (Address a : addresses) {
			addressRepresentations.add(getAddressRepresentation(a));
		}
		return addressRepresentations;
	}
	
	public Set<AddressRepresentation> getAllAddressForPartner(Long partnerID) {
		Set<AddressRepresentation> addressRepresentations = new HashSet<>();
		Set<Address> addresses = al.getAllAddressForPartner(partnerID);
		for (Address a : addresses) {
			addressRepresentations.add(getAddressRepresentation(a));
		}
		return addressRepresentations;
	}
	
	private static AddressRepresentation getAddressRepresentation(Address address) {
		AddressRepresentation ar = new AddressRepresentation();
		ar.setCity(address.getCity());
		ar.setId(address.getId());
		ar.setState(address.getState());
		ar.setStreetAddress(address.getStreetAddress());
		ar.setZip(address.getZip());
		return ar;
	}
}
