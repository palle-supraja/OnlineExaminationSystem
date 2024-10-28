package com.supraja.Hiberanate_OES.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.supraja.Hiberanate_OES.Entities.Result;
import com.supraja.Hiberanate_OES.Entities.User;

import jakarta.persistence.Query;

public class ResultDao {


    public static Result createResult(Scanner sr, Session session) {
   
        System.out.println("Enter Result (Pass/Fail): ");
        String res_PassFail = sr.next();
        System.out.println("Enter Grade: ");
        char res_Grade = sr.next().charAt(0);
        System.out.println("Enter Marks Obtained: ");
        int res_Opt = sr.nextInt();
        System.out.println("Enter Rank: ");
        int res_Rank = sr.nextInt();

        Result result = new Result();
        result.setPassFail(res_PassFail);
        result.setGrade(res_Grade);
        result.setMarksObtained(res_Opt);
        
        System.out.println("Enter User Id for the Results: ");
        int userId = sr.nextInt();
        User user = session.get(User.class, userId);  

        if (user != null) {
            result.setId(userId);  
        } else {
            System.out.println("User Id with "+userId+" is not found!");
        }

        return result;
    }
  
    public static void deleteResult(Scanner sr, Session session) {
    	System.out.println("Enter which resultId do you want to delete: ");
     	 int resId = sr.nextInt();  
     	 Result result = session.find(Result.class, resId); 
     	    if (result != null) {
     	        session.remove(result);
     	        System.out.println("Result with ID " + resId + " has been deleted.");
     	    } else {
     	        System.out.println("No result found with ID: " + resId);
     	    }
    }
    
  public static void updateResult(Scanner sr, Session session) {
    System.out.println("Enter Result Id which you want to update: ");
   	int res_Id = sr.nextInt();
       Result resultTable = session.find(Result.class,res_Id);
       if(resultTable != null) 
       {
       	System.out.println("Which field do you want to update: ");
       	System.out.println(" 1. Marks Obtained \n 2. Grade  \n 3. Pass/Fail \n Select an Option: ");
       	int choice3 = sr.nextInt();
       	switch(choice3) {
       	case 1:
       		
       		System.out.println("Enter New Marks Obtained : ");
       		int marks_Opt = sr.nextInt();
       		resultTable.setMarksObtained(marks_Opt);
       		break;
       	case 2:
   			System.out.println("Enter New Grade : ");
   			char grade = sr.next().charAt(0);
   			resultTable.setGrade(grade);
   			break;
       	case 3:
   			System.out.println("Enter New Pass/Fail : ");
   			String p_F = sr.next();
   			resultTable.setPassFail(p_F);
   			break;
       	}	
       }
       else {
       	System.out.println("Searching with id number "+res_Id+" is not found");
       	
       }
	}
  
 public static void selectResult(Session session) {
	 Query query7 = session.createQuery("Select r From Result r", Result.class);
      List<Result> resultList = query7.getResultList();
      System.out.println("\nresultId\texamId\tmarksObtained\tuserId\tGrade\tPassFail");
      System.out.println("----------------------------------------------------------------------");

      for (Result result : resultList) {
      	System.out.println(result.getId()+"\t\t"+result.getExamId()+"\t"+result.getMarksObtained()+"\t\t"+result.getUserId()+"\t"+result.getGrade()+"\t"+result.getPassFail());
      	//System.out.println(user);
     }
      System.out.println("-----------------------------------------------------------------------\n");

  	}
}
