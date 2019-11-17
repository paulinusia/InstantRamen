package com.web_services.instant_pot.service.partner;

import java.util.Set;

import javax.jws.WebService;

import com.web_services.instant_pot.service.partner.representation.PartnerRepresentation;
import com.web_services.instant_pot.service.partner.representation.PartnerRequest;

@WebService
public interface PartnerService {
	public Set<PartnerRepresentation> getPartners();
	public PartnerRepresentation getPartnerByID(Long id);
	public PartnerRepresentation createPartner(PartnerRequest partnerRequest);
	public PartnerRepresentation updatePartner(Long id, PartnerRequest partnerRequest);

}
