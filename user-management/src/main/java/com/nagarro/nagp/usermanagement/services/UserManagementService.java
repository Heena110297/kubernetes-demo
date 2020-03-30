package com.nagarro.nagp.usermanagement.services;

import java.util.List;

import com.nagarro.nagp.usermanagement.model.User;

/**
 * 
 * @author HMT
 * @version 1.0
 *
 */
public interface UserManagementService {

	public User getUserByUserId(long userId);

	public List<User> getListOfUsers();
}
