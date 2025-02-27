package com.jsp.supplyChainManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.supplyChainManagementSystem.dao.OrderDao;
import com.jsp.supplyChainManagementSystem.dao.ProductDao;
import com.jsp.supplyChainManagementSystem.dto.OrdersRequest;
import com.jsp.supplyChainManagementSystem.dto.ResponceStructure;
import com.jsp.supplyChainManagementSystem.entity.Customer;
import com.jsp.supplyChainManagementSystem.entity.Orders;
import com.jsp.supplyChainManagementSystem.entity.Product;
import com.jsp.supplyChainManagementSystem.exception.IdNotFoundException;
import com.jsp.supplyChainManagementSystem.repository.CustomerRepository;
import com.jsp.supplyChainManagementSystem.repository.ProductRepository;

@Service
public class OrderService {
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;

	public ResponseEntity<ResponceStructure<Orders>> saveOrder(OrdersRequest orderRequest)
	{
		int customerId=orderRequest.getCustomerId();
		List<Integer> productId=orderRequest.getProductId();
		Optional<Customer> customerOpt=customerRepository.findById(customerId);
		List<Product> product=productRepository.findAllById(productId);
		if(!customerOpt.isPresent()) {
			throw new IdNotFoundException();
		}
		if(product.isEmpty()) {
			throw new IdNotFoundException();
		}
		Orders orders=new Orders();
		orders.setCustomer(customerOpt.get());
		orders.setProducts(product);
		orders.setTotalAmount(orderRequest.getTotalAmount());
		orders.setStatus(orderRequest.getStatus());
		orders.setTrackingNumber(orderRequest.getTrackingNumber());
		orders.setOrderDate(orderRequest.getOrderDate());
		Orders recieveOrder = orderDao.saveOrder(orders);
		ResponceStructure<Orders> structure=new ResponceStructure<Orders>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("Created");
		structure.setData(recieveOrder);
		return new ResponseEntity<ResponceStructure<Orders>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponceStructure<Orders>> getOrdersById(int id){
		Optional<Orders> orders = orderDao.getOrdersById(id);
		
		ResponceStructure<Orders> structure = new ResponceStructure<Orders>();
		if(orders.isPresent()) {
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("Found");
			structure.setData(orders.get());
			
			return new ResponseEntity<ResponceStructure<Orders>>(structure, HttpStatus.FOUND);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponceStructure<List<Orders>>> getAllOrders(){
		List<Orders> orders = orderDao.getAllOrders();
		
		ResponceStructure<List<Orders>> structure = new ResponceStructure<List<Orders>>();
		structure.setStatusCode(HttpStatus.FOUND.value());
		structure.setMessage("Found");
		structure.setData(orders);
		
		return new ResponseEntity<ResponceStructure<List<Orders>>>(structure, HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponceStructure<List<Orders>>> getOrderByCustomerId(int id){
		List<Orders> orders = orderDao.getOrderByCustomerId(id);
		if(!orders.isEmpty()) {
			ResponceStructure<List<Orders>> structure = new ResponceStructure<List<Orders>>();
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("Data is being Founded");
			structure.setData(orders);
			
			return new ResponseEntity<ResponceStructure<List<Orders>>>(structure, HttpStatus.FOUND);
		}
		else {
			throw new IdNotFoundException();
		}
	}
	
	public ResponseEntity<ResponceStructure<Orders>> getOrdersByTrackingId(String trackingId){
		Optional<Orders> orders = orderDao.getOrdersByTrackingId(trackingId);
		
		ResponceStructure<Orders> structure = new ResponceStructure<Orders>();
		if(orders.isPresent()) {
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("Found");
			structure.setData(orders.get());
			
			return new ResponseEntity<ResponceStructure<Orders>>(structure, HttpStatus.FOUND);
		}
		else {
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("Not Found");
			
			return new ResponseEntity<ResponceStructure<Orders>>(structure, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponceStructure<Orders>> updateOrders(Orders orders){
		Orders recievedOrders = orderDao.saveOrder(orders);
		
		ResponceStructure<Orders> structure = new ResponceStructure<Orders>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("Success");
		structure.setData(recievedOrders);
		
		return new ResponseEntity<ResponceStructure<Orders>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponceStructure<Orders>> deleteOrdersById(int id) {
		Optional<Orders> orders = orderDao.getOrdersById(id);
		
		ResponceStructure<Orders> structure = new ResponceStructure<Orders>();
		
		if(orders.isPresent()) {			
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Data Deleted");
			
			orderDao.deleteOrdersById(id);
			
			return new ResponseEntity<ResponceStructure<Orders>>(structure, HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException();
		}
		
	}
}
