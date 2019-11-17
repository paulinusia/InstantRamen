package com.web_services.instant_pot.service.address.workflow;

import java.util.HashSet;
import java.util.Set;

import com.web_services.instant_pot.domain.address.Address;
import com.web_services.instant_pot.domain.address.AddressLogic;
import com.web_services.instant_pot.domain.partner.PartnerLogic;
import com.web_services.instant_pot.domain.product.Product;
import com.web_services.instant_pot.service.address.representation.AddressRepresentation;
import com.web_services.instant_pot.service.address.representation.AddressRequest;
import com.web_services.instant_pot.service.product.representation.ProductRepresentation;
import com.web_services.instant_pot.service.product.representation.ProductRequest;

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
//	public Address deleteAddress(Long id){
//		AddressDAL ad = new AddressDAL();
//		return ad.deleteAddress(id);
//	}
	
	public AddressRepresentation createAddress(AddressRequest addressRequest) {
		Address newAddress = al.createAddress(addressRequest.getStreetAddress(), addressRequest.getCity(), addressRequest.getState(), addressRequest.getZip(), addressRequest.getOwnerId(), addressRequest.getOwnerType());
		return getAddressRepresentation(newAddress);
	}
	
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
	
	public AddressRepresentation updateAddress(Long id, AddressRequest addressRequest) {
		return getAddressRepresentation(al.updateAddress(id, addressRequest.getStreetAddress(), addressRequest.getCity(), addressRequest.getState(), addressRequest.getZip()));
	}
	
	private static AddressRepresentation getAddressRepresentation(Address address) {
		AddressRepresentation ar = new AddressRepresentation();
		ar.setCity(address.getCity());
		ar.setId(address.getId());
		ar.setState(address.getState());
		ar.setStreetAddress(address.getStreetAddress());
		ar.setZip(address.getZip());
		if (address.getCustomer() != null) ar.setCustomerId(address.getCustomer().getId());
		if (address.getPartner() != null) ar.setPartnerId(address.getPartner().getId());
		return ar;
	}
}
