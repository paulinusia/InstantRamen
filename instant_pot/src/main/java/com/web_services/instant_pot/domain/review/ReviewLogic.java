package com.web_services.instant_pot.domain.review;

import java.util.Date;
import java.util.HashSet;

import com.web_services.instant_pot.dal.product.ProductDAL;
import com.web_services.instant_pot.dal.review.ReviewDAL;
import com.web_services.instant_pot.domain.product.Product;

import antlr.collections.List;

public class ReviewLogic {
	
	public Review getReviewByID(Long reviewID) {
		ReviewDAL rd = new ReviewDAL();
		return rd.getReviewByID(reviewID);
	}
	
	public HashSet<Review> getAllReviewForCustomer(long custID){
		ReviewDAL rd = new ReviewDAL();
		return rd.getAllReviewForCustomer(custID);
	}

	public HashSet<Review> getAllReviewForProduct(Long productID){
		ReviewDAL rd = new ReviewDAL();
		return rd.getAllReviewForProduct(productID);
	}
	
	public Review addReview(long custID, Long productID, int rating, String reviewBody, Long timestamp) {
		ReviewDAL rd = new ReviewDAL();
		return rd.addReview(custID, productID, rating, reviewBody, timestamp);
	}
	
	public Review updateRating(Long reviewID, int newRating) {
		ReviewDAL rd = new ReviewDAL();
	    return rd.updateRating(reviewID, newRating);
	}
	
	public Review updateBody(Long id, String newBody) {
		ReviewDAL rd = new ReviewDAL();
		return rd.updateBody(id, newBody);
	}
	
	public Review deleteReview(long reviewID) {
		ReviewDAL rd = new ReviewDAL();
		return rd.deleteReview(reviewID);
	}

	public Review updateReview(Long id, int reviewRating, String body) {
		ReviewDAL pd = new ReviewDAL();
		return pd.updateReview(id, reviewRating, body);
	}

}
