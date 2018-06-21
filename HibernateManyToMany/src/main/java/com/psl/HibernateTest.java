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
		user.setUserName("Rajesh");
		
		User user2 = new User();
		user2.setUserName("priyanka");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("CAR");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("R15");
		
		user.getVehicle().add(vehicle);
		user2.getVehicle().add(vehicle2);
		vehicle.getUserList().add(user);
		vehicle2.getUserList().add(user2);
		
		session.save(user);
		session.save(user2);
		session.save(vehicle);
		session.save(vehicle2);
		transaction.commit();
		
		session.close();
	}
}
