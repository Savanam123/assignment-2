package com.jocata.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jocata.entity.CustomerIdentity;
import com.jocata.repository.CustomerRepository;

@RestController

public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;

	@PostMapping("/saveCustomer")
	public ResponseEntity<String> saveCustomer(@RequestBody List<CustomerIdentity> cusData) {
		customerRepository.saveAll(cusData);
		return ResponseEntity.ok("Data SuccessFully Saved");
	}
	
	@GetMapping("/getByName/{name}")
	public ResponseEntity<List<CustomerIdentity>> geByName(@RequestParam String name) {
		return new ResponseEntity<List<CustomerIdentity>>(customerRepository.findByIdnum(name), HttpStatus.OK);
	}
	
	@GetMapping("/getAllCustomer")
	public List<CustomerIdentity> getAll() {
		return customerRepository.findAll();
	}
	
	@DeleteMapping("/deleteCustomer")
	public ResponseEntity<?> deleteEmployee(@RequestBody CustomerIdentity customerIdentity) {

		CustomerIdentity customerIdentity2 = new CustomerIdentity();

		customerIdentity2.setId(customerIdentity.getId());

		customerRepository.deleteById(customerIdentity.getId());
		return ResponseEntity.ok("Data Delete Successfully!!!  id="+customerIdentity.getId());	
		
	}
	
	@GetMapping("/getByName")
	public ResponseEntity<?> getByName(@RequestBody CustomerIdentity customerIdentity) {

		CustomerIdentity customerIdentity2 = new CustomerIdentity();

		customerIdentity2.setIdnum(customerIdentity.getIdnum());

		customerRepository.findByIdnum(customerIdentity.getIdnum());
		
		return new ResponseEntity<CustomerIdentity>(customerIdentity2, HttpStatus.OK);
		
		
	}
	
	@GetMapping("/getById/{id}")
	public Optional<CustomerIdentity> getById(@PathVariable int id) {
		Optional<CustomerIdentity> customerIdentity = customerRepository.findById(id);
		if (customerIdentity == null) {
			throw new RuntimeException("Employee with id " + id + " is not found");
		}
		return customerIdentity;
	}
}
