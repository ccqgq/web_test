package com.qgq.web.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.qgq.web.service.UserService;
import com.qgq.web.vo.User;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Map<String, String[]> map=request.getParameterMap();
		User user=new User();
		try {
			BeanUtils.populate(user, map);
			System.out.println(user.getLoginName()+user.getLoginPassword());
			UserService service=new UserService();
			user=service.login(user);
			if(user!=null){
				request.getSession().setAttribute("user", user);
				response.sendRedirect("/web_test/login/home.jsp");
			}else {
				request.setAttribute("error", "用户名或密码错误！！");
				request.getRequestDispatcher("/login/login.jsp").forward(request, response);
			}
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
