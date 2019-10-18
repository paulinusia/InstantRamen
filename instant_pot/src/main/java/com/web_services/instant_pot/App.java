package com.web_services.instant_pot;

import java.util.HashSet;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.web_services.instant_pot.domain.customer.Customer;
import com.web_services.instant_pot.domain.customer.CustomerLogic;
import com.web_services.instant_pot.domain.partner.Partner;
import com.web_services.instant_pot.domain.partner.PartnerLogic;
import com.web_services.instant_pot.domain.payment.Payment;
import com.web_services.instant_pot.domain.payment.PaymentLogic;
import com.web_services.instant_pot.domain.product.Product;
import com.web_services.instant_pot.domain.product.ProductLogic;
import com.web_services.instant_pot.domain.purchase.Purchase;
import com.web_services.instant_pot.domain.review.Review;
import com.web_services.instant_pot.domain.review.ReviewLogic;

// This class is primarily for DB table initialization, testing, and modification
public class App 
{
    public static void main( String[] args )
    {
    	// Create logic class instances
    	CustomerLogic customerLogic = new CustomerLogic();
    	PartnerLogic partnerLogic = new PartnerLogic();
    	PaymentLogic paymentLogic = new PaymentLogic();
    	ProductLogic productLogic = new ProductLogic();
    	ReviewLogic reviewLogic = new ReviewLogic();
    	
    	// Create model instances
    	Customer customer1 = customerLogic.createCustomer("Bob", "Dylan", "bobdylan@luc.edu", 1234567890l);
    	Partner partner1 = partnerLogic.createPartner("McDonalds", "Food", "Sells hamburgers.");
    	Payment payment1 = paymentLogic.createPayment(5647382910293847l, 1122, 456);
    	Product product1 = productLogic.createProduct(partner1, "Product 1", "The first product.", 25.00);
    	Review review1 = reviewLogic.addReview(customer1.getId(), product1.getId(), "Product 1 is great!");
    }
}
