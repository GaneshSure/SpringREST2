package com.practice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.practice.service.User;

public class UserMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		User u = new User();
		u.setId(rs.getInt(1));
		u.setName(rs.getString(2));
		return u;
	}

}
