package com.web_services.instant_pot.service.review;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
	public 	ReviewRepresentation getReviewByID(long reviewID) {
		System.out.println("GET METHOD Request for Review by ID .............");
		ReviewActivity rAct = new ReviewActivity();
		return rAct.getReviewByID(reviewID);
		
	}
	
	@Produces({"application/xml" , "application/json"})
	@Path("/reviews/{custID}")
	public HashSet<ReviewRepresentation> getAllReviewForCustomer(long custID){
	ReviewActivity rAct = new ReviewActivity();
	return rAct.getAllReviewForCustomer(custID);
	}
	
	@Produces({"application/xml" , "application/json"})
	@Path("/reviews/{productID}")
	public HashSet<ReviewRepresentation> getAllReviewForProduct(long productID){
	ReviewActivity rAct = new ReviewActivity();
	return rAct.getAllReviewForProduct(productID);
	
	}
	
	@Produces({"application/xml" , "application/json"})
	@Path("/reviews")
	public ReviewRepresentation addReview(ReviewRequest request) {
		ReviewActivity rAct = new ReviewActivity();
		return rAct.addReview(request);
	}
	
	@Produces({"application/xml" , "application/json"})
	@Path("/reviews")
	public ReviewRepresentation deleteReview(long reviewID) {
		ReviewActivity rAct = new ReviewActivity();
		return rAct.deleteReview(reviewID);
	}
}