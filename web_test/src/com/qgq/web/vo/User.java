package com.qgq.web.vo;

public class User {
	private int id;
	private String loginName;
	private String loginPassword;
	private String username;
	private String role;
	public User(int id, String loginName, String loginPassword,
			String username, String role) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.loginPassword = loginPassword;
		this.username = username;
		this.role = role;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
