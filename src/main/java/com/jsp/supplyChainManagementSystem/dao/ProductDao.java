package com.jsp.supplyChainManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.supplyChainManagementSystem.entity.Product;
import com.jsp.supplyChainManagementSystem.repository.ProductRepository;

@Repository
public class ProductDao {
	@Autowired
	private ProductRepository productRepository;
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Optional<Product> getProductById(int id){
		return productRepository.findById(id);
	}
	
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}
	
	public List<Product> getProductBySupplierId(int id){
		return productRepository.findSupplierById(id);
	}
	
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
	
	public void deleteProductById(int id) {
		productRepository.deleteById(id);
	}
}
