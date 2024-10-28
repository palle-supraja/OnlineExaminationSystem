package com.supraja.Hiberanate_OES.Entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


	@Entity
	public class Course {

				
		@Id
		private int courseId;
		private String courseName;
		private String aboutCourse;
		private int courseDuration;
		private int courseFee;
		
		@ManyToOne
		@JoinColumn(name="id")
		private User user;
		
		@OneToMany(mappedBy="course", cascade = CascadeType.ALL)
		private List<Exam> exam = new ArrayList<Exam>();
	
		
		 //Apply setters and getters
		
		public List<Exam> getExam() {
			return exam;
		}

		public void setExam(List<Exam> exam) {
			this.exam = exam;
		}

		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public int getCourseId() {
			return courseId;
		}
		public void setCourseId(int courseId) {
			this.courseId = courseId;
		}
		public String getCourseName() {
			return courseName;
		}
		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}
		public String getAboutCourse() {
			return aboutCourse;
		}
		public void setAboutCourse(String aboutCourse) {
			this.aboutCourse = aboutCourse;
		}
		public int getCourseDuration() {
			return courseDuration;
		}
		public void setCourseDuration(int courseDuration) {
			this.courseDuration = courseDuration;
		}
		public int getCourseFee() {
			return courseFee;
		}
		public void setCourseFee(int i) {
			this.courseFee = i;
		}
		
		
		@Override
		public String toString() {
		    return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseDuration=" + courseDuration
		            + ", courseFee=" + courseFee + ", aboutCourse=" + aboutCourse + "]";
	}

}
