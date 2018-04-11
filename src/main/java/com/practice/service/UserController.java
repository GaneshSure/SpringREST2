package com.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practice.dao.UserDao;

@RestController
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="/getUsers", method=RequestMethod.GET, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllUsers(){
	
		List<User> userList=userDao.findAllUsers();
				
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/getUserByid/{id}", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserById(@PathVariable("id")int id){
		
		User u=userDao.findUserById(id);
		return new ResponseEntity<User>(u,HttpStatus.OK);
		
	}

	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public String createNewUser(@RequestBody User user) {
		String str= userDao.addUser(user);
		return str;
		
	}
}
