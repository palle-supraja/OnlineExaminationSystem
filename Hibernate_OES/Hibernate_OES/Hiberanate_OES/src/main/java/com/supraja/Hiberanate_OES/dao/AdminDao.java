package com.supraja.Hiberanate_OES.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.supraja.Hiberanate_OES.Entities.Admin;

import jakarta.persistence.Query;

public class AdminDao {


    public static Admin createAdmin(Scanner sr, Session session) {
        System.out.println("Enter Admin username: ");
        String u_Name = sr.next();
        System.out.println("Enter Admin password: ");
        String pswd = sr.next();
        
        
        Admin admin = new Admin();
        admin.setUserName(u_Name);
        admin.setPassword(pswd);
           
        return admin;
    }
    
 public static void deleteAdmin(Scanner sr, Session session) {
    System.out.println("Enter which adminId do you want to delete: ");
     	 int adminId = sr.nextInt();  
     	 Admin admin = session.find(Admin.class, adminId);  
   
     	    if (admin != null) {
     	       session.remove(admin);
     	        System.out.println("Admin with ID " + adminId + " has been deleted.");
     	    } else {
     	        System.out.println("No admin found with ID: " + adminId);
     	    }
 		}
 public static void updateAdmin(Scanner sr, Session session) {
  System.out.println("Enter Admin id which you want to update: ");
	int Admin_Id = sr.nextInt();
    Admin AdminTable = session.find(Admin.class,Admin_Id);
    if(AdminTable != null) 
    {
    	System.out.println("Which field do you want to update: ");
    	System.out.println(" 1. User Name \n 2. password \nSelect an Option: ");
    	int choice3 = sr.nextInt();
    	switch(choice3) {
    	case 1:
    		System.out.println("Enter New User Name :");
    		String name = sr.next();
    		AdminTable.setUserName(name);
    		break;
    	case 2:
			System.out.println("Enter New password :");
			String pswd = sr.next();
			AdminTable.setPassword(pswd);
			break;
    	}	
    }
    else {
    	System.out.println("Searching with id number "+Admin_Id+" is not found");
    	}
 	}
 
 public static void selectAdmin(Session session) {
	 Query query2 = session.createQuery("Select a From Admin a", Admin.class);
     List<Admin> adminList = query2.getResultList();
     System.out.println("\nid\tpassword\tusername\tuser_id");
     System.out.println("-------------------------------------------------");

     for (Admin admin : adminList) {
     	System.out.println(admin.getId()+"\t"+admin.getPassword()+"\t"+admin.getUserName()+"\t"+admin.getUser());
     	//System.out.println(admin);
    }
     System.out.println("-------------------------------------------------\n");
 
 	}
}
