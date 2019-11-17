package com.web_services.instant_pot.service.partner;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.web_services.instant_pot.service.partner.workflow.PartnerActivity;
import com.web_services.instant_pot.service.partner.representation.PartnerRepresentation;
import com.web_services.instant_pot.service.partner.representation.PartnerRequest;

@Path("/partnerservice/")
public class PartnerResource {
	private static PartnerActivity partnerActivity = new PartnerActivity();

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/partners")
	public Set<PartnerRepresentation> getPartners() {
		System.out.println("GET METHOD Request for all partners .............");
		return partnerActivity.getPartners();	
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/partner/{id}")
	public PartnerRepresentation getPartner(@PathParam("id") Long id) {
		System.out.println();
		System.out.println("GET METHOD Request for partner with ID: " + Long.toString(id));
		return partnerActivity.getPartnerByID(id);
	}

	@POST
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/partner")
	public PartnerRepresentation createPartner(PartnerRequest partnerRequest) {
		System.out.println("POST METHOD Request to create new partner with name: " + partnerRequest.getPartnerName());
		return partnerActivity.createPartner(partnerRequest);
	}
	
	@PUT
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/partner/{id}")
	public PartnerRepresentation updatePartner(@PathParam("id") Long id, PartnerRequest partnerRequest) {
		System.out.println("PUT METHOD Request for partner with ID: " + Long.toString(id));
		return partnerActivity.updatePartner(id, partnerRequest);
	}

	@DELETE
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/partner/{id}")
	public PartnerRepresentation deletePartner(@PathParam("id") Long id) {
		System.out.println("DELETE METHOD Request for partner with ID: " + Long.toString(id));
		return partnerActivity.deletePartner(id);
	}

}
