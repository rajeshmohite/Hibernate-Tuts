package com.psl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.psl.dto.User;

public class HibernateTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		for(int i=1;i<=10;i++){
			User user = new User();
			user.setUserName("User "+i);
			session.save(user);
		}
		/*
		//////////////// SELECT & Pagination
		Query query = session.createQuery("from User");
		query.setFirstResult(3);
		query.setMaxResults(4);
		List<User> list = query.list();
		System.out.println(list);
		*/
		
		/*
		/////////////// SQL Injection 
		String minUserId = "6 or 1 = 1";
		Query query = session.createQuery("from User where userId > "+minUserId);
		List<User> list = query.list();
		System.out.println(list);
		*/
		
		/*
		///////////////// Parameter Binding
		String minUserId = "6";
		String userName = "User 9";
		Query query = session.createQuery("from User where userId > :userId and userName = :userName");
		query.setInteger("userId", Integer.parseInt(minUserId));
		query.setString("userName", userName);
		List<User> list = query.list();
		System.out.println(list);
		*/
		
		/*
		//////////////// Criteria API
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.ge("userId", 3));
		List list = criteria.list();
		System.out.println(list);
		*/
		
		session.getTransaction().commit();
		session.close();
	}
}
