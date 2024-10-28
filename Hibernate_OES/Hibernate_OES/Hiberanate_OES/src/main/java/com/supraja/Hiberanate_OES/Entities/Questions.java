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
	public class Questions {

					
		@Id
		private int qId;
		public Exam getExam() {
			return exam;
		}
		public void setExam(Exam exam) {
			this.exam = exam;
		}
		private String queType;
		private int marks;
		
		@ManyToOne
		@JoinColumn(name="examiId")
		private Exam exam;
		
		@OneToMany(mappedBy="questions", cascade=CascadeType.ALL)
		private List<Options> options = new ArrayList<Options>();
		
		public List<Options> getQuestions() {
			return options;
		}
		public void setQuestions(List<Options> questions) {
			this.options = questions;
		}
		// apply setters and getters
		public int getqId() {
			return qId;
		}
		public void setqId(int qId) {
			this.qId = qId;
		}
		
		public String getQueType() {
			return queType;
		}
		public void setQueType(String queType) {
			this.queType = queType;
		}
		public int getMarks() {
			return marks;
		}
		public void setMarks(int marks) {
			this.marks = marks;
		}
		public List<Options> getOptions() {
			return options;
		}
		public void setOptions(List<Options> options) {
			this.options = options;
		}
		@Override
		public String toString() {
			return "Questions [qId=" + qId + ", queType=" + queType + ", marks=" + marks + ", exam=" + exam
					+ ", options=" + options + "]";
		}
		
}
