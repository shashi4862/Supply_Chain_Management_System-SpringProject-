package com.jsp.supplyChainManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.supplyChainManagementSystem.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
	
}
