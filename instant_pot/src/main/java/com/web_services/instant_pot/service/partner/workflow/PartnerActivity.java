package com.web_services.instant_pot.service.partner.workflow;

import java.util.HashSet;
import java.util.Set;

import com.web_services.instant_pot.domain.partner.Partner;
import com.web_services.instant_pot.domain.partner.PartnerLogic;
import com.web_services.instant_pot.service.link.Link;
import com.web_services.instant_pot.service.partner.representation.PartnerRepresentation;
import com.web_services.instant_pot.service.partner.representation.PartnerRequest;

public class PartnerActivity {
	
	private static PartnerLogic pl = new PartnerLogic();


	public Set<PartnerRepresentation> getPartners() {
		Set<Partner> partners = pl.getAllPartners();
		Set<PartnerRepresentation> partnerRepresentations = new HashSet<PartnerRepresentation>();
		
		for (Partner partner : partners) {
			PartnerRepresentation partnerRepresentation = getPartnerRepresentation(partner);
			partnerRepresentations.add(partnerRepresentation);
		}
		
		return partnerRepresentations;
	}

	private PartnerRepresentation getPartnerRepresentation(Partner partner) {
		PartnerRepresentation pRep = new PartnerRepresentation();
		pRep.setId(partner.getId());
		pRep.setPartnerName(partner.getName());
		pRep.setDescription(partner.getDescription());
		pRep.setPartnerType(partner.getPartnerType());
		pRep.setPhoneNumber(partner.getPhoneNumber());
		return pRep;
	}

	public PartnerRepresentation getPartnerByID(Long id) {
		PartnerRepresentation pRep = getPartnerRepresentation(pl.getPartnerByID(id));
		Set<Link> links = new HashSet<>();
		links.add(new Link("updatePartner", "/partnerservice/partner/" + pRep.getId(), "application/InstantPot.Partner+xml|json"));
		links.add(new Link("createAddress", "/addressservice/address", "application/InstantPot.Address+xml|json"));
		links.add(new Link("createProduct", "/productservice/product", "application/InstantPot.Product+xml|json"));
		links.add(new Link("getAddressesForPartner", "/addressservice/partneraddresses/" + pRep.getId(), null));
		links.add(new Link("getProductsForPartner", "/productservice/partnerproducts/" + pRep.getId(), null));
		pRep.setLinks(links);
		return pRep;
	}

	public PartnerRepresentation createPartner(PartnerRequest partnerRequest) {
		PartnerLogic partnerLogic = new PartnerLogic();
		Partner newPartner =  partnerLogic.createPartner(partnerRequest.getPartnerName(), partnerRequest.getPartnerType(), partnerRequest.getDescription(), partnerRequest.getPhoneNumber());
		PartnerRepresentation pRep = getPartnerRepresentation(newPartner);
		Set<Link> links = new HashSet<>();
		links.add(new Link("updatePartner", "/partnerservice/partner/" + pRep.getId(), "application/InstantPot.Partner+xml|json"));
		links.add(new Link("createAddress", "/addressservice/address", "application/InstantPot.Address+xml|json"));
		links.add(new Link("createProduct", "/productservice/product", "application/InstantPot.Product+xml|json"));
		links.add(new Link("getAddressesForPartner", "/addressservice/partneraddresses/" + pRep.getId(), null));
		links.add(new Link("getProductsForPartner", "/productservice/partnerproducts/" + pRep.getId(), null));
		pRep.setLinks(links);
		return pRep;
	}

	public PartnerRepresentation updatePartner(Long id, PartnerRequest partnerRequest) {
		PartnerLogic partnerLogic = new PartnerLogic();
		Partner partner = partnerLogic.updatePartner(id, partnerRequest.getPartnerName(), partnerRequest.getDescription(), partnerRequest.getPhoneNumber());
		PartnerRepresentation pRep = getPartnerRepresentation(partner);
		Set<Link> links = new HashSet<>();
		links.add(new Link("createAddress", "/addressservice/address", "application/InstantPot.Address+xml|json"));
		links.add(new Link("createProduct", "/productservice/product", "application/InstantPot.Product+xml|json"));
		links.add(new Link("getAddressesForPartner", "/addressservice/partneraddresses/" + pRep.getId(), null));
		links.add(new Link("getProductsForPartner", "/productservice/partnerproducts/" + pRep.getId(), null));
		pRep.setLinks(links);
		return pRep;
	}

//	public PartnerRepresentation deletePartner(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
