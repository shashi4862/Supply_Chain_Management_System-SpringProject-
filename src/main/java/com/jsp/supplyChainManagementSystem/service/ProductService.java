package com.jsp.supplyChainManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.supplyChainManagementSystem.dao.OrderDao;
import com.jsp.supplyChainManagementSystem.dao.ProductDao;
import com.jsp.supplyChainManagementSystem.dao.SupplierDao;
import com.jsp.supplyChainManagementSystem.dto.ResponceStructure;
import com.jsp.supplyChainManagementSystem.entity.Orders;
import com.jsp.supplyChainManagementSystem.entity.Product;
import com.jsp.supplyChainManagementSystem.entity.Supplier;
import com.jsp.supplyChainManagementSystem.exception.IdNotFoundException;
import com.jsp.supplyChainManagementSystem.repository.OrderRepository;
import com.jsp.supplyChainManagementSystem.repository.SupplierRepository;

import jakarta.persistence.criteria.Order;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	public ResponseEntity<ResponceStructure<Product>> saveProduct(int supplierid,int orderId,Product product)
	{
		Optional<Supplier> opt=supplierRepository.findById(supplierid);
		if(!opt.isPresent()) {
			throw new IdNotFoundException();
		}
		Optional<Orders> order=orderRepository.findById(orderId);
		if(!order.isPresent())
		{
			throw new IdNotFoundException();
		}
		product.setOrder(order.get());
		product.setSupplier(opt.get());
		Product recieveOrder = productDao.saveProduct(product);
		ResponceStructure<Product> structure=new ResponceStructure<Product>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Created");
		structure.setData(recieveOrder);
		return new ResponseEntity<ResponceStructure<Product>>(structure,HttpStatus.CREATED);

	}
	
	public ResponseEntity<ResponceStructure<Product>> getProductById(int id){
		Optional<Product> product = productDao.getProductById(id);
		
		ResponceStructure<Product> structure = new ResponceStructure<Product>();
		if(product.isPresent()) {
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("Found");
			structure.setData(product.get());
			return new ResponseEntity<ResponceStructure<Product>>(structure, HttpStatus.FOUND);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponceStructure<List<Product>>> getAllProduct(){
		List<Product> product = productDao.getAllProduct();
		
		ResponceStructure<List<Product>> structure = new ResponceStructure<List<Product>>();
		structure.setStatusCode(HttpStatus.FOUND.value());
		structure.setMessage("Found");
		structure.setData(product);
		
		return new ResponseEntity<ResponceStructure<List<Product>>>(structure,HttpStatus.FOUND);
	}
	
	
	public ResponseEntity<ResponceStructure<Product>> updateProduct(Product product){
		Product receivedProduct = productDao.updateProduct(product);
		
		ResponceStructure<Product> structure = new ResponceStructure<Product>();
		structure.setStatusCode(HttpStatus.FOUND.value());
		structure.setMessage("Found");
		structure.setData(receivedProduct);
		
		return new ResponseEntity<ResponceStructure<Product>>(structure, HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponceStructure<Product>> deleteProductById(int id){
		Optional<Product> product = productDao.getProductById(id);
		
		ResponceStructure<Product> structure  = new ResponceStructure<Product>();
		if(product.isPresent()) {
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Data deleted");
			
			productDao.deleteProductById(id);
			return new ResponseEntity<ResponceStructure<Product>>(structure, HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponceStructure<List<Product>>> findProductBySupplierId(int supplierID)
	{
		List<Product> products=productDao.getProductBySupplierId(supplierID);
		if(!products.isEmpty())
		{
			ResponceStructure<List<Product>> structure=new ResponceStructure<List<Product>>();
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("Founded");
			structure.setData(products);
			return new ResponseEntity<ResponceStructure<List<Product>>>(structure,HttpStatus.FOUND);
		}
		else
			throw new IdNotFoundException();
	}
}
