package com.web_services.instant_pot.dal.product;

import java.util.HashSet;


import java.util.HashSet;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;


import com.web_services.instant_pot.domain.partner.Partner;
import com.web_services.instant_pot.domain.product.Product; 


public class ProductDAL {
	public Product getProductByID(long id) {
		Product product = new Product();
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    product = session.get(Product.class, id);
	    
		session.close();
		return product;
	}
	
	public HashSet<Product>  getAllProducts() {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();

	    Query query = session.createQuery("from Product");
	    List<Product> products = query.list();
	    HashSet<Product> productSet = new HashSet<Product>(products);
	    
		session.close();
		return productSet;
	}
	
	public HashSet<Product> getAllProductsByPartner(int partnerID){
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Query query = session.createQuery("from Product where partner_id=:partnerID").setParameter("partnerID", partnerID);
	    List<Product> products = query.list();
	    HashSet<Product> productSet = new HashSet<Product>(products);
	    
		session.close();
		return productSet;
	}
	
	public Product createProduct(Partner partner, String productName, String productDescription, double cost) {	
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Product product = new Product(partner, productName, productDescription, cost);
	    
	    Transaction tx = session.beginTransaction();
	    session.save(product); 
	    tx.commit();
	    session.close(); 
	  
	    return product;
	}
	
	public Product deleteProduct(long id){
		Product product = new Product();
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    
	    product = session.get(Product.class, id);
	    if (product != null) {
	    	Transaction tx = session.beginTransaction();
	    	session.delete(product);
		    tx.commit();
	    } 
		session.close();
		return product;
	}
	
	public Product updateCost(int productID, double newCost) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Product product = session.get(Product.class, productID);
	    if (product != null) {
	    	product.setCost(newCost);
	    	Transaction tx = session.beginTransaction();
	    	session.save(product);
		    tx.commit();
	    } 
	    session.close();
	    
	    return product;
	}
	
	public Product updateProductDescription(int productID, String productDescription) {

		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    Product product = session.get(Product.class, productID);
	    if (product != null) {
	    	product.setProductDescription(productDescription);
	    	Transaction tx = session.beginTransaction();
	    	session.save(product);
		    tx.commit();
	    } 
	    session.close();
	    
	    return product;
	    
	}
	
	
	public Product updateProductName(int productID, String productName) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    Product product = session.get(Product.class, productID);
	    if (product != null) {
	    	product.setProductName(productName);
	    	Transaction tx = session.beginTransaction();
	    	session.save(product);
		    tx.commit();
	    } 
	    session.close();
	    
	    return product;
	}


}


