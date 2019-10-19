package com.web_services.instant_pot;

import java.util.HashSet;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.web_services.instant_pot.domain.address.Address;
import com.web_services.instant_pot.domain.address.AddressLogic;
import com.web_services.instant_pot.domain.customer.Customer;
import com.web_services.instant_pot.domain.customer.CustomerLogic;
import com.web_services.instant_pot.domain.partner.Partner;
import com.web_services.instant_pot.domain.partner.PartnerLogic;
import com.web_services.instant_pot.domain.payment.Payment;
import com.web_services.instant_pot.domain.payment.PaymentLogic;
import com.web_services.instant_pot.domain.product.Product;
import com.web_services.instant_pot.domain.product.ProductLogic;
import com.web_services.instant_pot.domain.purchase.Purchase;
import com.web_services.instant_pot.domain.purchase.PurchaseLogic;
import com.web_services.instant_pot.domain.review.Review;
import com.web_services.instant_pot.domain.review.ReviewLogic;

// This class is primarily for DB table initialization, testing, and modification
public class App 
{
    public static void main( String[] args )
    {
    	// Create logic class instances
    	AddressLogic addressLogic = new AddressLogic();
    	CustomerLogic customerLogic = new CustomerLogic();
    	PartnerLogic partnerLogic = new PartnerLogic();
    	PaymentLogic paymentLogic = new PaymentLogic();
    	ProductLogic productLogic = new ProductLogic();
    	PurchaseLogic purchaseLogic = new PurchaseLogic();
    	ReviewLogic reviewLogic = new ReviewLogic();
    	
    	// Create model instances
    	Address address1 = addressLogic.createAddress("123 Main Street", "Chicago", "IL", "60660");
    	Address address2 = addressLogic.createAddress("234 Main Street", "Chicago", "IL", "60660");
    	Address address3 = addressLogic.createAddress("345 Main Street", "Chicago", "IL", "60660");
    	Address address4 = addressLogic.createAddress("456 Main Street", "Chicago", "IL", "60660");
    	Customer customer1 = customerLogic.createCustomer("Bob", "Dylan", "bobdylan@luc.edu", 1234567890l);
    	Customer customer2 = customerLogic.createCustomer("Snoop", "Dogg", "snoopdogg@hotmail.com", 4567891234l);
    	Partner partner1 = partnerLogic.createPartner("McDonalds", "Food", "Sells hamburgers.");
    	Partner partner2 = partnerLogic.createPartner("Burger King", "Food", "Sells chicken fries.");
    	Payment payment1 = paymentLogic.createPayment(5647382910293847l, 1122, 456);
    	Payment payment2 = paymentLogic.createPayment(8888999922223333l, 0521, 343);
    	Payment payment3 = paymentLogic.createPayment(1111222233334444l, 1122, 456);
    	Payment payment4 = paymentLogic.createPayment(2143658754763298l, 0521, 343);
    	Product product1 = productLogic.createProduct(partner1, "Product 1", "The first product.", 25.00);
    	Product product2 = productLogic.createProduct(partner1, "Product 2", "The second product.", 20.00);
    	Product product3 = productLogic.createProduct(partner1, "Product 3", "The third product.", 17.00);
    	Product product4 = productLogic.createProduct(partner1, "Product 4", "The fourth product.", 230.00);
    	Review review1 = reviewLogic.addReview(customer1.getId(), product1.getId(), 5, "Product 1 is great!", System.currentTimeMillis());
    	Review review2 = reviewLogic.addReview(customer2.getId(), product1.getId(), 3, "Product 1 is alright!", System.currentTimeMillis());
    	Review review3 = reviewLogic.addReview(customer1.getId(), product2.getId(), 4, "Product 1 is good!", System.currentTimeMillis());
    	Review review4 = reviewLogic.addReview(customer2.getId(), product2.getId(), 2, "Product 1 is pretty bad!", System.currentTimeMillis());
    	Review review5 = reviewLogic.addReview(customer1.getId(), product3.getId(), 5, "Product 1 is great!", System.currentTimeMillis());
    	Review review6 = reviewLogic.addReview(customer2.getId(), product3.getId(), 1, "Product 1 is awful!", System.currentTimeMillis());
    	Review review7 = reviewLogic.addReview(customer1.getId(), product4.getId(), 5, "Product 1 is great!", System.currentTimeMillis());
    	Review review8 = reviewLogic.addReview(customer2.getId(), product4.getId(), 3, "Product 1 is alright!", System.currentTimeMillis());
    	
    	// Create additional relationships
    	
    	addressLogic.addAddressToCustomer(address1.getId(), customer1.getId());
    	addressLogic.addAddressToCustomer(address2.getId(), customer1.getId());
    	addressLogic.addAddressToCustomer(address1.getId(), customer2.getId());
    	addressLogic.addAddressToCustomer(address2.getId(), customer2.getId());
    	
    	addressLogic.addAddressToPartner(address3.getId(), partner1.getId());
    	addressLogic.addAddressToPartner(address4.getId(), partner1.getId());
    	addressLogic.addAddressToPartner(address3.getId(), partner2.getId());
    	addressLogic.addAddressToPartner(address4.getId(), partner2.getId());
    	
    	paymentLogic.addPaymentToCustomer(payment1.getId(), customer1.getId());
    	paymentLogic.addPaymentToCustomer(payment2.getId(), customer1.getId());
    	paymentLogic.addPaymentToCustomer(payment3.getId(), customer2.getId());
    	paymentLogic.addPaymentToCustomer(payment4.getId(), customer2.getId());
    	
    	HashSet<Product> productSet1 = new HashSet<Product>();
    	productSet1.add(product1);
    	productSet1.add(product2);
    	Purchase purchase1 = purchaseLogic.newPurchase(customer1, productSet1, "needed things", "Ordered", payment1, address1);
    	HashSet<Product> productSet2 = new HashSet<Product>();
    	productSet1.add(product3);
    	productSet1.add(product4);
    	Purchase purchase2 = purchaseLogic.newPurchase(customer1, productSet2, "needed more things", "Ordered", payment2, address2);

    	Purchase purchase3 = purchaseLogic.newPurchase(customer2, productSet1, "wanted things", "Ordered", payment3, address1);
    	Purchase purchase4 = purchaseLogic.newPurchase(customer2, productSet2, "wanted more things", "Ordered", payment4, address2);
    }
}
