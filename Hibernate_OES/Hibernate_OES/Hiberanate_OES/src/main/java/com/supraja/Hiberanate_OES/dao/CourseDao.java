package com.supraja.Hiberanate_OES.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.supraja.Hiberanate_OES.Entities.Course;
import com.supraja.Hiberanate_OES.Entities.User;

import jakarta.persistence.Query;


public class CourseDao {

	
    public static Course createCourse(Scanner sr, Session session) {
               
        System.out.println("Enter Course Id: ");
        int c_Id = sr.nextInt();
        System.out.println("Enter Course Name: ");
        String c_Name = sr.next();
        System.out.println("Enter Branch of the Course: ");
        String c_Course = sr.next();
        System.out.println("Enter Course Fee: ");
        int c_Fee = sr.nextInt();
        System.out.println("Enter Course Duration: ");
        int c_Duration = sr.nextInt();

        // creating object for course 
        Course course = new Course();
        course.setCourseId(c_Id);
        course.setCourseName(c_Name);
        course.setAboutCourse(c_Course);
        course.setCourseFee(c_Fee);
        course.setCourseDuration(c_Duration);
        
        System.out.println("Enter User Id for the Course: ");
        int userId = sr.nextInt();
        User user = session.get(User.class, userId);  

        if (user != null) {
            course.setUser(user);  
            user.getCourse().add(course);  
        } else {
            System.out.println("User Id with "+userId+" is not found!");
        }
        
        return course;
    }
    
    public static void deleteCourse(Scanner sr, Session session) {
    	System.out.println("Enter which courseId do you want to delete: ");
     	 int courseId = sr.nextInt();  
     	 Course course = session.find(Course.class, courseId);  
     	
     	    if (course != null) {
     	        session.remove(course);
     	        System.out.println("Course with ID " + courseId + " has been deleted.");
     	    } else {
     	        System.out.println("No user found with ID: " + courseId);
     	    }
    }
   
 public static void updateCourse(Scanner sr, Session session) {
    System.out.println("Enter Course id which you want to update: ");
   	int Course_Id = sr.nextInt();
       Course courseTable = session.find(Course.class,Course_Id);
       if(courseTable != null) 
       {
       	System.out.println("Which field do you want to update: ");
       	System.out.println(" 1. Course Name \n 2. About Course \n 3. Course Duration \n 4. Course Fee \n Select an Option: ");
       	int choice3 = sr.nextInt();
       	switch(choice3) {
       	case 1:
       		System.out.println("Enter New Course Name: ");
       		String name = sr.next();
       		courseTable.setCourseName(name);
       		break;
       	case 2:
   			System.out.println("Enter New About Course: ");
   			String aboutCourse = sr.next();
   			courseTable.setAboutCourse(aboutCourse);
   			break;
       	case 3:
       		System.out.println("Enter New Course Duration: ");
       		int duration = sr.nextInt();
       		courseTable.setCourseDuration(duration);
       		break;
       	case 4:
       		System.out.println("Enter New Course Fee: ");
       		int fee = sr.nextInt();
       		courseTable.setCourseFee(fee);
       		break;	
       	}	
       }
       else {
       	System.out.println("Searching with id number "+Course_Id+" is not found");
       }
    }
 
 public static void selectCourse(Session session) {
 Query query3 = session.createQuery("Select c From Course c", Course.class);
     List<Course> courseList = query3.getResultList();
     System.out.println("\ncourseId\tcourseName\taboutCourse\tcourseDuration\t\tcourseFee\tuserId");
     System.out.println("------------------------------------------------------------------------------------------------");

     for (Course course : courseList) {
     	System.out.println(course.getCourseId()+"\t\t"+course.getCourseName()+"\t\t"+course.getAboutCourse()+"\t\t"+course.getCourseDuration()+"\t\t"+course.getCourseFee()+"\t\t"+course.getUser());
     	//System.out.println(user);
    }
     System.out.println("-------------------------------------------------------------------------------------------------\n");
	
 }
}
