package com.web_services.instant_pot.domain.partner;

import java.util.HashSet;

import com.web_services.instant_pot.dal.partner.PartnerDAL;
import com.web_services.instant_pot.domain.partner.Partner;

public class PartnerLogic {
	
	public Partner getPartner(long partID) {
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
	
	public Partner createPartner(String partnerName, String partnerType, String description) {
		PartnerDAL pd = new PartnerDAL();
		return pd.createPartner(partnerName, partnerType, description);
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
}