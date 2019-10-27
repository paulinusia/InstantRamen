package com.web_services.instant_pot.service.review;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import java.util.HashSet;
import java.util.Set;
import com.web_services.instant_pot.service.product.representation.ProductRepresentation;
import com.web_services.instant_pot.service.review.representation.ReviewRepresentation;
import com.web_services.instant_pot.service.review.representation.ReviewRequest;
import com.web_services.instant_pot.service.review.workflow.ReviewActivity;

@WebService
public class ReviewResource implements ReviewService {
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/reviews/{reviewID}")
	public 	ReviewRepresentation getReviewByID(Long reviewID) {
		System.out.println("GET METHOD Request for Review by ID .............");
		ReviewActivity rAct = new ReviewActivity();
		return rAct.getReviewByID(reviewID);
		
	}
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/reviews/{custID}")
	public HashSet<ReviewRepresentation> getAllReviewForCustomer(Long custID){
		System.out.println("GET METHOD Request for all reviews by customer .............");
	ReviewActivity rAct = new ReviewActivity();
	return rAct.getAllReviewForCustomer(custID);
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/reviews/{productID}")
	public HashSet<ReviewRepresentation> getAllReviewForProduct(Long productID){
	System.out.println("GET METHOD Request for all reviews for product .............");
	ReviewActivity rAct = new ReviewActivity();
	return rAct.getAllReviewForProduct(productID);
	
	}
	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/reviews")
	public ReviewRepresentation addReview(ReviewRequest request) {
		System.out.println("GET METHOD Request for adding a review .............");
		ReviewActivity rAct = new ReviewActivity();
		return rAct.addReview(request);
	}
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/reviews")
	public Response deleteReview(Long reviewID) {
		System.out.println("GET METHOD Request for deleting a review .............");
		ReviewActivity rAct = new ReviewActivity();
		if (rAct.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		return null;
	}
}
