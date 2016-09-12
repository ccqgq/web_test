package com.qgq.user.service;

import java.sql.SQLException;
import java.util.List;

import com.qgq.user.dao.UserDao;
import com.qgq.user.domain.User;

public class UserService {
	private static UserDao dao=new UserDao();
	public User login(String loginName, String loginPwd) throws SQLException {
		return dao.login(loginName,loginPwd);
	}
	public List<User> findAll() throws SQLException {
		
		return dao.findAll();
	}
	public void add(User user) throws SQLException {
		dao.add(user);
	}
	public List<User> listselect(User user) throws SQLException {
		
		return dao.listselect(user);
	}
	public void delete(User user) throws SQLException {
		dao.delete(user);
		
	}
	public User findOne(User user) throws SQLException {
		return dao.findOne(user);
		
	}
	public void edit(User user, boolean b) {
		
		
	}

}
