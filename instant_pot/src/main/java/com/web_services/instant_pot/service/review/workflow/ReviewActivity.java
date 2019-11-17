package com.web_services.instant_pot.service.review.workflow;

import java.util.HashSet;

import com.web_services.instant_pot.domain.partner.PartnerLogic;
import com.web_services.instant_pot.domain.product.Product;
import com.web_services.instant_pot.domain.review.Review;
import com.web_services.instant_pot.domain.review.ReviewLogic;
import com.web_services.instant_pot.service.product.representation.ProductRepresentation;
import com.web_services.instant_pot.service.product.representation.ProductRequest;
import com.web_services.instant_pot.service.review.representation.ReviewRepresentation;
import com.web_services.instant_pot.service.review.representation.ReviewRequest;

public class ReviewActivity {
	
	public ReviewRepresentation getReviewByID(Long reviewID) {
		ReviewLogic rd = new ReviewLogic();
		Review review = rd.getReviewByID(reviewID);
		
		ReviewRepresentation rRep = new ReviewRepresentation();
		
		rRep.setId(review.getId());
		rRep.setCustomerID(review.getCustomer().getId());
		rRep.setProductID(review.getProduct().getId());
		rRep.setReviewRating(review.getReviewRating());
		rRep.setBody(review.getBody());
		rRep.setTimestamp(review.getTimestamp());
		return rRep;
	}
	
//	public HashSet<ReviewRepresentation> getAllReviewForCustomer(Long custID){
//		ReviewLogic rd = new ReviewLogic();
//		HashSet<Review> reviewSet = new HashSet<Review>();
//		HashSet<ReviewRepresentation> reviewRepresentations = new HashSet<ReviewRepresentation>();
//		reviewSet = rd.getAllReviewForCustomer(custID);
//		
//		for (Review review : reviewSet) {
//			ReviewRepresentation reviewRepresentation = new ReviewRepresentation();
//			reviewRepresentation.setBody(review.getBody());
//			reviewRepresentation.setCustomer(review.getCustomer());
//			reviewRepresentation.setId(review.getId());
//			reviewRepresentation.setProduct(review.getProduct());
//			reviewRepresentation.setReviewRating(review.getReviewRating());
//			reviewRepresentation.setTimestamp(review.getTimestamp());
//		}
//		
//		
//		return reviewRepresentations;
//		
//	}
//	
//
//
//	public HashSet<ReviewRepresentation> getAllReviewForProduct(Long productID){
//		ReviewLogic rd = new ReviewLogic();
//		HashSet<Review> reviewProductSet = new HashSet<Review>();
//		
//		HashSet<ReviewRepresentation> reviewRepresentations = new HashSet<ReviewRepresentation>();
//		reviewProductSet = rd.getAllReviewForProduct(productID);
//		for (Review review : reviewProductSet) {
//			ReviewRepresentation reviewRepresentation = new ReviewRepresentation();
//			reviewRepresentation.setBody(review.getBody());
//			reviewRepresentation.setCustomer(review.getCustomer());
//			reviewRepresentation.setId(review.getId());
//			reviewRepresentation.setProduct(review.getProduct());
//			reviewRepresentation.setReviewRating(review.getReviewRating());
//			reviewRepresentation.setTimestamp(review.getTimestamp());
//		}
//		
//		
//		return reviewRepresentations;
//	}
	
	
	public ReviewRepresentation addReview(ReviewRequest request) {
		ReviewLogic rd = new ReviewLogic();
		
		Review review = rd.addReview(request.getCustomerID(), request.getProductID(), request.getReviewRating(),request.getBody(), request.getTimestamp());
		
		ReviewRepresentation rRes = new ReviewRepresentation();
		rRes.setId(review.getId());
		rRes.setCustomerID(review.getCustomer().getId());
		rRes.setProductID(review.getProduct().getId());
		rRes.setReviewRating(review.getReviewRating());
		rRes.setBody(review.getBody());	
		return rRes;
		
	}
//	public ReviewRepresentation addReview(ReviewRequest reviewRequest) {
//		CustomerLogic customerLogic = new CustomerLogic();
//		Review newReview =  rl.addReview(customerLogic.getCustomer(reviewRequest.getCustomerID()), reviewRequest.getProductID(), reviewRequest.getReviewRating(), reviewRequest.getBody());
//		return getReviewRepresentation(newReview);
//	}
	
	public String deleteReview(Long reviewID) {
		ReviewLogic rd = new ReviewLogic();
		
		rd.deleteReview(reviewID);
		
		return "OK";
	}
	
	

}
