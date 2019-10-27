package com.web_services.instant_pot.service.review;

import java.util.HashSet;

import com.web_services.instant_pot.service.review.representation.ReviewRepresentation;
import com.web_services.instant_pot.service.review.representation.ReviewRequest;

public interface ReviewService {
	public ReviewRepresentation getReviewByID(long reviewID);
	public HashSet<ReviewRepresentation> getAllReviewForCustomer(long custID);
	public HashSet<ReviewRepresentation> getAllReviewForProduct(long productID);
	public ReviewRepresentation addReview(ReviewRequest request);
	//Response deleteReview(Long reviewID);
	
}
