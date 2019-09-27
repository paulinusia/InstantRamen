package com.web_services.instant_pot;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.web_services.instant_pot.model.Customer;
import com.web_services.instant_pot.model.Partner;
import com.web_services.instant_pot.model.Product;
import com.web_services.instant_pot.model.Review;

public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        Product product1 = new Product();
        product1.setName("Product 1");
        Review review1 = new Review();
        review1.setRating(5);
        review1.setComment("It was good");
        Partner partner1 = new Partner();
        partner1.setName("Partner 1");
        Customer customer1 = new Customer();
        customer1.setName("Customer 1");
        
        session.beginTransaction();
        
        session.save(product1);
        session.save(review1);
        session.save(partner1);
        session.save(customer1);
		session.getTransaction().commit();
		
		session.close();
    }
}
