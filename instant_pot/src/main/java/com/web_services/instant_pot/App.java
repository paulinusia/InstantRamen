package com.web_services.instant_pot;

import java.util.HashSet;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.web_services.instant_pot.domain.Customer;
import com.web_services.instant_pot.domain.Partner;
import com.web_services.instant_pot.domain.Product;
import com.web_services.instant_pot.domain.Purchase;
import com.web_services.instant_pot.domain.Review;

public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        // Create new customer
        Customer customer = new Customer();
        customer.setName("New Customer");
        customer.setAddress("123 Broadway");
        customer.setCustomerDetail("NC Detail");
        
        // Create new product
        Product product = new Product();
        product.setName("Carrot");
        product.setDescription("It's a carrot");
        product.setPrice(17.38);
        
        // Create new purchase
        Purchase purchase = new Purchase();
        purchase.setPurchaseDetail("It's a purchase");
        purchase.setPurchaseStatus("Shipped");
        purchase.setPurchasePayment("Credit Card 0123456789");
        
        // Create new partner
        Partner partner = new Partner();
        partner.setName("Main Partner");
        partner.setPhoneNumber("1234567891");
        partner.setPartnerType("Primary");
        partner.setDescription("It's a partner");
        
        // Create new review
        Review review = new Review();
        review.setComment("is good");
        review.setRating(5);
        review.setTimestamp(12345678910l);
        
        // Initially save objects in DB
        Transaction tx = session.beginTransaction();
	    session.save(customer);
	    session.save(partner);
	    session.save(review);
	    session.save(product);
	    session.save(purchase);
	    tx.commit();
        
        // Set relationships
        HashSet<Purchase> allPurchases = new HashSet<>();
        allPurchases.add(purchase);
        customer.setPurchases(allPurchases);
        HashSet<Review> allReviews = new HashSet<>();
        allReviews.add(review);
        customer.setReviews(allReviews);
        product.setReviews(allReviews);
        product.setProductOwner(partner);
        HashSet<Product> allProducts = new HashSet<>();
        partner.setProducts(allProducts);
        
        // Save objects in DB
        tx = session.beginTransaction();
	    session.save(customer);
	    session.save(partner);
	    session.save(review);
	    session.save(product);
	    session.save(purchase);
	    tx.commit();
	    
	    // Get all customers from DB
//	    Query query = session.createQuery("from Customer");
//	    HashSet<Customer> customers = query.HashSet();
	    
	    session.close();
    }
}
