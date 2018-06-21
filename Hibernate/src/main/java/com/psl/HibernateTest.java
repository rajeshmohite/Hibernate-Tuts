package com.psl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.psl.dto.User;

public class HibernateTest {
	public static void main(String[] args) {
		User user = new User();
		user.setUserId(1);
		user.setUserName("rajesh");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = session.get(User.class, 1);
		System.out.println(user);
		user.setUserName("raj");
		session.update(user);
		session.getTransaction().commit();
		session.close();
		
	}
}
