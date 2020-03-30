package com.nagarro.nagp.usermanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagp.usermanagement.model.User;

/**
 * 
 * @author heenamittal
 *
 */
@RestController
@RequestMapping(value = "/user-management/user")
public class UserManagementController {

	@GetMapping(value="{userId}")
	public User getUser(@PathVariable("userId") long userId) {
       return getUserByUserId(userId);
	}
	
	@GetMapping
	public List<User> getUsers() {
       return getListOfUsers();
	}

	private User getUserByUserId(long userId) {
		List<User> users = getListOfUsers();
		for(User user : users){
			if(user.getUserId()== userId)
				return user;
		}
		return null;
	}

	public List<User> getListOfUsers() {
		List<User> users = new ArrayList<>();
       User user1 = new User(1l,"Heena","heena.mittal@nagarro.com",23);
       User user2 = new User(2l,"TestUser","testUser@gmail.com",30);
       users.add(user1);
       users.add(user2);
       return users;
	}
	
	
}
