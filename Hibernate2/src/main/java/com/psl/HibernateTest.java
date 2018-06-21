package com.psl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.psl.dto.Address;
import com.psl.dto.User;

public class HibernateTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		User user = new User();
		user.setUserName("Mayuri");
		user.getAddresses().add(new Address("Belgaon", "KA"));
		user.getAddresses().add(new Address("Pune", "MH"));
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		user = null;
		session = sessionFactory.openSession();
		user = session.get(User.class, 1);
		System.out.println("================"+user+" "+user.getAddresses());
		session.beginTransaction();
		
	}
}
