package com.web_services.instant_pot.dal.partner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.web_services.instant_pot.domain.address.Address;
import com.web_services.instant_pot.domain.partner.Partner;

public class PartnerDAL {
	
	public Partner getPartnerByID(long id) {
		Partner partner = new Partner();
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		
		partner = session.get(Partner.class, id);
		
		session.close();
		return partner;
	}
	
	public HashSet<Partner> getAllPartners() {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		
		Query query = session.createQuery("from Partner");
		List<Partner> partners = query.list();
		HashSet<Partner> partnerSet = new HashSet<Partner>(partners);
		
		session.close();
		return partnerSet;
	}
	
	public Partner createPartner(String partnerName, String partnerType, String description, Long phoneNumber) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		
		Partner newPartner = new Partner(partnerName, partnerType, description, phoneNumber);
		
		Transaction tx = session.beginTransaction();
		session.save(newPartner);
		tx.commit();
		session.close();
		
		return newPartner;
	}
	
	public Partner deletePartner(long id) {
		Partner p = new Partner();
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		
		p = session.get(Partner.class, id);
		if (p != null) {
			Transaction tx = session.beginTransaction();
			session.delete(p);
			tx.commit();
		}
		session.close();
		return p;
	}
	
	public Partner updateName(long id, String newName) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		
		Partner p = session.get(Partner.class, id);
		if (p != null) {
			p.setName(newName);
			Transaction tx = session.beginTransaction();
			session.save(p);
			tx.commit();
		}
		session.close();
		return p;
	}
	
	public Partner updatePhoneNumber(long id, long phoneNumber) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		
		Partner p = session.get(Partner.class, id);
		if (p != null) {
			p.setPhoneNumber(phoneNumber);
			Transaction tx = session.beginTransaction();
			session.save(p);
			tx.commit();
		}
		session.close();
		return p;
	}
	
	public Partner updateDescription(long id, String description) {
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sf.openSession();
		
		Partner p = session.get(Partner.class, id);
		if (p != null) {
			p.setDescription(description);
			Transaction tx = session.beginTransaction();
			session.save(p);
			tx.commit();
		}
		session.close();
		return p;
	}
	
	public HashSet<Address> getAllAddressForPartner(Long partID) {
		
		SessionFactory sf = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = sf.openSession();
	    

	    Query query = session.createQuery("from partner_address where partner_id=:partID").setParameter("partID", partID);
	    List addressIDs = query.list();
	    List addresses = new ArrayList<Address>();
	    
	    for (Object addressID : addressIDs) {
	    	query = session.createQuery("from address where address_id=:addID").setParameter("addID", (Long) addressID );
	    	addresses.add((Address) query.getSingleResult());
	    }	
	    
	    HashSet<Address> AddressSet = new HashSet<Address>(addresses);
		session.close();
		return AddressSet;
	}

}
