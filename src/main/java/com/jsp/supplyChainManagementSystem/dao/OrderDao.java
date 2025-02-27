package com.jsp.supplyChainManagementSystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.supplyChainManagementSystem.entity.Orders;
import com.jsp.supplyChainManagementSystem.repository.OrderRepository;

@Repository
public class OrderDao {
	@Autowired
	private OrderRepository orderRepository;
	
	public Orders saveOrder(Orders orders) {
		return orderRepository.save(orders);
	}
	
	public Optional<Orders> getOrdersById(int id) {
		return orderRepository.findById(id);
	}
	
	public List<Orders> getAllOrders() {
		return orderRepository.findAll();
	}
	
	public List<Orders> getOrderByCustomerId(int id){
		return orderRepository.getCustomerById(id);
	}
	
	public Optional<Orders> getOrdersByTrackingId(String trackingId) {
		return orderRepository.getOrdersBytrackingNumber(trackingId);
	}
	
	public Orders updateOrders(Orders orders) {
		return orderRepository.save(orders);
	}
	
	public void deleteOrdersById(int id) {
		orderRepository.deleteById(id);
	}
}
