package com.portofolio.App.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;




@Entity
@Table(name="user")

public class User {
		
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int userId;
		
		 @Column
		private String name; 
	 
		@Column(unique = true)
		private String email; 
		private String password;
		
		public User()
		{
			
		}
		
		
		
		public User(int userId, String name, String email, String password) {
			super();
			this.userId = userId;
			this.name = name;
			this.email = email;
			this.password = password;
		}



		public int getUserId() {
			return userId;
		}



		public void setUserId(int userId) {
			this.userId = userId;
		}



		public String getName() {
			return name;
		}



		public void setName(String name) {
			this.name = name;
		}



		public String getEmail() {
			return email;
		}



		public void setEmailId(String emailId) {
			this.email = emailId;
		}



		public String getPassword() {
			return password;
		}



		public void setPassword(String password) {
			this.password = password;
		}




}
