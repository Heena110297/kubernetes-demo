package com.nagarro.nagp.usermanagement.services.impl;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.usermanagement.model.User;
import com.nagarro.nagp.usermanagement.repository.UserRepository;
import com.nagarro.nagp.usermanagement.services.UserManagementService;

/**
 * 
 * @author HMT
 * @version 1.0
 *
 */
@Service
public class UserManagementServiceImpl implements UserManagementService {

	@Autowired
	UserRepository userRepo;
	
	private final static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());
	
	@Override
	public User getUserByUserId(long userId) {
		LOGGER.info("Fetching user from DB ...");
		return userRepo.findById(userId).orElse(null);
	}

	@Override
	public List<User> getListOfUsers() {
		LOGGER.info("Fetching all user from DB ...");
		return userRepo.findAll();

	}
}
