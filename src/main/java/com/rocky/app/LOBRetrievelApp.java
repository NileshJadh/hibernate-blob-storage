package com.rocky.app;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rocky.model.StudentInfo;

public class LOBRetrievelApp {

	public static void main(String[] args) {
		
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		
		FileOutputStream fos = null; 
		FileWriter writer = null;
		
		config = new Configuration();
		config.configure();
		config.addAnnotatedClass(StudentInfo.class);
		
		sessionFactory = config.buildSessionFactory();
		session =  sessionFactory.openSession();
		
		StudentInfo studentInfo = session.get(StudentInfo.class, 3);
		
		try {
			
			 fos = new FileOutputStream("Computer.png");
			 writer = new FileWriter("PersonalInfo.txt");
			fos.write(studentInfo.getImage());
			writer.write(studentInfo.getTextfile());
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			session.close();
			sessionFactory.close();
		}
		
	}

}
