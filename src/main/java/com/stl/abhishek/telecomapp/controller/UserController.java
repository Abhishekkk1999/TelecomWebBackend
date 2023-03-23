package com.stl.abhishek.telecomapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stl.abhishek.telecomapp.jwt.Signupjwt;
import com.stl.abhishek.telecomapp.model.User;
import com.stl.abhishek.telecomapp.repository.UserRepository;
import com.stl.abhishek.telecomapp.service.UserService;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Signupjwt jwtUtil;
	
	@PostMapping("/save")
	public ResponseEntity<User> createUser(@RequestBody User user) throws Exception {
		User users = userService.saveUser(user);
		return ResponseEntity.ok().body(users);
	}
	


	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
		User user = userRepository.findByMobileNo(jwtUtil.getUsername(id));
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
