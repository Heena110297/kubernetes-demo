package com.nagarro.nagp.aggregator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagp.aggregator.models.UserDetails;
import com.nagarro.nagp.aggregator.services.AggregatorService;

@RestController
@RequestMapping(value = "/aggregator")
public class AggregatorController {

	@Autowired
	AggregatorService aggregatorService;

	@GetMapping(value = "/orderDetails/{userId}")
	public UserDetails getOrder(@PathVariable("userId") long userId) {
		return aggregatorService.getUserDetail(userId);
	}
}
