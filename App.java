package com.tutorial.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) throws IOException {
		
		
		System.out.println("Project Started....");
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Student std = new Student();
		std.setId(101);
		std.setName("Avesh");
		std.setCity("Kalyan");
		System.out.println(std);
		
		// creating address class object
		Address ad = new Address();
		ad.setStreet("New Govindwadi Road");
		ad.setCity("Kalyan");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(1235.354);
		
		// reading the image.
		
		FileInputStream fis = new FileInputStream("src/main/java/pic.jpg");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);
		
		
	Session session =	factory.openSession();
		
      session.beginTransaction();
      session.save(std);
      session.save(ad);
      session.getTransaction().commit();
	
		session.close();
		System.out.println("Done....");
		
		

	}

}
