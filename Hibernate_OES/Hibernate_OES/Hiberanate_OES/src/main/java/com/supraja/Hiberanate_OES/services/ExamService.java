package com.supraja.Hiberanate_OES.services;

import java.util.Scanner;

import org.hibernate.Session;

import com.supraja.Hiberanate_OES.Entities.Result;
import com.supraja.Hiberanate_OES.Entities.User;

import jakarta.transaction.Transaction;

public class ExamService {
    static Scanner sr = new Scanner(System.in);
    static String green = "\u001B[32m";
    static String red ="\u001B[31m";
    static String yellow="\u001B[33m";
    static String reset="\u001B[0m";
    static String purple="\u001B[35m";
    
    private String questions[];
    private int answer[];
    private int userAnswer[];

    public ExamService() {
        questions = new String[5];
        answer = new int[5];
        userAnswer = new int[5];
    }

    public void addQuestion(String question, int qnum, int ans) {
        questions[qnum] = question;
        answer[qnum] = ans;
    }

    public int conductExam() {
        int score = 0;
        System.out.println("Your Exam has been Started");
        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion " + (i + 1) + ": " + questions[i]);
            System.out.print("Your answer: ");
            userAnswer[i] = sr.nextInt();
            if (userAnswer[i] == (answer[i])) {
            	score++; 
            }
        }
	System.out.println(green);
        System.out.println("\nExam finished!!");
	System.out.println(reset);
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Q " + (i + 1) + " \n Actual answer: #" + answer[i] + " \n Your Answer: #" + userAnswer[i]);
        }
        if(score == questions.length) {
		System.out.println(green);
        	System.out.println("\n   *****  congratulations  *****		");
		System.out.println(reset);
        }
	System.out.println(yellow);
        System.out.println("\nYour score: " + score + " out of " + questions.length);
	System.out.println(reset);
        return score;
    }

    public static void start(Session session) {
    	
    	  System.out.println("Enter user ID: ");
          int userId = sr.nextInt();
          User user = session.find(User.class, userId);

          if (user != null) {
       	
       	   System.out.println("Select Your Subject ... \n 1. Java \n 2. HTML \nSelect choice : ");	
   	
       	   int choice = sr.nextInt();
       	   switch(choice) {
       	   
       	   	case 1:
		System.out.println(purple);
       	   	System.out.println("Do you want to start the exam (yes/no)?");
		System.out.println(reset);
            String st = sr.next();
            if (st.equalsIgnoreCase("yes")) {
                ExamService exam = new ExamService();
		System.out.println(red);
                exam.addQuestion("Which of the following is not a java features?\n1. Dynamic\n2. Architecture Neutral\n3. Use of pointers\n4. Object-oriented\n", 0, 3);
                exam.addQuestion("Which keyword is used for accessing the features of a package?\n1. import\n2. package\n3. extends\n4. export\n", 1, 1);
                exam.addQuestion("Which of the following is a mutable class in java?\n1. java.lang.String\n2. java.lang.StringBuilder\n3. java.lang.Byte\n4. java.lang.Short\n", 2, 2);
                exam.addQuestion("How Many threads can be executed at a time?\n1. Only one thread\n2. Only main thread\n3. Multiple threads\n4. two threads\n", 3, 3);
                exam.addQuestion("Which of these cannot be used for a variable name in java? \n1. none \n2. identifier & keyword\n3. identifier\n4. keyword\n", 4, 4);
		System.out.println(reset);
                int score = exam.conductExam();

                // Save the result
                saveResult(userId, score, session);
                end();
            }
            else {
                end();
            }
       	   		break;
       	   	case 2:
       	  	System.out.println("Do you want to start the exam (yes/no)?");
            String str = sr.next();
            if (str.equalsIgnoreCase("yes")) {
                ExamService exam = new ExamService();
		System.out.println(red);
                exam.addQuestion("HTML stands for?\n1. HighText Machine Language\n2. HyperText and links Markup Language\n3. HyperText Markup Language\n4. None of these\n", 0, 3);
                exam.addQuestion("The correct sequence of HTML tags for starting  a webpage is___?\n1. HTML, Title, Head, body \n2. HTML, Head, Title, Body \n3. HTML, Body, Head, Title \n4. Head, HTML, Title, Body \n", 1, 2);
                exam.addQuestion("Which tag is used to insert largest heading in HTML?\n1. <h6> \n2. <h1> \n3. <h5> \n4. <h2> \n", 2, 2);
                exam.addQuestion("Which of the tag is responsible for making the text bold in HTML?\n1. <pre>\n2. <bb>\n3. <b> \n4. <i> \n", 3, 3);
                exam.addQuestion("Which of these are containers for <tr>, <th> and <td> ?\n1. <option> \n2. <data>\n3. <group>\n4. <table>\n", 4, 4);
		System.out.println(reset);
                int score = exam.conductExam();

                // Save the result
                saveResult(userId, score, session);
                end();
            }
            else {
                end();
            }
       	   		break;
       	   	default:
			System.out.println(red);
       	   		System.out.println("Invalid choice!");
			System.out.println(reset);
       	   		break;
       	   }
         }
       	else {
	    System.out.println(red);
            System.out.println("Sorry! No user found with ID: " + userId);
            System.out.println("Please enter registered user Id only...");
	    System.out.println(reset);		
        }
    } 
    	
    private static void saveResult(int userId, int score, Session session) {
        Transaction transaction = null;
        try {
            Result result = new Result();
            result.setUserId(userId);
            result.setExamId(1); 
            result.setMarksObtained(score);
           
            if (score == 5) {
                result.setGrade('A');
                result.setPassFail("Pass");
            }
            else if (score == 4 ) {
                result.setGrade('B');
                result.setPassFail("Pass");
            }
            else if (score == 3) {
                result.setGrade('c');
                result.setPassFail("Pass");
            }
            else {
                result.setGrade('F');
                result.setPassFail("Fail");
            }

            session.save(result);
            //transaction.commit();
		System.out.println(green);
            System.out.println("\nResult saved successfully.");
		System.out.println(reset);
            System.out.println("You can check your result by using your result Id : "+result.getId());
        } catch (Exception e) {
           // transaction.rollback();
            e.printStackTrace();
        }
    }

    static void end() {
    	System.out.println(green);
        System.out.println("\n		Thank you....");
	System.out.println(reset);
       
    }
}
