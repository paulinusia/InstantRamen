package com.web_services.instant_pot;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        
        Product product1 = new Product();
        product1.setName("Product 1");
        Review review1 = new Review();
        review1.setRating(5);
        review1.setComment("It was good");
        Partner partner1 = new Partner();
        partner1.setName("Partner 1");
        Customer customer1 = new Customer();
        customer1.setName("Customer 1");
        Purchase purchase1 = new Purchase();
        purchase1.setPurchaseStatus("Shipped");
        
        session.beginTransaction();
        
        session.save(product1);
        session.save(review1);
        session.save(partner1);
        session.save(customer1);
        session.save(purchase1);
		session.getTransaction().commit();
		
		session.close();
    }
}
