package com.qgq.user.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.New;
import javax.persistence.Id;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.struts2.components.Param;

import com.qgq.user.domain.User;
import com.qgq.user.utils.JDBCUtils;

public class UserDao {
	//登录操作
	public User login(String loginName, String loginPwd) throws SQLException {
		String sql="select * from s_user where loginName=? and loginPwd=?";
		QueryRunner runner=new QueryRunner(JDBCUtils.getComboPooledDataSource());
		User user=runner.query(sql, new BeanHandler<User>(User.class),loginName,loginPwd);
		return user;
	}
	//查询所有
	public List<User> findAll() throws SQLException {
		String sql="select * from s_user";
		QueryRunner runner=new QueryRunner(JDBCUtils.getComboPooledDataSource());
		
		return runner.query(sql, new  BeanListHandler<User>(User.class));
	}
	public void add(User user) throws SQLException {
		QueryRunner runner=new QueryRunner(JDBCUtils.getComboPooledDataSource());
		
		String sql="insert into s_user values(null,?,?,?,?,?,?,?,?,?,?,?)";
		runner.update(sql, user.getUserName(),user.getLoginName(),user.getLoginPwd(),
				user.getSex(),user.getBirthday(),user.getEducation(),user.getTelephone(),
				user.getInterest(),user.getPath(),user.getFilename(),user.getRemark());
	}
	/*
	 * 条件查询
	 */
	public List<User> listselect(User user) throws SQLException {
		QueryRunner runner=new QueryRunner(JDBCUtils.getComboPooledDataSource());
		String sql="select * from s_user where 1=1";
		List<Object> list=new ArrayList<Object>();
		String username=user.getUserName();
		if(username!=null&&username.trim().length()!=0){
			sql+=" and userName like ?";
			list.add("%"+username+"%");
		}
		String sex=user.getSex();
		if(sex!=null&&sex.trim().length()!=0){
			sql+=" and sex=?";
			list.add(sex);
		}
		String education=user.getEducation();
		if(education!=null&&education.trim().length()!=0){
			sql+=" and education =?";
			list.add(education);
		}
		String isupload=user.getIsupload();
		if("1".equals(isupload)){
			sql+=" and fileName is not null";
		}else if ("2".equals(isupload)) {
			sql+=" and fileName is null";
		}
		System.out.println(sql);
		return runner.query(sql,  new BeanListHandler<User>(User.class),list.toArray());
	}
	public void delete(User user) throws SQLException {
		QueryRunner runner=new QueryRunner(JDBCUtils.getComboPooledDataSource());
		String sql="delete from s_user where userID=?";
		runner.update(sql,user.getUserID());
	}
	public User findOne(User user) throws SQLException {
		QueryRunner runner=new QueryRunner(JDBCUtils.getComboPooledDataSource());
		String sql="select * from s_user where userID=?";

		return runner.query(sql, new BeanHandler<User>(User.class),user.getUserID());
	}
	
	
	
	
	
	

}
