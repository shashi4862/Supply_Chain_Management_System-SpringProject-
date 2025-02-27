package com.jsp.supplyChainManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.supplyChainManagementSystem.entity.Customer;
import com.jsp.supplyChainManagementSystem.repository.CustomerRepository;

@Repository
public class CustomerDao {

	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Optional<Customer> getCustomerById(int id) {
		return customerRepository.findById(id);
	}
	
	public List<Customer> getAllCustomer(){
		return customerRepository.findAll();
	}
	
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public void deleteCustomerById(int id) {
		customerRepository.deleteById(id);
	}
}
