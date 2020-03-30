package com.nagarro.nagp.aggregator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.nagp.aggregator.models.Order;
import com.nagarro.nagp.aggregator.models.User;
import com.nagarro.nagp.aggregator.models.UserDetails;

@RestController
@RequestMapping(value = "/aggregator")
public class AggregatorController {

	@Value("${USER_API_URL:http://localhost:9106}")
	private String userApiUrl;

	@Value("${ORDER_API_URL:http://localhost:9105}")
	private String orderApiUrl;

	@Resource(name = "restTemp")
	private RestTemplate restTemplate;

	@GetMapping(value = "/orderDetails/{userId}")
	public UserDetails getOrder(@PathVariable("userId") long userId) {
		System.out.println(orderApiUrl);
		System.out.println(userApiUrl);
		return getUserDetail(userId);
	}

	private UserDetails getUserDetail(long userId) {
		User user = getUserByUserId(userId);
		List<Order> userOrders = new ArrayList<>();
		List<Order> orders = getListOfOrders();
		userOrders.add(orders.get(0));
		userOrders.add(orders.get(1));
		return new UserDetails(userId, user.getName(), user.getEmailid(), user.getAge(), orders);
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
