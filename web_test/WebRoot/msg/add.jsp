<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/filter.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>添加的客户信息</title>
  <style>
    from{
      display: block;
      width: 500px;
    }
    fieldset{
      padding:50px; 
      border-radius: 10px;
    }
    label{    
      width: 40%;
      text-align: right;
      display:inline-block;
      margin-right: 20px;
      margin-top: 10px;
      vertical-align: top;
      margin-bottom: 0px;
    }
    input,select{
      vertical-align: bottom;
    }
  </style>
</head>
<body>

<form action="${pageContext.request.contextPath}/add.do" method="post">

  <fieldset>
    <label for="id">客户编号</label>
    <input type="text" name="cus_id" id="id" /><br />
    <label for="name">客户姓名</label>
    <input type="text" name="name" id="name" placeholder="cc" /><br />
    <label for="level">客户级别</label>
    <select name="level" id="level">
      <option value="A级">A级</option>
      <option value="B级">B级</option>
      <option value="C级">C级</option>
      <option value="D级">D级</option>
    </select><br />
    <label for="area">所属部门</label>
    <input type="text" name="cus_dept" id="area" placeholder="行政部"/><br />
    <label for="area">客户地域</label>
    <input type="text" name="area" id="area" placeholder="西安"/><br />
    <label for="cus_industy">客户行业 </label>
    <input type="text" name="cus_industy" id="cus_industy" placeholder="IT"/><br />
    <label for="cus_type">客户性质</label>
    <input type="text" name="cus_type" id="cus_type" placeholder="互联网"/>
  	<input type="submit" value="提交">
  </fieldset>
</form>  
</body>
</html>