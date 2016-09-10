<%@page import="com.qgq.web.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	User user=(User)session.getAttribute("user");
	if(user==null){
		%>
		<jsp:forward page="/login/login.jsp"></jsp:forward>
	<%
	}
%>
