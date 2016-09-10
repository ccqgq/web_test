package com.qgq.web.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.qgq.web.utils.C3p0Utils;
import com.qgq.web.vo.Cus_msg;

public class Cus_msgDao {
	private QueryRunner runner=new QueryRunner(C3p0Utils.getDataSource());
	public List<Cus_msg> selectPage(int pageNum, int onePageAccount, Cus_msg cus_msg) throws SQLException {
		String sql="select * from cus_msg where u_id=? ";
		List<Object> list=new ArrayList<Object>();
		list.add(cus_msg.getU_id());
		
		String cus_id=cus_msg.getCus_id();
		if(cus_id!=null&&cus_id.trim().length()!=0){
			sql+=" and cus_id like ?";
			list.add("%"+cus_id+"%");
		}
		String level=cus_msg.getLevel();
		if(level!=null&&level.trim().length()!=0){
			sql+=" and level=?";
			list.add(level);
		}
		String area=cus_msg.getArea();
		if(area!=null&&area.trim().length()!=0){
			sql+=" and area =?";
			list.add(area);
		}
		sql+=" limit ?,?";
		list.add((pageNum-1)*onePageAccount);
		list.add(onePageAccount);
		System.out.println(list.toString());
		return runner.query(sql, new BeanListHandler<Cus_msg>(Cus_msg.class),list.toArray());
	
	}

	public int account(String u_id) throws SQLException {
		String sql="select count(*) from cus_msg where u_id=?";
		long i= (Long) runner.query(sql, new ScalarHandler(),u_id);
		return (int)i;
		
	}

	public void delete(String[] ids) throws SQLException {
		StringBuilder builder=new StringBuilder();
		builder.append("delete from cus_msg where id in(");
		for(int i=0;i<ids.length;i++){
			if(i==ids.length-1){
				builder.append("?)");
			}else {
				builder.append("?,");
			}
			
		}
		
		System.out.println(builder.toString());
		String sql=builder.toString();
		runner.update(sql, ids);
		/*for(int i=0;i<ids.length;i++){
			String sql="delete from cus_msg where id=?";
			runner.update(sql, ids[i]);
		}*/
	}

	public Cus_msg select(String id) throws SQLException {
		String sql="select * from cus_msg where id=?";
		return runner.query(sql, new BeanHandler<Cus_msg>(Cus_msg.class),id);
		
	}

	public void add(Cus_msg cus_msg) throws SQLException {
		String sql="insert into  cus_msg values(null,?,?,?,?,?,?,?,?)";
		runner.update(sql, cus_msg.getCus_id(),cus_msg.getName(),cus_msg.getLevel(),cus_msg.getArea(),cus_msg.getU_id(),cus_msg.getCus_dept(),cus_msg.getCus_industy(),cus_msg.getCus_type());
		
	}

	public void update(Cus_msg cus_msg) throws SQLException {
		String sql="update   cus_msg set name=?,level=?,area=?,cus_dept=?,cus_industy=?,cus_type=? where id=?";
		runner.update(sql,cus_msg.getName(),cus_msg.getLevel(),cus_msg.getArea(),cus_msg.getCus_dept(),cus_msg.getCus_industy(),cus_msg.getCus_type(),cus_msg.getId());
		
	}

	public List<Cus_msg> selectall(int pageNum, int onePageAccount,
			Cus_msg cus_msg) throws SQLException {
		String sql="select * from cus_msg where 1=1 ";
		List<Object> list=new ArrayList<Object>();
		
		
		String cus_id=cus_msg.getCus_id();
		if(cus_id!=null&&cus_id.trim().length()!=0){
			sql+=" and cus_id like ?";
			list.add("%"+cus_id+"%");
		}
		String level=cus_msg.getLevel();
		if(level!=null&&level.trim().length()!=0){
			sql+=" and level=?";
			list.add(level);
		}
		String area=cus_msg.getArea();
		if(area!=null&&area.trim().length()!=0){
			sql+=" and area =?";
			list.add(area);
		}
		sql+=" limit ?,?";
		list.add((pageNum-1)*onePageAccount);
		list.add(onePageAccount);
		return runner.query(sql, new BeanListHandler<Cus_msg>(Cus_msg.class),list.toArray());
	
	}

	public int account() throws SQLException {
		String sql="select count(*) from cus_msg ";
		long i= (Long) runner.query(sql, new ScalarHandler());
		return (int)i;
	}

}
