package com.stl.abhishek.telecomapp.repository;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stl.abhishek.telecomapp.model.Address;


@Repository
public interface AddressRepository extends CrudRepository<Address, Serializable>{
	
}
