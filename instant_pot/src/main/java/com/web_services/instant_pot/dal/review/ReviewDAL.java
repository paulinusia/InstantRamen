package com.web_services.instant_pot.dal.review;


import java.util.HashSet;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.web_services.instant_pot.domain.customer.Customer;
import com.web_services.instant_pot.domain.product.Product;
import com.web_services.instant_pot.domain.review.Review;

public class ReviewDAL {
	
	public Review getReviewByID(Long id) {
		Review review = new Review();
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    review = session.get(Review.class, id);
		session.close();
		return review;
	}
	
	public HashSet<Review> getAllReviewForCustomer(Long custID) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    Query query = session.createQuery("from Review where fk_customer=:custID").setParameter("custID", custID);
	    List<Review> reviews = query.list();
	    HashSet<Review> reviewSet = new HashSet<Review>(reviews);
		session.close();
		return reviewSet;
	}
	
	
	public HashSet<Review> getAllReviewForProduct(Long productID) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    Query query = session.createQuery("from Review where fk_product=:productID").setParameter("productID", productID);
	    List<Review> reviews = query.list();
	    HashSet<Review> reviewSet = new HashSet<Review>(reviews);
		session.close();
		return reviewSet;
	}
	
	public Review addReview(Long customerID, Long productID, int rating, String body, Long timestamp) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Customer customer = session.get(Customer.class, customerID);
	    Product product = session.get(Product.class, productID);
	    Review review = new Review(customer, product, rating, body, timestamp); 
	    
	    Transaction tx = session.beginTransaction();
	    session.save(review);
	    tx.commit(); 
	    session.close();
	  
	    return review;
	}
	
	public Review deleteReview(Long id){
		Review r = new Review();
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    
	    r = session.get(Review.class, id);
	    if (r != null) {
	    	Transaction tx = session.beginTransaction();
//	    	r.setCustomer(null);
//	    	r.setProduct(null);
	    	session.delete(r);
		    tx.commit();
	    } 
		session.close();
		return r;
	}
	
	public Review updateRating(Long reviewID, int newRating) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Review review = session.get(Review.class, reviewID);
	    if (review != null) {
	    	review.setReviewRating(newRating);
	    	Transaction tx = session.beginTransaction();
	    	session.save(review);
		    tx.commit();
	    } 
	    session.close();
	    
	    return review;
	}
	
	public Review updateBody(Long reviewID, String newBody) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Review review = session.get(Review.class, reviewID);
	    if (review != null) {
	    	review.setBody(newBody);
	    	Transaction tx = session.beginTransaction();
	    	session.save(review);
		    tx.commit();
	    } 
	    session.close();
	    
	    return review;
	}

	public Review updateReview(Long id, int reviewRating, String body) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    Review review = session.get(Review.class, id);
	    if (review != null) {
	    	review.setReviewRating(reviewRating);
	    	review.setBody(body);
	    	Transaction tx = session.beginTransaction();
	    	session.save(review);
		    tx.commit();
	    } 
	    session.close();
	    
	    return review;
	}

}
