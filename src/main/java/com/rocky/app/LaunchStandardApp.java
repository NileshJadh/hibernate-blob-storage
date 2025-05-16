package com.rocky.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rocky.model.StudentInfo;


public class LaunchStandardApp {

	public static void main(String args[]) {
		
		Configuration config = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		FileInputStream fis = null;
		byte image[] = null;
		FileReader reader = null;
		char textFile[] = null;
		
		
		config = new Configuration();
		config.configure();
		
		sessionFactory = config.buildSessionFactory();
		session = sessionFactory.openSession();
		
		try {
			fis = new FileInputStream("C:\\Nilesh's data\\Notes\\Java\\Computer.png");
			image = fis.readAllBytes();
			
			File file = new File("C:\\Nilesh's data\\Notes\\Java\\PersonalInfo.txt");
			reader = new FileReader(file);
			textFile = new char[(int) file.length()];
			reader.read(textFile);
		}
		catch(FileNotFoundException e) {	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		StudentInfo student = new StudentInfo();
		
		student.setsName("Rohan");
		student.setsCity("London");
		student.setImage(image);
		student.setTextfile(textFile);
		
		try {
			
			transaction = session.beginTransaction();
			
			session.persist(student);
			
			flag = true;
		}
		catch(HibernateException e1) {
			
			e1.printStackTrace();
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		finally {
			if(flag==true) {
				transaction.commit();
			}
			else {
				transaction.rollback();
			}
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			session.close();
			sessionFactory.close();
			
		}
		
		
	}
}
