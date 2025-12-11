package com.kodnest.updateDataHibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		// Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		// SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student id");
		int id = sc.nextInt();
		Student obj = session.get(Student.class, id);

		if (obj != null) {
			System.out.println("Enter Name and email for Updation");
			String name = sc.next();
			String email = sc.next();
			obj.setName(name);
			obj.setEmail(email);
			
			//session.update(obj);
			// session.persist(obj);
			session.merge(obj);
		} else {
			System.out.println("Student id " + id + "Not for Updation");
		}

		transaction.commit();
		session.close();
		factory.close();
		sc.close();
	}
}
