package com.psl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.psl.dto.User;

public class HibernateTest {
	public static void main(String[] args) {
		//  FIRST LEVEL Cache - 2 Queries to DB
		/*SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		User user = session.get(User.class, 1);

		session.getTransaction().commit();
		session.close();


		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		
		User user2 = session2.get(User.class, 1);

		session2.getTransaction().commit();
		session2.close();*/
		
		
		///////////////// Query Level Cache
	/*	User user = new User();
		user.setUserId(1);
		user.setUserName("rajesh");*/
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from User");
		query.setCacheable(true);
		List<User> list = query.list();
		System.out.println(list);

		session.getTransaction().commit();
		session.close();


		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		
		Query query2 = session2.createQuery("from User");
		query2.setCacheable(true);
		List<User> list2 = query2.list();
		System.out.println(list2);
		session2.getTransaction().commit();
		session2.close();
		
	}
}
