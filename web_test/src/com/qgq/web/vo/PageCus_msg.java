package com.qgq.web.vo;

import java.util.List;

public class PageCus_msg {
	
	//总页数
	private int pageSum;
	//总条数
	private int account;
	//每页的条数
	private int onePageAccont;
	//页码
	private int pageNum;
	//每页的数据
	private List<Cus_msg> list;
	private List<User> list2;
	public int getPageSum() {
		return pageSum;
	}
	public void setPageSum(int pageSum) {
		this.pageSum = pageSum;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public int getOnePageAccont() {
		return onePageAccont;
	}
	public void setOnePageAccont(int onePageAccont) {
		this.onePageAccont = onePageAccont;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public List<Cus_msg> getList() {
		return list;
	}
	public void setList(List<Cus_msg> list) {
		this.list = list;
	}
	public List<User> getList2() {
		return list2;
	}
	public void setList2(List<User> list2) {
		this.list2 = list2;
	}
	public PageCus_msg(int pageSum, int account, int onePageAccont,
			int pageNum, List<Cus_msg> list, List<User> list2) {
		super();
		this.pageSum = pageSum;
		this.account = account;
		this.onePageAccont = onePageAccont;
		this.pageNum = pageNum;
		this.list = list;
		this.list2 = list2;
	}
	public PageCus_msg() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PageCus_msg [pageSum=" + pageSum + ", account=" + account
				+ ", onePageAccont=" + onePageAccont + ", pageNum=" + pageNum
				+ ", list=" + list + ", list2=" + list2 + "]";
	}
	
	
	
}
