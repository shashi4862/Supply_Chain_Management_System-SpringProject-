package com.jsp.supplyChainManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.supplyChainManagementSystem.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findSupplierById(int supplierID);
}
