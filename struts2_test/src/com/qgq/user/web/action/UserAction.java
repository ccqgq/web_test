package com.qgq.user.web.action;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.opensymphony.xwork2.util.ValueStack;
import com.qgq.user.domain.User;
import com.qgq.user.exception.MyExcetion;
import com.qgq.user.service.UserService;
import com.qgq.user.utils.UploadUtils;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user=new User();
	@Override
	public User getModel() {
		return user;
	}
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	private String FileName;
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	/*
	 * 修改操作
	 */
	public String edit() throws SQLException{
		UserService service=new UserService();
		if(upload!=null){
			//上传了新的简历
			String UUIDName=UploadUtils.getUUIDFileName(uploadFileName);
			File dest=new File("d:/upload", UUIDName);
			try {
				FileUtils.copyFile(upload, dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
			user.setPath("d:/upload"+uploadFileName);
			user.setFilename(uploadFileName);
			User oldUser = service.findOne(user);
			File oldFile = new File(ServletActionContext.getServletContext()
					.getRealPath(oldUser.getPath()));
			oldFile.delete();
			service.edit(user, true);
		}
		return null;
	}
	/*
	 * 下载简历操作
	 */
	public String download(){
		
		return null;
	}
	/*
	 * 修改查询一个信息
	 */
	public String updatefind(){
		UserService service=new UserService();
		try {
			user=service.findOne(user);
			ValueStack stack=ActionContext.getContext().getValueStack();
			stack.set("user", user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "updatefind_success";
	}
	/*
	 * 查询一个user信息
	 */
	public String findone(){
		UserService service=new UserService();
		try {
			user=service.findOne(user);
			ValueStack stack=ActionContext.getContext().getValueStack();
			stack.set("user", user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "findone_success";
	}
	/*
	 * 删除操作
	 */
	public String delete(){
		UserService service=new UserService();
		try {
			user=service.findOne(user);
			if(user.getPath()!=null){
				new File(user.getPath()).delete();
			}
			service.delete(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "delete_success";
	}
	public String listselect(){
		UserService service=new UserService();
		List<User> users;
		try {
			users = service.listselect(user);
			System.out.println(users);
			ValueStack stack=ActionContext.getContext().getValueStack();
			stack.set("users", users);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "select_success";
	}
	/*
	 * 添加操作
	 */
	@InputConfig(resultName = "addINPUT")
	public String add() {
		if(upload!=null){
			//完成上传操作
			String UUIDName=UploadUtils.getUUIDFileName(uploadFileName);
			File dest=new File("d:/upload", UUIDName);
			try {
				FileUtils.copyFile(upload, dest);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			user.setPath("d:/upload"+uploadFileName);
			user.setFilename(uploadFileName);
		}
		//调用service添加操作
		
		UserService service=new UserService();
		try {
			service.add(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "add_success";
	}
	/*
	 * 查询所有
	 */
	public String list(){
		UserService service=new UserService();
		try {
			List<User> users=service.findAll();
			ValueStack stack=ActionContext.getContext().getValueStack();
			stack.set("users", users);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "list_success";
	}
	/*
	 * 登录操作
	 */
	@InputConfig(resultName = "loginINPUT")
	public String login(){
		//调用service方法
		UserService service=new UserService();
		try {
			System.out.println(user.getLoginName());
			user=service.login(user.getLoginName(),user.getLoginPwd());
			
			if(user==null){
				System.out.println("======");
				this.addActionError("用户名或密码错误！！");
				return LOGIN;
			}
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
		} catch (SQLException e) {
			e.printStackTrace();
			//throw new MyExcetion();
			return LOGIN;
			
		}
		return "login_success";
	}



	

}
