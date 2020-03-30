package com.nagarro.nagp.ordermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagp.ordermanagement.model.Order;
import com.nagarro.nagp.ordermanagement.services.OrderManagementService;

@RestController
@RequestMapping(value = "/order-management/order")
public class OrderManagementController {
	
	@Autowired
	OrderManagementService orderManagementService;
	
	@GetMapping(value="{orderId}")
	public Order getOrder(@PathVariable("orderId") long orderId) {
		return orderManagementService.getOrderByOrderId(orderId);
	}
	
	@GetMapping
	public List<Order> getOrders() {
       return orderManagementService.getListOfOrders();
	}
}
