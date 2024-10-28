package com.supraja.Hiberanate_OES.Entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


	@Entity
	@Table(name = "User")
	public class User {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	    private int id;

	    @Column(nullable = false)
	    private String userName;

	    @Column(nullable = false, unique = true)
	    private String password;

	    private String Email;

	    @OneToMany(mappedBy ="user", cascade = CascadeType.ALL)
		private List<Course> course = new ArrayList<Course>();
		
		// Apply setters and getters
		
		public List<Course> getCourse() {
			return course;
		}
		public void setCourse(List<Course> course) {
			this.course = course;
		}
		
		// Getters and Setters
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		 public String getEmail() {
			return Email;
		}

		public void setEmail(String email) {
			Email = email;
		}
		
		@Override
		public String toString() {
			return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", Email=" + Email
					+ ", course=" + course + "]";
		}
		
}
