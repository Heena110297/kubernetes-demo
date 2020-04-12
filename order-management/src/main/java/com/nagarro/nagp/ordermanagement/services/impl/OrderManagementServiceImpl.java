/**
 * 
 */
package com.nagarro.nagp.ordermanagement.services.impl;

import java.lang.invoke.MethodHandles;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.ordermanagement.model.Order;
import com.nagarro.nagp.ordermanagement.services.OrderManagementService;

/**
 * @author HMT
 * @version 1.0
 * 
 */
@Service
public class OrderManagementServiceImpl implements OrderManagementService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

	@Override
	public Order getOrderByOrderId(long orderId) {
		LOGGER.info("Fetching Orders..");
		List<Order> orders = getOrders();
		for (Order order : orders) {
			if (order.getId() == orderId)
				return order;
		}
		return null;
	}

	@Override
	public List<Order> getListOfOrders() {
		return getOrders();
	}

	public List<Order> getOrders() {
		List<Order> orders = new ArrayList<>();
		Order order1 = new Order(1l, "dog-biscuits", LocalDate.now(), 250);
		Order order2 = new Order(2l, "dog-toys", LocalDate.now(), 300);
		Order order3 = new Order(3l, "dog-treats", LocalDate.now(), 390);
		Order order4 = new Order(4l, "dog-jackets", LocalDate.now(), 800);
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		orders.add(order4);
		return orders;
	}

}
