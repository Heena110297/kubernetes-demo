/**
 * 
 */
package com.nagarro.nagp.aggregator.services.impl;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.nagp.aggregator.models.Order;
import com.nagarro.nagp.aggregator.models.User;
import com.nagarro.nagp.aggregator.models.UserDetails;
import com.nagarro.nagp.aggregator.services.AggregatorService;

/**
 * @author HMT
 * @version 1.0
 * 
 */
@Service
public class AggregatorServiceImpl implements AggregatorService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

	@Value("${USER_API_URL:http://localhost:9106}")
	private String userApiUrl;

	@Value("${ORDER_API_URL:http://localhost:9105}")
	private String orderApiUrl;

	@Resource(name = "restTemp")
	private RestTemplate restTemplate;
	
	@Override
	public UserDetails getUserDetail(long userId) {
		LOGGER.info("Fetching User with userId :"+userId);
		User user = getUserByUserId(userId);
		LOGGER.info("Fetching Orders of user with userId :"+userId);
		List<Order> userOrders = new ArrayList<>();
		List<Order> orders = getListOfOrders();
		if(userId == 1) {
		userOrders.add(orders.get(0));
		userOrders.add(orders.get(1));
		}
		else if(userId == 2) {
			userOrders.add(orders.get(2));
			userOrders.add(orders.get(3));
		}
		LOGGER.info("Operation Completed");
		return new UserDetails(userId, user.getName(), user.getEmailid(), user.getAge(), userOrders);
	}

public List<Order> getListOfOrders() {
		
		List<Order> orders = new ArrayList<>();
		String url = "order-management/order";
		ResponseEntity<Object[]> response = restTemplate.getForEntity(orderApiUrl +"/"+  url, Object[].class);
		ObjectMapper mapper = new ObjectMapper();
		Object[] orderResp = response.getBody();
		Order order1 = mapper.convertValue(orderResp[0], Order.class);
		Order order2 = mapper.convertValue(orderResp[1], Order.class);
		Order order3 = mapper.convertValue(orderResp[2], Order.class);
		Order order4 = mapper.convertValue(orderResp[3], Order.class);
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		orders.add(order4);
		return orders;
	}

	private User getUserByUserId(long userId) {
		String url = "user-management/user";
		System.out.println(userApiUrl +"/"+ url + "/" + userId);
		Object response = restTemplate.getForObject(userApiUrl +"/"+ url + "/" + userId, Object.class);
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(response, User.class);
	}
}
