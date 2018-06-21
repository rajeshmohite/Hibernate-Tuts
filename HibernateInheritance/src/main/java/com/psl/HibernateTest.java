package com.psl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.psl.dto.FourWheeler;
import com.psl.dto.TwoWheeler;
import com.psl.dto.Vehicle;

public class HibernateTest {
	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("CAR");
		
		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setVehicleName("R15");
		twoWheeler.setSteeringHandle("Bike");
		
		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setVehicleName("Ferrari");
		fourWheeler.setSteeringWheel("CAR");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession(); 
		session.beginTransaction();
		
		session.save(vehicle);
		session.save(twoWheeler);
		session.save(fourWheeler);
		
		session.getTransaction().commit();
		session.close();
		
	}
}
