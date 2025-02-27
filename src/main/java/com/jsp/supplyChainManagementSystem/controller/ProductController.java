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
import com.jsp.supplyChainManagementSystem.entity.Product;
import com.jsp.supplyChainManagementSystem.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/product/{supplierid}/{orderId}")
	public ResponseEntity<ResponceStructure<Product>> saveProduct(@PathVariable int supplierid,@PathVariable int orderId, @RequestBody Product product)
	{
		return productService.saveProduct(supplierid,orderId,product);
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<ResponceStructure<Product>> getProductById(@PathVariable int id){
		return productService.getProductById(id);
	}
	
	@GetMapping("/product")
	public ResponseEntity<ResponceStructure<List<Product>>> getAllProduct(){
		return productService.getAllProduct();
	}
	
	@GetMapping("/product/supplier/{id}")
	public ResponseEntity<ResponceStructure<List<Product>>> getProductBySupplierId(@PathVariable int id)
	{
		return productService.findProductBySupplierId(id);
	}
	
	@PutMapping("/product")
	public ResponseEntity<ResponceStructure<Product>> updateProduct(@RequestBody Product product){
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<ResponceStructure<Product>> deleteProductById(@PathVariable int id){
		return productService.deleteProductById(id);
	}
}
