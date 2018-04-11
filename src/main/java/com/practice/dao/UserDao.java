package com.practice.dao;

import java.util.List;

import com.practice.service.User;

public interface UserDao {
	
	List<User> findAllUsers();
	User findUserById(int id);
	String addUser(User obj);
	

}
