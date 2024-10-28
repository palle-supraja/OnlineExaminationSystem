/*
package com.ravi.Hiberanate_OES.Entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

	@Entity
	public class Result {


				
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int resultId;
		private int marksObtained;
		private char Grade;
		private int userRank;
		private String passFail;
		
		@ManyToOne
		@JoinColumn(name ="id")
		private User user;
		
		//Apply setter and getters
		
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public int getResultId() {
			return resultId;
		}
		public void setResultId(int resultId) {
			this.resultId = resultId;
		}
		public int getMarksObtained() {
			return marksObtained;
		}
		public void setMarksObtained(int marksObtained) {
			this.marksObtained = marksObtained;
		}
		public char getGrade() {
			return Grade;
		}
		public void setGrade(char grade) {
			Grade = grade;
		}
		public int getUserRank() {
			return userRank;
		}
		public void setUserRank(int userRank) {
			this.userRank = userRank;
		}
		public String getPassFail() {
			return passFail;
		}
		public void setPassFail(String passFail) {
			this.passFail = passFail;
		}
		@Override
		public String toString() {
			return "Result [resultId=" + resultId + ", marksObtained=" + marksObtained + ", Grade=" + Grade
					+ ", userRank=" + userRank + ", passFail=" + passFail + ", user=" + user + "]";
		}		
}
*/


package com.supraja.Hiberanate_OES.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userId;
    private int examId;
    private int marksObtained;
    private char Grade;
    private String PassFail;
    
    public String getPassFail() {
		return PassFail;
	}

	public void setPassFail(String passFail) {
		PassFail = passFail;
	}

	public char getGrade() {
		return Grade;
	}

	public void setGrade(char grade) {
		Grade = grade;
	}

	// Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(int marksObtained) {
        this.marksObtained = marksObtained;
    }
}
