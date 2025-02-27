package com.jsp.supplyChainManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.supplyChainManagementSystem.entity.Supplier;
import com.jsp.supplyChainManagementSystem.repository.SupplierRepository;

@Repository
public class SupplierDao {
	@Autowired
	private SupplierRepository supplierRepository;
	
	public Supplier saveSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}
	
	public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }
	
	public Optional<Supplier> getSupplierById(int id) {
		return supplierRepository.findById(id);
	}
	
	public Supplier updateSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}
	
	public void deleteSupplierById(int id) {
		supplierRepository.deleteById(id);
	}
}
