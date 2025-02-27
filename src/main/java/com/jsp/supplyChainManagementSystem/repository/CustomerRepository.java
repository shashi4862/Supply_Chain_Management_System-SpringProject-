package com.jsp.supplyChainManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.supplyChainManagementSystem.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
