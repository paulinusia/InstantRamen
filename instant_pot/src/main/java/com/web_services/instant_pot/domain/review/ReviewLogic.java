package com.web_services.instant_pot.domain.review;

import java.util.Date;
import java.util.HashSet;

import com.web_services.instant_pot.dal.review.ReviewDAL;

import antlr.collections.List;

public class ReviewLogic {
	
	public Review getReviewByID(long reviewID) {
		ReviewDAL rd = new ReviewDAL();
		return rd.getReviewByID(reviewID);
	}
	
	public HashSet<Review> getAllReviewForCustomer(long custID){
		ReviewDAL rd = new ReviewDAL();
		return rd.getAllReviewForCustomer(custID);
	}

	public HashSet<Review> getAllReviewForProduct(long productID){
		ReviewDAL rd = new ReviewDAL();
		return rd.getAllReviewForProduct(productID);
	}
	
	public Review addReview(long custID, Long productID, int rating, String reviewBody, Long timestamp) {
		ReviewDAL rd = new ReviewDAL();
		return rd.addReview(custID, productID, rating, reviewBody, timestamp);
	}
	
	public static Review deleteReview(long reviewID) {
		ReviewDAL rd = new ReviewDAL();
		return rd.deleteReview(reviewID);
	}

}
