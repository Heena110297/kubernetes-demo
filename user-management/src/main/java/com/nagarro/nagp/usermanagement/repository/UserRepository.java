package com.nagarro.nagp.usermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nagarro.nagp.usermanagement.model.User;

/**
 * 
 * @author HMT
 * @version 1.0
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	   


}