package com.nagarro.nagp.ordermanagement.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagp.ordermanagement.model.Order;

@RestController
@RequestMapping(value = "/order-management/order")
public class OrderManagementController {
	
	
	@GetMapping(value="{orderId}")
	public Order getOrder(@PathVariable("orderId") long orderId) {
       return getOrderByOrderId(orderId);
	}
	
	@GetMapping
	public List<Order> getOrders() {
       return getListOfOrders();
	}

	private Order getOrderByOrderId(long orderId) {
		List<Order> orders = getListOfOrders();
		for(Order order : orders){
			if(order.getId()== orderId)
				return order;
		}
		return null;
	}

	public List<Order> getListOfOrders() {
		List<Order> orders = new ArrayList<>();
       Order order1 = new Order(1l,"dog-biscuits",LocalDate.now(),250);
       Order order2 = new Order(2l,"dog-toys",LocalDate.now(),300);
       Order order3 = new Order(3l,"dog-treats",LocalDate.now(),390);
       Order order4 = new Order(4l,"dog-jackets",LocalDate.now(),800);
       orders.add(order1);
       orders.add(order2);
       orders.add(order3);
       orders.add(order4);
       return orders;
	}

}
