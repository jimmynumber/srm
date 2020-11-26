package com.want.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import lombok.Data;

@Data
public class UserJdbc implements RowMapper<UserJdbc> {
	private int id;
	private String username;
	private String password;

	// 必须重写mapRow方法
	@Override
	public UserJdbc mapRow(ResultSet resultSet, int i) throws SQLException {
		UserJdbc user = new UserJdbc();
		user.setId(resultSet.getInt("id"));
		user.setUsername(resultSet.getString("username"));
		user.setPassword(resultSet.getString("password"));
		return user;
	}
}