package com.jsp.supplyChainManagementSystem.dto;

import java.util.List;

public class OrdersRequest {
	private int customerId;
	private List<Integer> productId;
	private double totalAmount;
	private String orderDate;
	private String status;
	private String trackingNumber;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public List<Integer> getProductId() {
		return productId;
	}
	public void setProductId(List<Integer> productId) {
		this.productId = productId;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	
	
}
