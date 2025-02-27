package com.jsp.supplyChainManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.supplyChainManagementSystem.dao.SupplierDao;
import com.jsp.supplyChainManagementSystem.dto.ResponceStructure;
import com.jsp.supplyChainManagementSystem.entity.Supplier;
import com.jsp.supplyChainManagementSystem.exception.IdNotFoundException;

@Service
public class SupplierService {
	@Autowired
	private SupplierDao supplierDao;
	
	public ResponseEntity<ResponceStructure<Supplier>> saveSupplier(Supplier supplier){
		Supplier recievedSupplier = supplierDao.saveSupplier(supplier);
		
		ResponceStructure<Supplier> structure = new ResponceStructure<Supplier>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Success");
		structure.setData(recievedSupplier);
		
		return new ResponseEntity<ResponceStructure<Supplier>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponceStructure<List<Supplier>>> getAllSuppliers(){
		List<Supplier> list = supplierDao.getAllSuppliers();
		
		ResponceStructure<List<Supplier>> structure = new ResponceStructure<List<Supplier>>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Found");
		structure.setData(list);
		
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponceStructure<Supplier>> getSupplierById(int id){
		Optional<Supplier> supplier = supplierDao.getSupplierById(id);
		
		ResponceStructure<Supplier> structure = new ResponceStructure<Supplier>();
		if(supplier.isPresent()) {			
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Found");
			structure.setData(supplier.get());
			
			return new ResponseEntity<ResponceStructure<Supplier>>(structure, HttpStatus.OK);
		}
		else {			
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponceStructure<Supplier>> updateSupplier(Supplier supplier){
		Supplier recievedSupplier = supplierDao.updateSupplier(supplier);
		
		ResponceStructure<Supplier> structure = new ResponceStructure<Supplier>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Success");
		structure.setData(recievedSupplier);
		
		return new ResponseEntity<ResponceStructure<Supplier>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponceStructure<Supplier>> deleteSupplieerById(int id){
		Optional<Supplier> supplier = supplierDao.getSupplierById(id);
		
		ResponceStructure<Supplier> structure = new ResponceStructure<Supplier>();
		if(supplier.isPresent()) {			
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Found");
			
			supplierDao.deleteSupplierById(id);
			
			return new ResponseEntity<ResponceStructure<Supplier>>(structure, HttpStatus.OK);
		}
		else {			
			throw new IdNotFoundException();
		}
		
	}
}
