package com.web_services.instant_pot.domain.review;

import java.util.HashSet;

import com.web_services.instant_pot.dal.review.ReviewDAL;

import antlr.collections.List;

public class ReviewLogic {
	
	public Review getReviewByID(int reviewID) {
		ReviewDAL rd = new ReviewDAL();
		return rd.getReviewByID(reviewID);
	}
	
	public HashSet<Review> getAllReviewForCustomer(int custID){
		ReviewDAL rd = new ReviewDAL();
		return rd.getAllReviewForCustomer(custID);
	}

	public HashSet<Review> getAllReviewForProduct(int productID){
		ReviewDAL rd = new ReviewDAL();
		return rd.getAllReviewForProduct(productID);
	}
	
	public Review addReview(Long custID, Long productID, String reviewBody) {
		ReviewDAL rd = new ReviewDAL();
		return rd.addReview(custID, productID, reviewBody);
	}
	
	public static Review deleteReview(int reviewID) {
		ReviewDAL rd = new ReviewDAL();
		return rd.deleteReview(reviewID);
	}

}
