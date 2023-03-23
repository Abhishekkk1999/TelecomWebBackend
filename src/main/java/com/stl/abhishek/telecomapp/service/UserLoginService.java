package com.stl.abhishek.telecomapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.stl.abhishek.telecomapp.jwt.SignupDetails;
import com.stl.abhishek.telecomapp.jwt.Signupjwt;
import com.stl.abhishek.telecomapp.model.User;
import com.stl.abhishek.telecomapp.repository.UserRepository;

@Component
@Service
public class UserLoginService {
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	AuthenticationManager authmanager;
	
	@Autowired
	Signupjwt utils;
	
	
	
	public String register(User user) {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		user.setUserpwd(encoder.encode(user.getUserpwd()));
		repo.save(user);
		return "added";
	}
	
	public String login(User user) {
		try {
			Authentication auth=authmanager.authenticate(new UsernamePasswordAuthenticationToken(user.getPhone_no(), user.getUserpwd()));
			
			if(auth.isAuthenticated()) {
				SignupDetails details=new SignupDetails(user);
				
				return utils.generatetoken(details);
			}
			return "User not authenticated";
		}
		catch(BadCredentialsException e) {
			
			return "phone no or password does not match.";
		}
		catch(Exception er) {
			return "there is an error";
		}
	}
	

}
