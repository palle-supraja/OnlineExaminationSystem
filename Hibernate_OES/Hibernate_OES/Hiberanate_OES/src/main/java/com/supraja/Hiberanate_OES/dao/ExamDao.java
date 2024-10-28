package com.supraja.Hiberanate_OES.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.supraja.Hiberanate_OES.Entities.Course;
import com.supraja.Hiberanate_OES.Entities.Exam;

import jakarta.persistence.Query;


public class ExamDao {
	
	 
    public static Exam createExam(Scanner sr, Session session) {
      
        System.out.println("Enter Exam Id: ");
        int e_Id = sr.nextInt();
        System.out.println("Enter Exam(Subject) Name: ");
        String e_Name = sr.next();
        System.out.println("Enter Mode of Exam: ");
        String e_Mode = sr.next();
        System.out.println("Enter Exam Place(Center): ");
        String e_Place = sr.next();
        System.out.println("Enter Exam Duration (in minutes): ");
        int e_Duration = sr.nextInt();
        System.out.println("Enter Exam Date (DD-MM-YYYY): ");
        String e_Date = sr.next();
        System.out.println("Enter Total Marks: ");
        int e_Marks = sr.nextInt();

        // creating object for exam class
        Exam exam = new Exam();
        exam.setExamId(e_Id);
        exam.seteName(e_Name);
        exam.setExamMode(e_Mode);
        exam.setPlace(e_Place);
        exam.setDuration(e_Duration);
        exam.seteDate(e_Date);
        exam.setTotalMarks(e_Marks);
        
        System.out.println("Enter Course Id for the Exam: ");
        int courseId = sr.nextInt();
        Course course = session.get(Course.class, courseId);  

        if (course != null) {
            exam.setCourse(course);  
            course.getExam().add(exam);  
        } else {
            System.out.println("Course Id with "+courseId+" is not found!");
        }

        return exam;
    }
    public static void deleteExam(Scanner sr, Session session) {
	    	System.out.println("Enter which examId do you want to delete: ");
		       int examId = sr.nextInt();  
		       Exam exam = session.find(Exam.class, examId);  
		        	 if (exam != null) {
		        	     session.remove(exam);
		        	     System.out.println("Exam with ID " + examId + " has been deleted.");
		        	 } else {
		        	     System.out.println("No exam found with ID: " + examId);
		       }
    }
    public static void updateExam(Scanner sr, Session session) {
    	System.out.println("Enter Exam id which you want to update: ");
    	int exam_Id = sr.nextInt();
    	Exam examTable = session.find(Exam.class,exam_Id);
    	if(examTable != null) 
    	{
    		System.out.println("Which field do you want to update: ");
       		System.out.println(" 1. Exam Name \n 2. Exam Date \n 3. Exam Mode \n 4. Exam Place \n 5. Total Marks \n 6. Exam Duration \n Select an Option: ");
       		int choice3 = sr.nextInt();
       		switch(choice3) {
       		case 1:
       			System.out.println("Enter New Exam Name: ");
       			String name = sr.next();
       			examTable.seteName(name);
       			break;
       		case 2:
   				System.out.println("Enter New Exam Date: ");
   				String eDate = sr.next();
   				examTable.seteDate(eDate);
   				break;
       		case 3:
       			System.out.println("Enter New Exam Mode: ");
       			String eMode = sr.next();
       			examTable.setExamMode(eMode);
       			break;
       		case 4:
       			System.out.println("Enter New Exam Place: ");
       			String place = sr.next();
       			examTable.setPlace(place);
       			break;	
       		case 5:
       			System.out.println("Enter New Total Marks: ");
       			int eMarks = sr.nextInt();
       			examTable.setTotalMarks(eMarks);
       			break;
       		case 6:
       			System.out.println("Enter New Exam Duration: ");
       			int duration = sr.nextInt();
       			examTable.setDuration(duration);
       			break;	
       		}	
       }
    	else {
    		System.out.println("Searching with id number "+exam_Id+" is not found");	
       }
    }
 public static void selectExam(Scanner sr, Session session) {
    Query query4 = session.createQuery("Select e From Exam e", Exam.class);
        List<Exam> examList = query4.getResultList();
        System.out.println("\nexamId\teDate\t\teName\t\t\tDuration\tTotalMarks\texamMode\tPlace\t\tcourseId");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");

        for (Exam exam : examList) {
        	System.out.println(exam.getExamId()+"\t"+exam.geteDate()+"\t"+exam.geteName()+"\t"+exam.getDuration()+"\t\t"+exam.getTotalMarks()+"\t\t"+exam.getExamMode()+"\t\t"+exam.getPlace()+"\t"+exam.getCourse());
        	//System.out.println(user);
       }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------\n");

       }
}
