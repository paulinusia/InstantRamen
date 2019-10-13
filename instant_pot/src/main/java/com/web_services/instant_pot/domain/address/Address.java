package com.web_services.instant_pot.domain.address;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Address {
	@Id
	@Column (name="address_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String streetAddress;
	
	private String city;
	
	private String state;
	
	private String zip;
	
	private AddressOwner addressOwner;
}
