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
	    
	    //create JOIN FETCH (INNER JOIN) to handle Lazy Initialization Exception
	    //Query query = session.createQuery("select body" +  "from public.review body" + "join fetch body.product" + "where review_id=:id", Review.class).setParameter("reviewID", id);
	    review = session.get(Review.class, id);
	    
		session.close();
		return review;
	}
	
	public HashSet<Review> getAllReviewForCustomer(long custID) {
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    

	    Query query = session.createQuery("from Review where customer_id=:custID").setParameter("custID", custID);
	    List<Review> reviews = query.list();
	    HashSet<Review> reviewSet = new HashSet<Review>(reviews);
	    
		session.close();
		return reviewSet;
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
	    	session.delete(r);
		    tx.commit();
	    } 
		session.close();
		return r;
	}

}
