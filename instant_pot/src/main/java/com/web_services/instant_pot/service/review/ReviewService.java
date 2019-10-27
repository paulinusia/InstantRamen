package com.web_services.instant_pot.service.review;

import java.util.HashSet;

import com.web_services.instant_pot.service.review.representation.ReviewRepresentation;
import com.web_services.instant_pot.service.review.representation.ReviewRequest;

public interface ReviewService {
	ReviewRepresentation getReviewByID(long reviewID);
	HashSet<ReviewRepresentation> getAllReviewForCustomer(long custID);
	HashSet<ReviewRepresentation> getAllReviewForProduct(long productID);
	ReviewRepresentation addReview(ReviewRequest request);
	ReviewRepresentation deleteReview(long reviewID);
}
