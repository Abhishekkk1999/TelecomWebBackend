package com.stl.abhishek.telecomapp.jwt;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.stl.abhishek.telecomapp.model.User;
import com.stl.abhishek.telecomapp.repository.UserRepository;

@Component
@Service
public class SignupDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User model=repo.findByMobileNo(username);
		return new SignupDetails(model);
	}


	

}
