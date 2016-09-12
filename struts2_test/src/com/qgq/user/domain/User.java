package com.qgq.user.domain;

public class User {
	// ID
	private int userID;
	// 用户姓名
	private String userName;
	// 登录名
	private String loginName;
	// 密码
	private String loginPwd;
	// 性别（例如：男，女）
	private String sex;
	// 出生日期
	private String birthday;
	// 学历（例如：研究生、本科、专科、高中）
	private String education;
	// 电话
	private String telephone;
	// 兴趣爱好（例如：体育、旅游、逛街）
	private String interest;
	// 上传路径（path路径)
	private String path;
	// 上传文件名称（文件名）
	private String filename;
	// 备注
	private String remark;
	private String isupload;

	public String getIsupload() {
		return isupload;
	}

	public void setIsupload(String isupload) {
		this.isupload = isupload;
	}

	public User() {

	}

	public User(int userID, String userName, String loginName, String loginPwd,
			String sex, String birthday, String education, String telephone,
			String interest, String path, String filename, String remark) {
		this.userID = userID;
		this.userName = userName;
		this.loginName = loginName;
		this.loginPwd = loginPwd;
		this.sex = sex;
		this.birthday = birthday;
		this.education = education;
		this.telephone = telephone;
		this.interest = interest;
		this.path = path;
		this.filename = filename;
		this.remark = remark;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
