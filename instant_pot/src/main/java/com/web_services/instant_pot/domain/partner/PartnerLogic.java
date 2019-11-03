package com.web_services.instant_pot.domain.partner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.web_services.instant_pot.dal.partner.PartnerDAL;
import com.web_services.instant_pot.domain.address.Address;
import com.web_services.instant_pot.domain.partner.Partner;

public class PartnerLogic {
	
	public Partner getPartner(Long partID) {
		PartnerDAL pd = new PartnerDAL();
		Partner partner = pd.getPartnerByID(partID);
		return partner;
	}
	
	public HashSet<Partner> getAllPartners() {
		PartnerDAL pd = new PartnerDAL();
		HashSet<Partner> partners = new HashSet<Partner>();
		partners = pd.getAllPartners();
		return partners;
	}
	
	public Partner createPartner(String partnerName, String partnerType, String description, Long phoneNumber) {
		PartnerDAL pd = new PartnerDAL();
		return pd.createPartner(partnerName, partnerType, description, phoneNumber);
	}
	
	public Partner deletePartner(long id) {
		PartnerDAL pd = new PartnerDAL();
		Partner partner = pd.deletePartner(id);
		return partner;
	}
	
	public Partner updateName(long id, String newName) {
		PartnerDAL pd = new PartnerDAL();
		Partner partner = pd.updateName(id, newName);
		return partner;
	}
	
	public Partner updatePhoneNumber(long id, long newNumber) {
		PartnerDAL pd = new PartnerDAL();
		Partner partner = pd.updatePhoneNumber(id, newNumber);
		return partner;
	}
	
	public Partner updateDescription(long id, String description) {
		PartnerDAL pd = new PartnerDAL();
		Partner partner = pd.updateDescription(id, description);
		return partner;
	}
	
	public HashSet<Address> getAllAddressForPartner(Long partID) {
		PartnerDAL pd = new PartnerDAL();
		return pd.getAllAddressForPartner(partID);		
	}
}