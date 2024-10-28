package com.supraja.Hiberanate_OES.services;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.supraja.Hiberanate_OES.Entities.Admin;


public class AdminService {
	
		   private SessionFactory sessionFactory;

		    public AdminService() {
		        sessionFactory = new Configuration().configure().buildSessionFactory();
		    }
		    public boolean login(String username, String password) {
		        Session session = sessionFactory.openSession();
		        Transaction transaction = null;
		        boolean isValidAdmin = false;
		        
		        try {
		            transaction = session.beginTransaction();
		            Admin admin = session.createQuery("FROM Admin WHERE userName = :userName AND password = :password", Admin.class)
		                               .setParameter("userName", username)
		                               .setParameter("password", password)
		                               .uniqueResult();
		            
		            transaction.commit();
		            isValidAdmin = admin != null;
		        } catch (Exception e) {
		            if (transaction != null) transaction.rollback();
		            e.printStackTrace();
		        } finally {
		            session.close();
		     }
		     return isValidAdmin;
	    }
		    
		    public static void logout(Scanner sr) {
		    	while(true) {
					String red = "\u001B[31m";
					String reset = "\u001B[0m";
					String green = "\u001B[32m";
		    		 	System.out.println(red);
		        		System.out.println("Do you want to Logout (yes/no): ");
		        		System.out.println(reset);
		        		String s = sr.next();
		        		if(s.equalsIgnoreCase("yes")) {
		        			
		        			System.out.println(green);
		        			System.out.println("You logout Successfully...");
		        			System.out.println(reset);
		        			break;
		        		} else {
		        			System.out.println("Ok! if you want to logout please choose 'yes' ");
		        		}
		    		}
		    }
}
