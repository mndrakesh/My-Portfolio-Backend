package com.portofolio.App.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portofolio.App.model.User;


public interface UserRepository extends JpaRepository<User, Integer>{

	
		public User findByEmail(String email);
		public User findByEmailAndPassword(String email, String password);
		
	}


