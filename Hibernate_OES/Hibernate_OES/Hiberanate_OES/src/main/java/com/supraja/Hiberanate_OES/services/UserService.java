package com.supraja.Hiberanate_OES.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.supraja.Hiberanate_OES.Entities.User;

public class UserService {
	   private SessionFactory sessionFactory;

	    public UserService() {
	        sessionFactory = new Configuration().configure().buildSessionFactory();
	    }
	    public boolean login(String username, String password) {
	        Session session = sessionFactory.openSession();
	        Transaction transaction = null;
	        boolean isValidUser = false;
	        
	        try {
	            transaction = session.beginTransaction();
	            User user = session.createQuery("FROM User WHERE userName = :userName AND password = :password", User.class)
	                               .setParameter("userName", username)
	                               .setParameter("password", password)
	                               .uniqueResult();
	            transaction.commit();
	            isValidUser = user != null;
	        } catch (Exception e) {
	            if (transaction != null) transaction.rollback();
	            e.printStackTrace();
	        } finally {
	            session.close();
	     }
	     return isValidUser;
    }
}