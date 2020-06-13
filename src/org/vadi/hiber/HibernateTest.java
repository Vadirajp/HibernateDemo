package org.vadi.hiber;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.vadi.hiber.model.Address;
import org.vadi.hiber.model.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserName("vadi");
		user.setJoinDate(new Date());
		user.setDescription("Test User 1");
		Address addr = new Address();
		addr.setCity("Banglore");
		addr.setState("Karnataka");
		addr.setStreet("Whilte Field");
		addr.setPincode("1234");
		user.setOfficeAddress(addr);
		
		Address addr2 = new Address();
		addr2.setCity("TMK");
		addr2.setState("Karnataka");
		addr2.setStreet("KYT");
		addr2.setPincode("5678");
		user.setHomeAddress(addr2);
		
		/***********Insert***********/
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);	
		session.getTransaction().commit();
		session.close();
		/***********Insert***********/
		
		user = null;
		
		/***********Fetching***********/
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 1);
		session.close();
		System.out.println(user.toString());
		/***********Fetching***********/
		
	}

}
