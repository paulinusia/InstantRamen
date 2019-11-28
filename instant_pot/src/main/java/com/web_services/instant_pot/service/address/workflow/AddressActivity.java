package com.web_services.instant_pot.service.address.workflow;

import java.util.HashSet;
import java.util.Set;

import com.web_services.instant_pot.domain.address.Address;
import com.web_services.instant_pot.domain.address.AddressLogic;
import com.web_services.instant_pot.service.address.representation.AddressRepresentation;
import com.web_services.instant_pot.service.address.representation.AddressRequest;
import com.web_services.instant_pot.service.link.Link;

public class AddressActivity {
	private static AddressLogic al = new AddressLogic();
	
	public AddressRepresentation getAddressByID(Long id) {
		Address address = al.getAddressByID(id);
		AddressRepresentation aRep = getAddressRepresentation(address);
		Set<Link> links = new HashSet<>();
		links.add(new Link("updateAddress", "/addressservice/address/" + aRep.getId(), "application/InstantPot.Address+xml|json"));
		links.add(new Link("deleteAddress", "/addressservice/address/" + aRep.getId(), null));
		aRep.setLinks(links);
		return aRep;
	}
	
	public AddressRepresentation createAddress(AddressRequest addressRequest) {
		Address newAddress = al.createAddress(addressRequest.getStreetAddress(), addressRequest.getCity(), addressRequest.getState(), addressRequest.getZip(), addressRequest.getOwnerId(), addressRequest.getOwnerType());
		AddressRepresentation aRep = getAddressRepresentation(newAddress);
		Set<Link> links = new HashSet<>();
		links.add(new Link("updateAddress", "/addressservice/address/" + aRep.getId(), "application/InstantPot.Address+xml|json"));
		links.add(new Link("deleteAddress", "/addressservice/address/" + aRep.getId(), null));
		aRep.setLinks(links);
		return aRep;
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
		AddressRepresentation aRep = getAddressRepresentation(al.updateAddress(id, addressRequest.getStreetAddress(), addressRequest.getCity(), addressRequest.getState(), addressRequest.getZip()));
		Set<Link> links = new HashSet<>();
		links.add(new Link("deleteAddress", "/addressservice/address/" + aRep.getId(), null));
		aRep.setLinks(links);
		return aRep;
	}
	
	public AddressRepresentation deleteAddress(Long id) {
		Address result = al.deleteAddress(id);
		return getAddressRepresentation(result);
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
