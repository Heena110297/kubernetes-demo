package com.nagarro.nagp.usermanagement.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.nagp.usermanagement.model.User;
import com.nagarro.nagp.usermanagement.services.UserManagementService;

@Service
public class UserManagementServiceImpl implements UserManagementService {

	@Override
	public User getUserByUserId(long userId) {
		List<User> users = getUsers();
		for (User user : users) {
			if (user.getUserId() == userId)
				return user;
		}
		return null;
	}

	@Override
	public List<User> getListOfUsers() {
		return getUsers();
				
	}

	public List<User> getUsers() {
		List<User> users = new ArrayList<>();
		User user1 = new User(1l, "Heena", "heena.mittal@nagarro.com", 23);
		User user2 = new User(2l, "TestUser", "testUser@gmail.com", 30);
		users.add(user1);
		users.add(user2);
		return users;
	}
}
