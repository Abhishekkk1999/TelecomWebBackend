package com.stl.abhishek.telecomapp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stl.abhishek.telecomapp.model.User;
import com.stl.abhishek.telecomapp.service.UserLoginService;

@RestController
@RequestMapping("/u")
@CrossOrigin("http://localhost:4200")

public class SignupController {
	
	@Autowired
	private UserLoginService userLoginService;
	
	@PostMapping("/signup")
	public String createUser(@RequestBody User userLogin) {
		String Add=userLoginService.register(userLogin);
		return  Add;
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody User userLogin) throws Exception {
		String Add=userLoginService.login(userLogin);
		return  ResponseEntity.ok(Add);

	}
	
}
