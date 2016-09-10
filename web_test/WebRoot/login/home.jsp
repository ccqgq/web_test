<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/filter.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<frameset rows="15%,*,10%">
	<frame src="top.jsp" noresize="noresize">
	<frameset cols="15%,*">
		<frame src="left.jsp" name="left" noresize="noresize">
		<frame src="right.jsp" name="rigth" noresize="noresize">
	</frameset>
	<frame src="foot.jsp" name="foot">
</frameset>
</html>