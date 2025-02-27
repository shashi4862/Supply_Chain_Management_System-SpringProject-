package com.jsp.supplyChainManagementSystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.supplyChainManagementSystem.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
	List<Orders> getCustomerById(int customerId);
	
	@Query("select o from Orders o where o.trackingNumber = ?1")
	Optional<Orders> getOrdersBytrackingNumber(String trrackingId);
}
