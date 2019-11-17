package com.web_services.instant_pot.domain.address;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.web_services.instant_pot.dal.address.AddressDAL;
import com.web_services.instant_pot.domain.address.Address;
import com.web_services.instant_pot.domain.customer.Customer;
import com.web_services.instant_pot.domain.partner.Partner;
import com.web_services.instant_pot.domain.product.Product;
import com.web_services.instant_pot.domain.review.Review;

public class AddressLogic {
		
		public Address getAddressByID(Long id) {
			AddressDAL ad = new AddressDAL();
			return ad.getAddressByID(id);
		}
		
		public Address createAddress(String streetAddress, String city, String state, String zip) {
			AddressDAL ad = new AddressDAL();
			return ad.createAddress(streetAddress, city, state, zip);
		}
		
		public Address updateAddress(Long id, String streetAddress, String city, String state, String zip) {
			AddressDAL ad = new AddressDAL();
			return ad.updateAddress(id, streetAddress, city, state, zip);
		}
//		
//		public Address removeAddressFromCustomer(Long addressID, Long customerID) {	
//			AddressDAL ad = new AddressDAL();
//			return ad.removeAddressFromCustomer(addressID, customerID);
//		}
//		
//		public Address removeAddressFromPartner(Long addressID, Long partnerID) {	
//			AddressDAL ad = new AddressDAL();
//			return ad.removeAddressFromPartner(addressID, partnerID);
//		}
//		
//		public Address addAddressToCustomer(Long addressID, Long customerID) {	
//			AddressDAL ad = new AddressDAL();
//			return ad.addAddressToCustomer(addressID, customerID);
//		}
//		
//		public Address addAddressToPartner(Long addressID, Long partnerID) {	
//			AddressDAL ad = new AddressDAL();
//			return ad.addAddressToPartner(addressID, partnerID);
//		}
//		
		public Address deleteAddress(Long id){
			AddressDAL ad = new AddressDAL();
			return ad.deleteAddress(id);
		}
		
		public Set<Address> getAllAddressForCustomer(Long customerID) {
			AddressDAL ad = new AddressDAL();
			return ad.getAllAddressForCustomer(customerID);
		}
}
