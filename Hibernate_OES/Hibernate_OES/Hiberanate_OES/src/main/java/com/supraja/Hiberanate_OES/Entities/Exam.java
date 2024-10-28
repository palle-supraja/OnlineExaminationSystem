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
public class Exam {

		
		
		@Id
		private int examId;
		private String eName;
		private String eDate;
		private String examMode;
		private String place;
		private int totalMarks;
		private int duration;
		
		@ManyToOne
		@JoinColumn(name = "courseId")
		private Course course;	
		
		@OneToMany(mappedBy="exam", cascade=CascadeType.ALL)
		private List<Questions> questions = new ArrayList<Questions>();
		
		// apply getters and setters
			
		public List<Questions> getQuestions() {
			return questions;
		}
		public void setQuestions(List<Questions> questions) {
			this.questions = questions;
		}
		public Course getCourse() {
			return course;
		}
		public void setCourse(Course course) {
			this.course = course;
		}
		public int getExamId() {
			return examId;
		}
		public void setExamId(int examId) {
			this.examId = examId;
		}
		public String geteName() {
			return eName;
		}
		public void seteName(String eName) {
			this.eName = eName;
		}
		public String geteDate() {
			return eDate;
		}
		public void seteDate(String string) {
			this.eDate = string;
		}
		public String getExamMode() {
			return examMode;
		}
		public void setExamMode(String examMode) {
			this.examMode = examMode;
		}
		public String getPlace() {
			return place;
		}
		public void setPlace(String place) {
			this.place = place;
		}
		public int getTotalMarks() {
			return totalMarks;
		}
		public void setTotalMarks(int totalMarks) {
			this.totalMarks = totalMarks;
		}
		public int getDuration() {
			return duration;
		}
		public void setDuration(int duration) {
			this.duration = duration;
		}
		@Override
		public String toString() {
		    return "Exam [examId=" + examId + ", examName=" + eName + ", examMode=" + examMode 
		            + ", examDate=" + eDate + ", place=" + place + ", totalMarks=" + totalMarks + "]";
	}
}
