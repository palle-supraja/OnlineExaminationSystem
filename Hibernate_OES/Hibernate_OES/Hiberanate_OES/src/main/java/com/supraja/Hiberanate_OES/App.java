package com.supraja.Hiberanate_OES;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.supraja.Hiberanate_OES.Entities.Course;
import com.supraja.Hiberanate_OES.Entities.Exam;
import com.supraja.Hiberanate_OES.Entities.Options;
import com.supraja.Hiberanate_OES.Entities.Questions;
import com.supraja.Hiberanate_OES.Entities.Result;
import com.supraja.Hiberanate_OES.Entities.User;
import com.supraja.Hiberanate_OES.dao.AdminDao;
import com.supraja.Hiberanate_OES.dao.CourseDao;
import com.supraja.Hiberanate_OES.dao.ExamDao;
import com.supraja.Hiberanate_OES.dao.OptionsDao;
import com.supraja.Hiberanate_OES.dao.QuestionsDao;
import com.supraja.Hiberanate_OES.dao.ResultDao;
import com.supraja.Hiberanate_OES.dao.UserDao;
import com.supraja.Hiberanate_OES.services.AdminService;
import com.supraja.Hiberanate_OES.services.ExamService;
import com.supraja.Hiberanate_OES.services.UserService;

public class App 
{
   public static void main( String[] args )
     {
	   Configuration con = new Configuration().configure();
	// Take sessionFactory  
       SessionFactory sf = con.buildSessionFactory();
       Session session = sf.openSession();
       Transaction tx = null;
       
       try {
    	  
    	   tx = session.beginTransaction();
       
       		// Create services
       
    	 	UserService userService = new UserService();
    	 	AdminService adminService = new AdminService();
    	 	
    	 // ANSI escape code2
    		//ANSI escape codes are used to control text formatting, such as colors, boldness, blinking, etc...
                    
    	 			String blue = "\u001B[34m";
                    String purple="\u001B[35m";
                    String green="\u001B[32m";
                    String reset="\u001B[0m";
                    String yellow="\u001B[33m";
                    String red ="\u001B[31m";

    	    Scanner sr = new Scanner(System.in);

    	    System.out.println(yellow);
    	    System.out.println("	***************** ");
    	    System.out.print(blue);
    	    System.out.println("WELCOME TO ONLINE EXAMINATION SYSTEM ! ");
    	    System.out.println(reset);
	        //System.out.println("------------------------------------------------------------------");
    	    System.out.println(yellow);
	        System.out.println("	***************** ");
	        System.out.println(reset);
	        
    	    System.out.println("Do you want to login as \n 1. Admin \n 2. User \n 3. Register (if new user) \n 4. Exit\nSelect choice: ");
    	    int choice = sr.nextInt();
    	    switch(choice){
    	    	
    	    case 1:
    	    	System.out.println("Username: ");
   	    	 	String admin_Username = sr.next();
   	    	    
   	    	 	System.out.println("Password: ");
   	    	 	String admin_Password = sr.next();
   	    	 
   	    	 	if (adminService.login(admin_Username,admin_Password)) {
   	    	 		
   	    	 	System.out.println(green);
   	    	        System.out.println("Login successfully!");
   	    	        System.out.println("Do you want to perform CRUD operation (yes/no)");
   	    	        System.out.println(reset);
   	    	        String choice1 = sr.next();
   	    	        if(choice1.equalsIgnoreCase("yes")) {
   	    	        	
   	    	        	System.out.println(purple);
   	 
   	    	        	System.out.println("Which operation do you want to perform? : ");
   	    		        System.out.println(" 1. Insertion \n 2. Delete \n 3. Update \n 4. Display data(Read) \n 5. Exit/Logout");
   	    		        System.out.println("Select an option: ");
   	    		        System.out.println(reset);
   	    		        int i = sr.nextInt();
   	    		        
   	    		       if(i == 1) {
   	    		       boolean insert_Record = true ;
   	    		       
   	    		      while(insert_Record) {  
   	    		      
   	    		    	System.out.println(yellow);
   	    		    	System.out.println("On which table do you want to perform an Operation");
   	    		       
   	    		    	System.out.println("---------------------------------------------------");
   	    		        System.out.println(" 1. User \n 2. Course \n 3. Exam \n 4. Questions \n 5. Options \n 6. Result");
   	    		        System.out.println("Select an option: ");
   	    		        System.out.println(reset);
   	    		        int choice2 = sr.nextInt();
   	    		        
   	    		       
   	    		        switch (choice2) {
   	    		            case 1:
   	    		    	        User user = UserDao.createUser(sr);
   	    		    	        session.save(user);
   	    		                break;
   	    		            case 2:
   	    		                Course course = CourseDao.createCourse(sr, session);
   	    		                session.save(course);
   	    		                break;
   	    		            case 3:
   	    		                Exam exam = ExamDao.createExam(sr, session);
   	    		                session.save(exam);
   	    		                break;
   	    		            case 4:
   	    		                Questions questions = QuestionsDao.createQuestions(sr, session);
   	    		                session.save(questions);
   	    		                break;
   	    		            case 5:
   	    		                Options options = OptionsDao.createOptions(sr, session);
   	    		                session.save(options);
   	    		                break;
   	    		            case 6:
   	    		                Result result = ResultDao.createResult(sr, session);
   	    		                session.save(result);
   	    		                break;	
   	    		            default:
   	    		            	System.out.println(red);
   	    		            	System.out.println("Invalid choice!");
   	    		            	System.out.println("Please Select Correct Choice....");
   	    		            	System.out.println(reset);
   	    		                break;	            
   	    		        }
   	    		        System.out.println(purple+"Do you want to insert a record or not? (yes/no): "+purple);
   	    		        String continueInput = sr.next();
   	    		        if (continueInput.equalsIgnoreCase("yes")) {
   	    		        	insert_Record = true;
   	    		        }
   	    		        else {
   	    		        	insert_Record = false ;
					System.out.println(green);
   	    		        	System.out.println("Exit Successfully...");
					System.out.println(reset);
   	    		        	
   	    		        	AdminService.logout(sr);
   	    		        	break;
   	    		        	}
   	    		
   	    		      }
   	    		 }
   	    		        
   	   	        else if(i == 2) {
   	   	        	boolean delete_Record = true ;
   	   	        	while(delete_Record) {
   	   	        	
				System.out.println(yellow);
   	   		        System.out.println("On Which table do you want to perform a delete operation: ");
   	   		        System.out.println(" 1. User \n 2. Admin \n 3. Course \n 4. Exam \n 5. Questions \n 6. Options \n 7. Result \n Select an option: ");
   	   		        System.out.println(reset);

   	   		        int choice2 = sr.nextInt();
   	   		        
   	   		        switch(choice2) {
   	   		        
   	   		        case 1: 
   	   		        	UserDao.deleteUser(sr, session);
   	   		        	break;
   	   		        case 2: 
   	   		        	AdminDao.deleteAdmin(sr, session);
   	   		        	break;
   	   		        case 3: 
   	   		        	CourseDao.deleteCourse(sr, session);
   	   		        	break;
   	   		        case 4: 
   	   		        	ExamDao.deleteExam(sr,session);
   	   		        	break;
   	   		        case 5: 
   	   		        	QuestionsDao.deleteQuestions(sr, session);
   	   		        	break;
   	   		       	case 6: 
   	   		    	   	OptionsDao.deleteOptions(sr, session);
   	   		    	   	break;
   	   		        case 7: 
   	   		        	ResultDao.deleteResult(sr, session);
   	   		        	break;		
   	   		        default:
					System.out.println(red);
   	   			    	System.out.println("Invalid choice!");
   	   			    	System.out.println("Please select a valid choice!..");
					System.out.println(reset);
   	   			    	break;
   	   		        }
   	   		        
   	   		     
   	   		        //System.out.println("Do you want to delete a record or not? (yes/no): ");
				System.out.println(red);
   	   		        System.out.println("Do you want to delete another table records or not? (yes/no): ");
				System.out.println(reset);
   	   		        String continueInput = sr.next();
   	   		        delete_Record = continueInput.equalsIgnoreCase("yes");
   	   		        if(continueInput.equalsIgnoreCase("no")) {
   	   		        	delete_Record = false ;
					System.out.println(green);
   	   		        	System.out.println("Exit Successfully...");
					System.out.println(reset);
   	   		        	AdminService.logout(sr);
   	   		        	break;
   	   		        }
   	   	    }
   	   } 
   	    		       	   	        
   	    		        else if(i == 3) {
   	    		        	boolean update_Record = true ;
   	    		        	while(update_Record) {
   	    		        		
   	    				System.out.println(yellow);
   	    		        	System.out.println("On Which table do you want to perform a update operation: ");
   	    		        	System.out.println(" 1. Admin \n 2. Course \n 3. Exam \n 4. Questions \n 5. Options \n 6. Result \n Select an Option: ");
					System.out.println(reset);
   	    			        int choice2 = sr.nextInt();
   	    		
   	    		        	switch(choice2) {
   	    		        	case 1:
   	    		        		AdminDao.updateAdmin(sr, session);
   	    		        		break;
   	    		        	case 2:
   	    			            	CourseDao.updateCourse(sr, session);
   	    		        		break;
   	    		        	case 3:
   	    		        		ExamDao.updateExam(sr, session);
   	    		        		break;
   	    		        	case 4:
	 	    			        QuestionsDao.updateQuestions(sr, session);
   	    		        		break;
   	    		        	case 5:
   	    		        		OptionsDao.updateOptions(sr, session);
   	    		        		break;
   	    		        	case 6:
   	    		        		ResultDao.updateResult(sr, session);
   	    		        		break;
   	    		        	  default:
						System.out.println(red);
   	    			                System.out.println("Invalid choice!");
   	    			                System.out.println("please select correct choice...");
						System.out.println(reset);
   	    			                break;
   	    		        }
					
					System.out.println(red);
   	    			        System.out.println("Do you want to update a record or not? (yes/no): ");
					System.out.println(reset);
   	    			        String continueInput = sr.next();
   	    			        update_Record = continueInput.equalsIgnoreCase("yes");
   	    			        if(continueInput.equalsIgnoreCase("no")) {
   	    			        	update_Record = false;
						System.out.println(green);
   	    			        	System.out.println("Exit Successfully...");
      						System.out.println(reset);
   	    			        	AdminService.logout(sr);
   	   	    		        	break;
   	    			        }
   	    			      
   	    		        }
   	    		     }
   	    		        

   	    		        else if(i == 4) {
   	    		 	        	boolean retrieve_Record = true ;
   	    		 	        	while(retrieve_Record) {

   	    		 	        System.out.println(yellow);
   	    		              	System.out.println("Which table data do you want to retrieve");
   	    		        	System.out.println(" 1. User \n 2. Admin \n 3. Course \n 4. Exam \n 5. Questions \n 6. Options \n 7. Result \n Select an option: ");
					System.out.println(reset);
   	    		        	int choice2 = sr.nextInt();
   	    		        	
   	    		        	switch(choice2) {
   	    		        	case 1:
   	    		        		UserDao.selectUser(session);
   	    		            	break;
   	    		        	case 2:
   	    		        		AdminDao.selectAdmin(session);
   	    		        		break;
   	    		        	case 3:
   	    		        		CourseDao.selectCourse(session);
   	    		        		break;
   	    		        	case 4:
   	    		        		ExamDao.selectExam(sr,session);
   	    		        		break;
   	    		        	case 5:
   	    		        		QuestionsDao.selectQuestions(session);
   	    		        		break;
   	    		        	case 6:
   	    		        		OptionsDao.selectOptions(session);
   	    		        		break;
   	    		        	case 7:
   	    		        		ResultDao.selectResult(session);
   	    		        		break;
   	    		            default:
					System.out.println(red);
   	    		            	System.out.println("Invalid Choice!");
   	    		            	System.out.println("Please select a vlaid choice....");
					System.out.println(reset);
   	    		            	break;
   	    		        }
					System.out.println(purple);
   	    			        System.out.println("Do you want to Retrieve other record? (yes/no): ");
					System.out.println(reset);
   	    			        String continueInput = sr.next();
   	    			        retrieve_Record = continueInput.equalsIgnoreCase("yes");
   	    			        if(continueInput.equalsIgnoreCase("no")) {
   	    			        	retrieve_Record = false ;
						System.out.println(green);
   	    			        	System.out.println("Exit Successfully...");
						System.out.println(reset);
   	    			        	
   	    			        	AdminService.logout(sr);
   	   	    		        	break;
   	    			        }
   	    		        }
   	    		     }
   	    		       
   	    		else if(i == 5) {
				System.out.println(green);
   		        	System.out.println("Exit Successfully...");
	    		    }
   	    	     else {
			System.out.println(red);
   	    	        System.out.println("Invalid choice!");
			System.out.println(reset);
   	    	      }
   	    	    } else {
			System.out.println(green);
   	    	        System.out.println("Exit Successfully...");
			System.out.println(reset);
   	    	        AdminService.logout(sr);
   	    	    }
   	    	 }
   	    	 	else {
   	    	 		System.out.print(red);
   	    	 		System.out.println("Login failed. Please check your username and password.");
   	    	 		System.out.print(reset);
   	    	 	}
   	    	 break;
    	    case 2:
    	    	 System.out.println("Username: ");
    	    	 String username = sr.next();
    	    	    
    	    	 System.out.println("Password: ");
    	    	 String password = sr.next();
    	    	 
    	    	 if (userService.login(username, password)) {
    	    		 
    	    		 System.out.println(green);
    	    	        System.out.println("Login Successful!");
    	    	        System.out.println(reset);
    	    	 
			System.out.println(purple);
    	    	        System.out.println("Do you want to perform delete, update , retrieve operation (yes/no)");
			System.out.println(reset);
    	    	        String s =sr.next();
    	    	        if(s.equalsIgnoreCase("yes")) {
    	    	        	System.out.println("Which operation do you want to perform");
    	    	        	System.out.println("1. update opeartion            2. delete operation          3. display (Read) your Record 		4. To Take the Exam");
				System.out.println("Select Option: ");
    	    	        	
    	    	        	int choice2 = sr.nextInt();
    	    	        	switch(choice2) {
    	    	        		case 1:
    	    	        			UserDao.updateUser(sr, session);
    	    	        			break;
    	    	        		case 2:
    	    	        			UserDao.deleteUser(sr, session);
    	    	        			break;
    	    	        		case 3:
    	    	        			UserDao.selectUser(session);
    	    	        			break;
    	    	        		case 4:
    	    	        			 ExamService.start(session);
    	    	        			 break;
    	    	        		default:
						System.out.println(red);
    	    	        			System.out.println("Invalid choice!");
						System.out.println(reset);
    	    	        			break;
    	    	        	}
    	    	        }
    	    	        else {
				 System.out.println(purple);
    	    	        	 System.out.println("Do you want to take the Exam! (yes/no): ");
				 System.out.println(reset);
    	    	        	 String start = sr.next();
    	    	        	 if(start.equalsIgnoreCase("yes")) {
	 
    	    	        		  ExamService.start(session);
    	    	        	 }
    	    	        	 else {
					System.out.println(green);
    	    	        		 System.out.println("Exit Successfully...");
					System.out.println(reset);
    	    	        		 
    	    	        		 AdminService.logout(sr);
    	   	    		         break;
    	    	        	 }
    	    	        }
    	    	   
    	    	    } else {
			System.out.println(red);
    	    	        System.out.println("Login failed. Please check your username and password.");
			System.out.println(reset);
    	    	    }
    	    	 break;
    	    case 3:
    	    	System.out.println("Enter below details to register! ");
    	        User user = UserDao.createUser(sr);
    	        session.save(user);
    	        System.out.println(yellow);
    	        System.out.println("Registered Successfully...");
    	        System.out.println(reset);
    	    	break;
    	    case 4:
		System.out.println(green);
    	    	System.out.println("Exit Successfully...");
		System.out.println(reset);
    	    	break;
    	    default:
		System.out.println(red);
    	    	System.out.println("Invalid choice!");
		System.out.println(reset);
    	    	break;
    	    }
    	    
    	    tx.commit();
    	    sf.close();
       }
       catch(Exception e) {
    	   if(tx != null) {
    		   tx.rollback();
    	   }
    	   e.printStackTrace();
       	} finally {
    		   session.close();
    		   sf.close();
    	   }
     }
}
