package com.nagarro.nagp.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagp.usermanagement.model.User;
import com.nagarro.nagp.usermanagement.services.UserManagementService;

/**
 * 
 * @author heenamittal
 *
 */
@RestController
@RequestMapping(value = "/user-management/user")
public class UserManagementController {

	@Autowired
	UserManagementService userManagementService;

	@GetMapping(value = "{userId}")
	public User getUser(@PathVariable("userId") long userId) {
		return userManagementService.getUserByUserId(userId);
	}

	@GetMapping
	public List<User> getUsers() {
		return userManagementService.getListOfUsers();
	}

}
