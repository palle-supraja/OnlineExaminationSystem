package com.supraja.Hiberanate_OES.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
	
	@Entity
	@Table(name = "Admin")
	public class Admin {

				
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	    private int id;

	    @Column(nullable = false, unique = true)
	    private String userName;
	    
	    @Column(nullable = false)
	    private String password;
	    
		@OneToOne
		private User user;

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
		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		@Override
		public String toString() {
			return "Admin [id=" + id + ", userName=" + userName + ", password=" + password + ", user=" + user + "]";
		}
		
	}
