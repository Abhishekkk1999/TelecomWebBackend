package com.stl.abhishek.telecomapp.controller;


import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.stl.abhishek.telecomapp.exception.ConnectionTypeException;
import com.stl.abhishek.telecomapp.model.Connection;
import com.stl.abhishek.telecomapp.service.ConnectionService;


@RestController
@CrossOrigin
@RequestMapping("/connection")
public class ConnectionController {

	private static final Logger logger = LoggerFactory.getLogger(ConnectionController.class);

	@Autowired
	private ConnectionService coonectionService; 
	


	/**
	 * This method is used to get all the connection details.--List<connection>
	 * 
	 */
	
	@GetMapping("/getAll")
	public @ResponseBody Iterable<Connection> getAllConnection() throws Exception {
		logger.info("Connection Rest Controller Implementation : getAllConnection() method");
		return coonectionService.getAllConnection();  //here we are calling //
	}

	/*
	 * This method is used to store the connection details for particular user.
	 */
	
	@PostMapping("/save")
	public ResponseEntity<Connection> createConnection(@RequestBody Connection connection, HttpServletRequest request)
			throws Exception {
		Connection createdConnection = this.coonectionService.saveConnection(connection);
		logger.info("Connection Rest Controller Implementation : saveConnection() method");
		return ResponseEntity.ok().body(createdConnection); //createdConnection that is return to createConnection
	}

	/*
	 * This method is used to get the Connection details of user by using user id.
	 */
	@GetMapping("/get/{id}")
	public ResponseEntity<Connection> getConnectionById(@PathVariable("id") Integer id) { //getting data by using id.
		Optional<Connection> connection = coonectionService.getConnectionById(id); //method calling
		logger.info("Connection Rest Controller Implementation : getConnectionById() method");
		if(connection.isPresent()) {
		return ResponseEntity.ok().body(connection.get());
		}else {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}

	/*
	 * This method is used to delete the Connection details of user by using id.
	 */
	
	@DeleteMapping("/delete/{id}")
	public void deleteConnectionById(@PathVariable("id") Integer id) throws ConnectionTypeException {
		logger.info("Connection Rest Controller Implementation : deleteConnectionById() method");
		coonectionService.deleteConnection(id);
	}
	
}
