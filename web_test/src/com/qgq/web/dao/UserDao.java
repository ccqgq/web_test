package com.qgq.web.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qgq.web.utils.C3p0Utils;
import com.qgq.web.vo.User;

public class UserDao {

	public User login(User user) throws SQLException {
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		String sql="select * from user where loginName=? and loginPassword=?";
		User u=runner.query(sql, new BeanHandler<User>(User.class),user.getLoginName(),user.getLoginPassword());
		return u;
	}

	public List<User> select() throws SQLException {
		QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
		String sql="select * from user";
		return runner.query(sql, new BeanListHandler<User>(User.class));
		
	}

}
