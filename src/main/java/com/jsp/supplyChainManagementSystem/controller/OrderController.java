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

import com.jsp.supplyChainManagementSystem.dto.OrdersRequest;
import com.jsp.supplyChainManagementSystem.dto.ResponceStructure;
import com.jsp.supplyChainManagementSystem.entity.Orders;
import com.jsp.supplyChainManagementSystem.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/orders")
	public ResponseEntity<ResponceStructure<Orders>> saveOrder(@RequestBody OrdersRequest orders)
	{
		return orderService.saveOrder(orders);
	}
	
	@GetMapping("/orders/{id}")
	public ResponseEntity<ResponceStructure<Orders>> getOrdersById(@PathVariable int id){
		return orderService.getOrdersById(id);
	}
	
	@GetMapping("/orders")
	public ResponseEntity<ResponceStructure<List<Orders>>> getAllOrders(){
		return orderService.getAllOrders();
	}
	
	@GetMapping("/orders/customer/{id}")
	public ResponseEntity<ResponceStructure<List<Orders>>> getOrderByCustomerId(@PathVariable int cid)
	{
		return orderService.getOrderByCustomerId(cid);
	}
	
	@GetMapping("/orders/trackingNumber/{trackingId}")
	public ResponseEntity<ResponceStructure<Orders>> getOrdersByTrackingId(@PathVariable String trackingId){
		return orderService.getOrdersByTrackingId(trackingId);
	}
	
	@PutMapping("/orders")
	public ResponseEntity<ResponceStructure<Orders>> updateOrders(@RequestBody Orders orders){
		return orderService.updateOrders(orders);
	}
	
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<ResponceStructure<Orders>> deleteOrdersById(@PathVariable int id){
		return orderService.deleteOrdersById(id);
	}
}
