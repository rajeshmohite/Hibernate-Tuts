package com.psl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.psl.dto.User;
import com.psl.dto.Vehicle;

public class HibernateTest {
	public static void main(String[] args) {
		 
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		User user = new User();
		user.setUserName("Raj");
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Ninja");
		user.setVehicle(vehicle);
		
		session.save(user);
		session.save(vehicle);
		transaction.commit();
		
		session.close();
		sessionFactory.close();
	}
}
