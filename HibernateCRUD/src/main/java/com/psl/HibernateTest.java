package com.psl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.psl.dto.User;

public class HibernateTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		
		//Create Resource
		for (int i=1;i<=10;i++){
			User user = new User();
			user.setUserId(i);
			user.setUserName("User "+i);
			session.save(user);
		}
		
		//Read Resource
		User user2 = session.get(User.class, 9);
		System.out.println(user2);
		
		//Update Resource
		user2.setUserName("Updated name");
		session.update(user2);
		System.out.println("After Update ==>"+user2);
		
		//Delete Resource
		session.delete(user2);
		System.out.println("After Delete ==>"+session.get(User.class,9));
		
		
		session.getTransaction().commit();
	}
}
