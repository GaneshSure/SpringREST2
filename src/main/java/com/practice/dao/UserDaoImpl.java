package com.practice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.practice.service.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public List<User> findAllUsers() {
		List<User> list=jt.query("select * from users", new UserMapper());
		return list;
	}

	@Override
	public User findUserById(int id) {
		List<User> list=jt.query("select * from users where id=?", new UserMapper(), id);
		return (User)list.get(0);
	}

	@Override
	public String addUser(User obj) {
		String str;
		int id=obj.getId();
		String name=obj.getName();
		int i=jt.update("insert into users values(?,?)",id,name);
		if(i==1) {
			str="User Inserted";
		}else {
			str="Sorry, User already existed";
		}
		return str;
	}

}
