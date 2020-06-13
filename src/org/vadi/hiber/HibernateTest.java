package org.vadi.hiber;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.vadi.hiber.model.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserName("vadi");
		user.setJoinDate(new Date());
		user.setAddress("Bangalore");
		user.setDescription("Test User 1");
		
		UserDetails user2 = new UserDetails();
		user2.setUserName("raj");
		user2.setJoinDate(new Date());
		user2.setAddress("Tumkur");
		user2.setDescription("Test User 2");
		
		/***********Insert***********/
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);		
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
