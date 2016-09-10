package com.qgq.web.service;

import java.sql.SQLException;
import java.util.List;

import com.qgq.web.dao.UserDao;
import com.qgq.web.vo.User;

public class UserService {

	public User login(User user) throws SQLException {
		 return new UserDao().login(user);
	}

	public List<User> select() throws SQLException {
		return new UserDao().select();
	}
	
}
