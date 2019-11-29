package com.web_services.instant_pot.service.review;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import java.util.HashSet;
import java.util.Set;

import com.web_services.instant_pot.service.product.representation.ProductRepresentation;
import com.web_services.instant_pot.service.review.representation.ReviewRepresentation;
import com.web_services.instant_pot.service.review.representation.ReviewRequest;
import com.web_services.instant_pot.service.review.workflow.ReviewActivity;

@Path("/reviewservice/")
public class ReviewResource implements ReviewService {
	private static ReviewActivity rAct = new ReviewActivity();
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/review/{reviewID}")
	public 	ReviewRepresentation getReviewByID(@PathParam("reviewID") Long reviewID) {
		System.out.println(reviewID);
		System.out.println("GET METHOD Request for Review by ID .............");
		return rAct.getReviewByID(reviewID);
		
	}
	
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/customerreviews/{custID}")
	public Set<ReviewRepresentation> getAllReviewForCustomer(@PathParam("custID") Long custID){
		System.out.println("GET METHOD Request for all reviews by customer .............");
	return rAct.getAllReviewForCustomer(custID);
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/productreviews/{productID}")
	public Set<ReviewRepresentation> getAllReviewForProduct(@PathParam("productID") Long productID){
	System.out.println("GET METHOD Request for all reviews for product .............");
	return rAct.getAllReviewForProduct(productID);
	
	}
	
	@POST
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/review")
	public ReviewRepresentation addReview(ReviewRequest request) {
		System.out.println("GET METHOD Request for adding a review .............");
		return rAct.addReview(request);
	}
	
	@PUT
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/review/{id}")
	public ReviewRepresentation updateReview(@PathParam("id") Long id, ReviewRequest reviewRequest) {
		System.out.println("PUT METHOD Request for Review with ID: " + Long.toString(id));
		return rAct.updateReview(id, reviewRequest);
	}
	
	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/review/{id}")
	public ReviewRepresentation deleteReview(@PathParam("id") Long id) {
		System.out.println("DELETE METHOD Request for review with ID: " + Long.toString(id));
		return rAct.deleteReview(id);
	}
//	public Response deleteReview(@PathParam("reviewID") Long reviewID) {
//		System.out.println("DELETE METHOD Request for deleting a review .............");
//		ReviewActivity rAct = new ReviewActivity();
//		String res = rAct.deleteReview(reviewID);
//		if (rAct.equals("OK")) {
//			return Response.status(Status.OK).build();
//		}
//		return null;
//	}
	
}
