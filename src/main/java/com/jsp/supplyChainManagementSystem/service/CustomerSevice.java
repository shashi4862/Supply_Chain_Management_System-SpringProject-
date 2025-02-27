package com.jsp.supplyChainManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.supplyChainManagementSystem.dao.CustomerDao;
import com.jsp.supplyChainManagementSystem.dto.ResponceStructure;
import com.jsp.supplyChainManagementSystem.entity.Customer;
import com.jsp.supplyChainManagementSystem.exception.IdNotFoundException;

@Service
public class CustomerSevice {
	@Autowired
	private CustomerDao customerDao;
	
	public ResponseEntity<ResponceStructure<Customer>> saveCustomer(Customer customer){
		Customer recievedCustomer = customerDao.saveCustomer(customer);
		
		ResponceStructure<Customer> structure = new ResponceStructure<Customer>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Data Saved");
		structure.setData(recievedCustomer);
		
		return new ResponseEntity<ResponceStructure<Customer>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponceStructure<Customer>> getCustomerById(int id){
		Optional<Customer> customer = customerDao.getCustomerById(id);
		
		ResponceStructure<Customer> structure = new ResponceStructure<Customer>();
		if(customer.isPresent()) {
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("FOUND");
			structure.setData(customer.get());
			
			return new ResponseEntity<ResponceStructure<Customer>>(structure, HttpStatus.FOUND);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponceStructure<List<Customer>>> getAllCustomer(){
		List<Customer> customers = customerDao.getAllCustomer();
		
		ResponceStructure<List<Customer>> structure  = new ResponceStructure<List<Customer>>();
		structure.setStatusCode(HttpStatus.FOUND.value());
		structure.setMessage("Found");
		structure.setData(customers);
		
		return new ResponseEntity<ResponceStructure<List<Customer>>>(structure, HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponceStructure<Customer>> updateCustomer(Customer customer){
		Customer recievedCustomer = customerDao.updateCustomer(customer);
		
		ResponceStructure<Customer> structure = new ResponceStructure<Customer>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Data Saved");
		structure.setData(recievedCustomer);
		
		return new ResponseEntity<ResponceStructure<Customer>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponceStructure<Customer>> deleteCustomerById(int id){
		Optional<Customer> customer = customerDao.getCustomerById(id);
		ResponceStructure<Customer> structure = new ResponceStructure<Customer>();
		
		if(customer.isPresent()) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Deleted");
			
			return new ResponseEntity<ResponceStructure<Customer>>(structure, HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException();
		}
	}
}
