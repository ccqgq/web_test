<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/filter.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
</head>
<body>

<ul class="nav nav-list">
  <li class="active"><a href="#"><i class="icon-home icon-white"></i> 首页</a></li>
  <li><a href="${pageContext.request.contextPath }/showByPage.do" target="rigth"><i class="icon-book"></i> 我管理的</a></li>
  <li><a href="${pageContext.request.contextPath }/selectall.do" target="rigth"><i class="icon-pencil"></i> 所有的客户</a></li>
   <li><a href="logout.jsp" target="_top"><i class="icon-pencil"></i> 退出</a></li>
</ul>


</body>
</html>