package com.web_services.instant_pot;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
//import java.util.List;
//
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//import static org.junit.Assert.*;
//import org.junit.Test;
//
//import com.web_services.instant_pot.domain.product.Product;
//
////NOTE: THIS TEST WILL ONLY WORK IF HIBERNATE AUTO-DDL ID SET TO 'create-drop' DUE TO HARD-CODED IDs
//public class CrudTest
//{
//	@Test
//	public void crud() {
//		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        
//        List<Product> results;
//        
//        create(session);
//        results = read(session);
//        assertEquals(2, results.size());
//        
//        update(session);
//        results = read(session);
//        for (Product p : results) {
//        	if (p.getName().equals("Corn")) assertEquals(15.00, p.getPrice(), 0);
//        }
//        
//        delete(session);
//        results = read(session);
//        assertEquals(0, results.size());
//        
//        session.close();
//	}
//	
//	private void create(Session session) {
//		Product corn = new Product();
//		corn.setName("Corn");
//		corn.setPrice(3.00);
//		
//		Product bread = new Product();
//		bread.setName("Bread");
//		bread.setPrice(2.00);
//		
//		session.beginTransaction();
//		session.save(corn);
//		session.save(bread);
//		session.getTransaction().commit();
//		System.out.println("Created Products.");
//	}
//	
//	private List<Product> read(Session session) {
//		List<Product> products = session.createQuery("FROM Product").list();
//		System.out.println("Reading Products...");
//		System.out.println("Product List:");
//		for (Product p : products) {
//			System.out.println(p.toString());
//		}
//		
//		return products;
//	}
//	
//	private void update(Session session) {
//		Product corn = (Product) session.get(Product.class, 1L);
//		corn.setName("Corn");
//		corn.setPrice(15.00);
//		
//		session.beginTransaction();
//        session.saveOrUpdate(corn);
//        session.getTransaction().commit();
//        System.out.println("Updated Product: " + corn.getName());
//	}
//	
//	private void delete(Session session) {
//		Product corn = (Product) session.get(Product.class, 1L);
//		Product bread = (Product) session.get(Product.class, 2L);
//		
//		session.beginTransaction();
//        session.delete(corn);
//        session.delete(bread);
//        session.getTransaction().commit();
//        System.out.println("Deleted Products.");
//    }
//}

