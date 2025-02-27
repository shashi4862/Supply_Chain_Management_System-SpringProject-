package com.jsp.supplyChainManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.supplyChainManagementSystem.dto.ResponceStructure;
import com.jsp.supplyChainManagementSystem.entity.Customer;
import com.jsp.supplyChainManagementSystem.service.CustomerSevice;

@RestController
public class CustomerController {
	@Autowired
	private CustomerSevice customerSevice;
	
	@PostMapping("/customer")
	public ResponseEntity<ResponceStructure<Customer>> saveCustomer(@RequestBody Customer customer){
		return customerSevice.saveCustomer(customer);
	}
	
	@GetMapping("/customer")
	public ResponseEntity<ResponceStructure<List<Customer>>> getAllCustomer(){
		return customerSevice.getAllCustomer();
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<ResponceStructure<Customer>> getCustomerById(@PathVariable int id){
		return customerSevice.getCustomerById(id);
	}
	
	@PutMapping("/customer")
	public ResponseEntity<ResponceStructure<Customer>> updateCustomer(@RequestBody Customer customer){
		return customerSevice.updateCustomer(customer);
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<ResponceStructure<Customer>> deleteCustomerById(@PathVariable int id){
		return customerSevice.deleteCustomerById(id);
	}
}
