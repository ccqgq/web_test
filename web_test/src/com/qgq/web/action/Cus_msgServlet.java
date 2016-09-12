package com.qgq.web.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.qgq.web.service.Cus_msgService;
import com.qgq.web.service.UserService;
import com.qgq.web.vo.Cus_msg;
import com.qgq.web.vo.PageCus_msg;
import com.qgq.web.vo.User;

public class Cus_msgServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		User user=(User) request.getSession().getAttribute("user");
		if(user==null){
			System.out.println("======");
			response.sendRedirect("/web_test/login/login.jsp");
		}else {
			String path=request.getRequestURI();
			path=path.substring(path.lastIndexOf("/"), path.indexOf("."));
			if ("/showByPage".equals(path)) {
				//默认访问第一页
				int pageNum=1;
				//每页显示八条数据
				int onePageAccount=8;
				String n=request.getParameter("pageNum");
				String u_id=user.getId()+"";
				if(n!=null){
					pageNum=Integer.parseInt(n);
				}
				Map<String, String[]> map=request.getParameterMap();
				Cus_msg cus_msg=new Cus_msg();
				
				Cus_msgService Service=new Cus_msgService();
				try {
					BeanUtils.populate(cus_msg, map);
					cus_msg.setU_id(Integer.parseInt(u_id));
					System.out.println(cus_msg.getArea());
					PageCus_msg pageCus_msg=Service.selectPage(pageNum,onePageAccount,cus_msg);
					System.out.println(pageCus_msg.toString());
					request.setAttribute("pageCus_msg", pageCus_msg);
					request.getRequestDispatcher("/msg/showByPage.jsp").forward(request, response);
				} catch (SQLException | IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}else if ("/delete".equals(path)) {
				String referer=request.getHeader("referer");
				System.out.println(referer);
				String[] ids = request.getParameterValues("ck");
				if (ids != null) {
					Cus_msgService Service=new Cus_msgService();
					try {
						Service.delete(ids);
						/*if(referer.contains("selectall.do")){
							response.sendRedirect("web_test/selectall.do");
						}else if(referer.contains("showByPage.do")){
							response.sendRedirect("web_test/showByPage.do");
						}*/
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(referer.contains("selectall.do")){
					response.sendRedirect("web_test/selectall.do");
				}else if(referer.contains("showByPage.do")){
					response.sendRedirect("web_test/showByPage.do");
				}
				/*else {
					response.sendRedirect("web_test/showByPage.do");
				}*/
			}else if ("/select".equals(path)) {
				String id=request.getParameter("id");
				Cus_msgService Service=new Cus_msgService();
				try {
					Cus_msg cus_msg=Service.select(id);
					request.setAttribute("cus_msg", cus_msg);
					request.getRequestDispatcher("/msg/showOne.jsp").forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else if ("/add".equals(path)){
				Map<String, String[]> map=request.getParameterMap();
				Cus_msg cus_msg=new Cus_msg();
				System.out.println("====");
				try {
					BeanUtils.populate(cus_msg, map);
					cus_msg.setU_id(user.getId());
					Cus_msgService Service=new Cus_msgService();
					Service.add(cus_msg);
					response.sendRedirect("web_test/showByPage.do");
				} catch (IllegalAccessException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if ("/update".equals(path)){
				String referer=request.getHeader("referer");
				System.out.println(referer);
				Map<String, String[]> map=request.getParameterMap();
				Cus_msg cus_msg=new Cus_msg();
				int id=Integer.parseInt(request.getParameter("id"));
				System.out.println(id);
				try {
					BeanUtils.populate(cus_msg, map);
					cus_msg.setId(id);
					Cus_msgService Service=new Cus_msgService();
					Service.update(cus_msg);
					if(referer.contains("&")){
						response.sendRedirect("web_test/selectall.do");
					}else {
						response.sendRedirect("web_test/showByPage.do");
					}
					//System.out.println(cus_msg.toString());
				} catch (IllegalAccessException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if ("/selectall".equals(path)){
				System.out.println("======");
				//默认访问第一页
				int pageNum=1;
				//每页显示八条数据
				int onePageAccount=8;
				String n=request.getParameter("pageNum");
				if(n!=null){
					pageNum=Integer.parseInt(n);
				}
				Map<String, String[]> map=request.getParameterMap();
				Cus_msg cus_msg=new Cus_msg();
				
				Cus_msgService Service=new Cus_msgService();
				try {
					BeanUtils.populate(cus_msg, map);
					PageCus_msg pageCus_msg=Service.selectall(pageNum,onePageAccount,cus_msg);
					UserService userService=new UserService();
					List<User> list2=userService.select();
					System.out.println(pageCus_msg.toString());
					pageCus_msg.setList2(list2);
					request.setAttribute("pageCus_msg", pageCus_msg);
					request.getRequestDispatcher("/msg/showAll.jsp").forward(request, response);
				} catch (SQLException | IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
