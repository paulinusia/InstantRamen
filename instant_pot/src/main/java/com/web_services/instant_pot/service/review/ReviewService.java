package com.web_services.instant_pot.service.review;

import java.util.HashSet;

import javax.jws.WebService;

import com.web_services.instant_pot.service.review.representation.ReviewRepresentation;
import com.web_services.instant_pot.service.review.representation.ReviewRequest;

@WebService
public interface ReviewService {
	public ReviewRepresentation getReviewByID(Long reviewID);
	//public HashSet<ReviewRepresentation> getAllReviewForCustomer(Long custID);
	//public HashSet<ReviewRepresentation> getAllReviewForProduct(Long productID);
	//public ReviewRepresentation addReview(ReviewRequest request);
	//Response deleteReview(Long reviewID);
	
}
