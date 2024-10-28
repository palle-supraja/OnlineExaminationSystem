package com.supraja.Hiberanate_OES.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.supraja.Hiberanate_OES.Entities.User;

import jakarta.persistence.Query;

public class UserDao {

    public static User createUser(Scanner sr) {
    
        System.out.println("Enter User Name: ");
        String u_Name = sr.next();
        System.out.println("Enter User Password: ");
        String u_Pswd = sr.next();
        System.out.println("Enter User Email: ");
        String u_Email = sr.next();

        // creating object for User
        User user = new User();
        user.setUserName(u_Name);
        user.setPassword(u_Pswd);
        user.setEmail(u_Email);
        
        return user;
    }
    
 public static void deleteUser(Scanner sr, Session session) {
    System.out.println("Enter which userId do you want to delete: ");
     	 int userId = sr.nextInt();  
     	 User user = session.get(User.class, userId);  
     	    if (user != null) {
     	        session.delete(user);
     	        System.out.println("User with ID " + userId + " has been deleted.");
     	    } else {
     	        System.out.println("No user found with ID: " + userId);
     	    }
 	} 
 
 public static void updateUser(Scanner sr, Session session) {
	 System.out.println("Enter user id which you want to update: ");
 	int existing_Id = sr.nextInt();
     User existTable = session.find(User.class,existing_Id);
     if(existTable != null) 
     {
     	System.out.println("Which field do you want to update: ");
     	System.out.println(" 1. User Name \n 2. Password \n 3. Email \n Select an Option: ");
     	int choice1 = sr.nextInt();
     	switch(choice1) {
     	case 1:
     		System.out.println("Enter New User Name :");
     		String name = sr.next();
     		existTable.setUserName(name);
     		break;
     	case 2:
     		System.out.println("Enter New Password :");
     		String password = sr.next();
     		existTable.setPassword(password);
     		break;
     	case 3:
     		System.out.println("Enter New Email :");
     		String email = sr.next();
     		existTable.setEmail(email);
     		break;
     	}	
     }
     else {
     	System.out.println("Searching with id number "+existing_Id+" is not found");
     }
 }
 
 public static void selectUser(Session session) {
    Query query1 = session.createQuery("Select u From User u", User.class);
	List<User> userList = query1.getResultList();
  	System.out.println("\nid\tpassword\tusername\tEmail");
    System.out.println("-------------------------------------------------------------");

    for (User user : userList) {
    	System.out.println(user.getId()+"\t"+user.getPassword()+"\t"+user.getUserName()+"\t\t"+user.getEmail());
    	//System.out.println(user);
   }
    System.out.println("--------------------------------------------------------------\n");

	}
}
