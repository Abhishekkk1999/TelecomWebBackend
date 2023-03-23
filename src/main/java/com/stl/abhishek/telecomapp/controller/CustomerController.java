package com.stl.abhishek.telecomapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stl.abhishek.telecomapp.model.Customer;
import com.stl.abhishek.telecomapp.service.AddressService;
import com.stl.abhishek.telecomapp.service.CustomerService;



@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private AddressService addressService;

	//emp with address- employee with multiple address
	
	@PostMapping("/saveCusAdd")
	ResponseEntity<Customer> saveCustomerAddress(@RequestBody Customer customer) {
		Customer customers = customerService.saveCustomer(customer);
		/*
		 * List<Address> add = employees.getAddress(); for (Address address : add) {
		 * addressService.saveAddress(address); }
		 */
		return ResponseEntity.ok().body(customers);

	}
	
	

}
