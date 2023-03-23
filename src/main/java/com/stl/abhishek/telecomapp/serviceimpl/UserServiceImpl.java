package com.stl.abhishek.telecomapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stl.abhishek.telecomapp.model.User;
import com.stl.abhishek.telecomapp.repository.UserRepository;
import com.stl.abhishek.telecomapp.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;



	@Override
	@Transactional
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getById(Integer id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}

	@Override
	public List<User> getListByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}
}
