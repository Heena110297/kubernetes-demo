/**
 * 
 */
package com.nagarro.nagp.ordermanagement.services;

import java.util.List;

import com.nagarro.nagp.ordermanagement.model.Order;

/**
 * @author HMT
 * @version 1.0
 * 
 */
public interface OrderManagementService {

	Order getOrderByOrderId(long orderId);
	
	List<Order> getListOfOrders();
}
