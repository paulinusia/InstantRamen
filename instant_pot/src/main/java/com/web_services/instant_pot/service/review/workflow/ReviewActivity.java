package com.web_services.instant_pot.service.review.workflow;

import java.util.HashSet;
import java.util.Set;

import com.web_services.instant_pot.domain.review.Review;
import com.web_services.instant_pot.domain.review.ReviewLogic;
import com.web_services.instant_pot.service.link.Link;
import com.web_services.instant_pot.service.review.representation.ReviewRepresentation;
import com.web_services.instant_pot.service.review.representation.ReviewRequest;

public class ReviewActivity {
	private static ReviewLogic rl = new ReviewLogic();
	
	public ReviewRepresentation getReviewByID(Long reviewID) {
		Review review = rl.getReviewByID(reviewID);
		ReviewRepresentation rRep = getReviewRepresentation(review);
		Set<Link> links = new HashSet<>();
		links.add(new Link("updateReview", "/reviewservice/review/" + rRep.getId(), "application/InstantPot.Review+xml|json"));
		links.add(new Link("deleteReview", "/reviewservice/review/" + rRep.getId(), null));
		rRep.setLinks(links);
		return rRep;
	}
	
	private static ReviewRepresentation getReviewRepresentation(Review review) {
		ReviewRepresentation reviewRepresentation = new ReviewRepresentation();
		reviewRepresentation.setId(review.getId());
		reviewRepresentation.setCustomerID(review.getCustomer().getId());
		reviewRepresentation.setProductID(review.getProduct().getId());
		reviewRepresentation.setReviewRating(review.getReviewRating());
		reviewRepresentation.setBody(review.getBody());
		reviewRepresentation.setTimestamp(review.getTimestamp());
		return reviewRepresentation;
	}
	
	public Set<ReviewRepresentation> getAllReviewForCustomer(Long custID){
		Set<Review> reviews = new HashSet<>();
		Set<ReviewRepresentation> reviewRepresentations = new HashSet<>();
		reviews = rl.getAllReviewForCustomer(custID);
		for (Review review : reviews) {
			reviewRepresentations.add(getReviewRepresentation(review));
		}
		return reviewRepresentations;
	}


	public Set<ReviewRepresentation> getAllReviewForProduct(Long productID){
		Set<Review> reviews = new HashSet<>();
		Set<ReviewRepresentation> reviewRepresentations = new HashSet<>();
		reviews = rl.getAllReviewForProduct(productID);
		for (Review review : reviews) {
			reviewRepresentations.add(getReviewRepresentation(review));
		}
		return reviewRepresentations;
	}

	public ReviewRepresentation addReview(ReviewRequest request) {
		Review review = rl.addReview(request.getCustomerID(), request.getProductID(), request.getReviewRating(),request.getBody(), request.getTimestamp());
		ReviewRepresentation rRep = getReviewRepresentation(review);
		Set<Link> links = new HashSet<>();
		links.add(new Link("updateReview", "/reviewservice/review/" + rRep.getId(), "application/InstantPot.Review+xml|json"));
		links.add(new Link("deleteReview", "/reviewservice/review/" + rRep.getId(), null));
		rRep.setLinks(links);
		return rRep;
		
	}
	
//	public ReviewRepresentation addReview(ReviewRequest reviewRequest) {
//		CustomerLogic customerLogic = new CustomerLogic();
//		Review newReview =  rl.addReview(customerLogic.getCustomer(reviewRequest.getCustomerID()), reviewRequest.getProductID(), reviewRequest.getReviewRating(), reviewRequest.getBody());
//		return getReviewRepresentation(newReview);
//	}
	
//	public String deleteReview(Long reviewID) {
//		ReviewLogic rd = new ReviewLogic();
//		rd.deleteReview(reviewID);
//		return "OK";
//	}
	
	public ReviewRepresentation deleteReview(Long reviewID) {
		Review response = rl.deleteReview(reviewID);
		return getReviewRepresentation(response);
	}
	
	public ReviewRepresentation updateReview(Long id, ReviewRequest request) {
		ReviewRepresentation rRep = getReviewRepresentation(rl.updateReview(id, request.getReviewRating(), request.getBody()));
		Set<Link> links = new HashSet<>();
		links.add(new Link("deleteReview", "/reviewservice/review/" + rRep.getId(), null));
		rRep.setLinks(links);
		return rRep;
	}

}
