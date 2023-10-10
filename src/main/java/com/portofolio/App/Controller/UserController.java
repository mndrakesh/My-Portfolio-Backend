package com.portofolio.App.Controller;


import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portofolio.App.model.User;
import com.portofolio.App.Repository.UserRepository;

@RestController
public class UserController {
	
	
		//private AdminRegistrationService service;
		
		@Autowired
		private UserRepository UserRepository;
		
		@PostMapping("/register")
		@CrossOrigin(origins ="*")
		public User registerUser(@RequestBody User adm) throws Exception{
			String tempEmail = adm.getEmail();
			if(tempEmail != null && !"".equals(tempEmail))
			{
				User empobj = UserRepository.findByEmail(tempEmail);
				if(empobj != null)
				{
					throw new Exception("Admin with "+tempEmail+" is already exists");
				}
				
			}
			User admObj=null;
			admObj = UserRepository.save(adm);
			return admObj;
		}
		@PostMapping("/login")
		@CrossOrigin(origins ="*")
		public ResponseEntity<String> loginadm(@RequestBody User adm) throws Exception {
			String tempEmail= adm.getEmail();
			String tempPass=adm.getPassword();
			
			  // Display email and password received from the frontend in the console
	        System.out.println("Received Email: " + tempEmail);
	        System.out.println("Received Password: " + tempPass);
			
			User admObj = null;
			if(tempEmail != null && tempPass != null ) {
				admObj = UserRepository.findByEmailAndPassword(tempEmail, tempPass);
				System.out.println("Login success");
		        
				
			}
			if(admObj ==null) {
				throw new Exception("Bad  Credentials");
				
				
			}
				
			 return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("Login Success");


		}
		@PutMapping("/users/change-password")
		@CrossOrigin(origins = "*")
		public User changeAdminPassword(@RequestBody User user) throws Exception {
		    String tempEmailId = user.getEmail();
		    String newPassword = user.getPassword();

		    User adminObj = UserRepository.findByEmail(tempEmailId);
		    if (adminObj != null) {
		        adminObj.setPassword(newPassword);
		        UserRepository.save(adminObj);
		    } else {
		        throw new Exception("Admin not found with the provided email.");
		    }
		    return adminObj;
		}

	}


