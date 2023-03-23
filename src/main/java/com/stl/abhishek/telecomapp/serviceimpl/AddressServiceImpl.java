package com.stl.abhishek.telecomapp.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stl.abhishek.telecomapp.model.Address;
import com.stl.abhishek.telecomapp.repository.AddressRepository;
import com.stl.abhishek.telecomapp.service.AddressService;



@Service
public class AddressServiceImpl implements AddressService {

	private static final Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

	@Autowired
	private AddressRepository repo;

	@Override
	public Address saveAddress(Address address) {
		logger.info("Employee Service Implementation : savePolicy() method");
		return repo.save(address);
	}
}
