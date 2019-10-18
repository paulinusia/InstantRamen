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
	
	public Review getReviewByID(long id) {
		Review review = new Review();
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    review = session.get(Review.class, id);
	    
		session.close();
		return review;
	}
	
	public HashSet<Review> getAllReviewForCustomer(long custID) {
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    

	    Query query = session.createQuery("from Review where customer_id=:custID").setParameter("custID", custID);
	    List reviews = query.list();
	    HashSet<Review> ReviewSet = new HashSet<Review>(reviews);
	    
		session.close();
		return ReviewSet;
	}
	
	
	public HashSet<Review> getAllReviewForProduct(long productID) {
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    

	    Query query = session.createQuery("from Review where product_id=:productID").setParameter("productID", productID);
	    List<Review> reviews = query.list();
	    HashSet<Review> ReviewSet = new HashSet<Review>(reviews);
	    
		session.close();
		return ReviewSet;
	}
	
	public Review addReview(Long customerID, Long productID, String body) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Customer customer = session.get(Customer.class, customerID);
	    Product product = session.get(Product.class, productID);
	    Review review = new Review(customer, product, body); 
	    
	    Transaction tx = session.beginTransaction();
	    session.save(review);
	    tx.commit(); 
	    session.close();
	  
	    return review;
	}
	
	public Review deleteReview(long id){
		Review r = new Review();
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    
	    r = session.get(Review.class, id);
	    if (r != null) {
	    	Transaction tx = session.beginTransaction();
	    	session.delete(r);
		    tx.commit();
	    } 
		session.close();
		return r;
	}

}