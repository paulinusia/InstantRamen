package com.web_services.instant_pot.service.review.workflow;

import java.util.HashSet;


import com.web_services.instant_pot.domain.review.Review;
import com.web_services.instant_pot.domain.review.ReviewLogic;
import com.web_services.instant_pot.service.review.representation.ReviewRepresentation;
import com.web_services.instant_pot.service.review.representation.ReviewRequest;

public class ReviewActivity {
	
	public ReviewRepresentation getReviewByID(long reviewID) {
		ReviewLogic rd = new ReviewLogic();
		Review review = rd.getReviewByID(reviewID);
		
		ReviewRepresentation rRep = new ReviewRepresentation();
		
		rRep.setId(review.getId());
		rRep.setCustomer(review.getCustomer());
		rRep.setProduct(review.getProduct());
		rRep.setReviewRating(review.getReviewRating());
		rRep.setBody(review.getBody());
		rRep.setTimestamp(review.getTimestamp());
		return rRep;
	}
	
	public HashSet<ReviewRepresentation> getAllReviewForCustomer(long custID){
		ReviewLogic rd = new ReviewLogic();
		HashSet<Review> reviewSet = new HashSet<Review>();
		HashSet<ReviewRepresentation> reviewRepresentations = new HashSet<ReviewRepresentation>();
		reviewSet = rd.getAllReviewForCustomer(custID);
		
		for (Review review : reviewSet) {
			ReviewRepresentation reviewRepresentation = new ReviewRepresentation();
			reviewRepresentation.setBody(review.getBody());
			reviewRepresentation.setCustomer(review.getCustomer());
			reviewRepresentation.setId(review.getId());
			reviewRepresentation.setProduct(review.getProduct());
			reviewRepresentation.setReviewRating(review.getReviewRating());
			reviewRepresentation.setTimestamp(review.getTimestamp());
		}
		
		
		return reviewRepresentations;
		
	}
	


	public HashSet<ReviewRepresentation> getAllReviewForProduct(long productID){
		ReviewLogic rd = new ReviewLogic();
		HashSet<Review> reviewProductSet = new HashSet<Review>();
		
		HashSet<ReviewRepresentation> reviewRepresentations = new HashSet<ReviewRepresentation>();
		reviewProductSet = rd.getAllReviewForProduct(productID);
		for (Review review : reviewProductSet) {
			ReviewRepresentation reviewRepresentation = new ReviewRepresentation();
			reviewRepresentation.setBody(review.getBody());
			reviewRepresentation.setCustomer(review.getCustomer());
			reviewRepresentation.setId(review.getId());
			reviewRepresentation.setProduct(review.getProduct());
			reviewRepresentation.setReviewRating(review.getReviewRating());
			reviewRepresentation.setTimestamp(review.getTimestamp());
		}
		
		
		return reviewRepresentations;
	}
	
	
	public ReviewRepresentation addReview(ReviewRequest request) {
		ReviewLogic rd = new ReviewLogic();
		
		Review review = rd.addReview(request.getCustomer().getId(), request.getProduct().getId() , request.getReviewRating(),request.getBody(), request.getTimestamp());
		
		ReviewRepresentation rRes = new ReviewRepresentation();
		rRes.setId(review.getId());
		rRes.setCustomer(review.getCustomer());
		rRes.setProduct(review.getProduct());
		rRes.setReviewRating(review.getReviewRating());
		rRes.setBody(review.getBody());	
		return rRes;
		
	}
	
	public static ReviewRepresentation deleteReview(long reviewID) {
		ReviewLogic rd = new ReviewLogic();
		
		ReviewLogic rLogic = new ReviewLogic();
		Review review = rLogic.deleteReview(reviewID);
		
		ReviewRepresentation rRes = new ReviewRepresentation();
		rRes.setId(review.getId());
		rRes.setCustomer(review.getCustomer());
		rRes.setProduct(review.getProduct());
		rRes.setReviewRating(review.getReviewRating());
		rRes.setBody(review.getBody());	
		return rRes;
	}
	
	

}
