package com.qgq.web.service;

import java.sql.SQLException;
import java.util.List;





import com.qgq.web.dao.Cus_msgDao;
import com.qgq.web.vo.Cus_msg;
import com.qgq.web.vo.PageCus_msg;

public class Cus_msgService {
	private Cus_msgDao dao=new Cus_msgDao();
	public PageCus_msg selectPage(int pageNum, int onePageAccount, Cus_msg cus_msg) throws SQLException {
		PageCus_msg pageCus_msg = new PageCus_msg();
		// 将每页条数封装到pageCus_msg对象中
		pageCus_msg.setOnePageAccont(onePageAccount);
		// 将页码封装到pageCus_msg中
		pageCus_msg.setPageNum(pageNum);
		List<Cus_msg> list = dao.selectPage(pageNum, onePageAccount, cus_msg);
		// 将每页user对象封装到pageCus_msg中
		pageCus_msg.setList(list);
		// 求一共有多少条数据
		int account = account(cus_msg.getU_id()+"");
		pageCus_msg.setAccount(account);
		// 计算出总页数
		int pageSum = (int) Math.ceil(account * 1.0 / onePageAccount);
		pageCus_msg.setPageSum(pageSum);
		return pageCus_msg;
	}
	private int account(String u_id) throws SQLException {
		
		 return dao.account(u_id);
	}
	public void delete(String[] ids) throws SQLException {
		dao.delete(ids);
	}
	/*
	 * 通过id查询单个信息
	 */
	public Cus_msg select(String id) throws SQLException {
		return dao.select(id);
		
	}
	public void add(Cus_msg cus_msg) throws SQLException {
		dao.add(cus_msg);
		
	}
	public void update(Cus_msg cus_msg) throws SQLException {
		dao.update(cus_msg);
	}
	public PageCus_msg selectall(int pageNum, int onePageAccount,
			Cus_msg cus_msg) throws SQLException {
		PageCus_msg pageCus_msg = new PageCus_msg();
		// 将每页条数封装到pageCus_msg对象中
		pageCus_msg.setOnePageAccont(onePageAccount);
		// 将页码封装到pageCus_msg中
		pageCus_msg.setPageNum(pageNum);
		List<Cus_msg> list = dao.selectall(pageNum, onePageAccount, cus_msg);
		// 将每页user对象封装到pageCus_msg中
		pageCus_msg.setList(list);
		// 求一共有多少条数据
		int account = account();
		pageCus_msg.setAccount(account);
		// 计算出总页数
		int pageSum = (int) Math.ceil(account * 1.0 / onePageAccount);
		pageCus_msg.setPageSum(pageSum);
		return pageCus_msg;
	}
	private int account() throws SQLException {
		return dao.account();
	}

}
