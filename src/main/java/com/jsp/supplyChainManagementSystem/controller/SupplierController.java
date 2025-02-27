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
import com.jsp.supplyChainManagementSystem.entity.Supplier;
import com.jsp.supplyChainManagementSystem.service.SupplierService;

@RestController
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	
	@PostMapping("/supplier")
	public ResponseEntity<ResponceStructure<Supplier>> saveSupplier(@RequestBody Supplier supplier){
		return supplierService.saveSupplier(supplier);
	}
	
	@GetMapping("/supplier")
	public ResponseEntity<ResponceStructure<List<Supplier>>> getAllSupplier(){
		return supplierService.getAllSuppliers();
	}
	
	@GetMapping("/supplier/{id}")
	public ResponseEntity<ResponceStructure<Supplier>> getSupplierById(@PathVariable int id){
		return supplierService.getSupplierById(id);
	}
	
	@PutMapping("/supplier")
	public ResponseEntity<ResponceStructure<Supplier>> updateSupplier(@RequestBody Supplier supplier){
		return supplierService.updateSupplier(supplier);
	}
	
	@DeleteMapping("/supplier/{id}")
	public ResponseEntity<ResponceStructure<Supplier>> deleteSupplierById(@PathVariable int id){
		return supplierService.deleteSupplieerById(id);
	}
}
