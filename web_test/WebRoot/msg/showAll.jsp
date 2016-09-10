<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/web_test/css/bootstrap.min.css">
</head>
<script type="text/javascript">
	function cheng() {
		var id=document.getElementById("c");
		var flage=id.checked;
		var cks=document.getElementsByName("ck");	
		for(var i=0;i<cks.length;i++){
			cks[i].checked=flage;
		}
	}
</script>
<body>
	<form action="${pageContext.request.contextPath }/selectall.do" method="post" >
		<table style="width: 60%" align="center"> 
			<tr>
				<td>客户编号:</td>
				<td><input type="text" name="cus_id"></td>
				<td>
					<label for="level">客户级别</label>
				    <select name="level" id="level">
						<option value="">请选择</option>				    
				      <option value="A级">A级</option>
				      <option value="B级">B级</option>
				      <option value="C级">C级</option>
				      <option value="D级">D级</option>
				    </select><br />
				</td>
				<td><label for="area">客户地域</label></td>
				<td><input type="text" name="area" id="area" placeholder="西安"/><br /></td>
				<td><button type="submit" class="btn btn-default"">高级查询</button></td>
			</tr>
		</table>
	</form>
	<form action="${pageContext.request.contextPath}/delete.do" method="post">
	<table class="table table-striped" style="width: 60%" align="center">
		<tr>
			<td colspan="6"><h4><a href="${pageContext.request.contextPath }/msg/add.jsp?">添加客户</a></h4></td>
			<td><button type="submit" class="btn btn-default" onclick="return confirm('是否删除选中的信息');">删除选中</button></td>
		</tr>
		<tr>
			<td><input type="checkbox" id="c" onclick="cheng()"></td>
			<td><p>客户编号</p></td>
			<td>客户名称</td>
			<td>客户经理</td>
			<td>客户等级</td>
			<td>客户地域</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${pageCus_msg.list }" var="l">
			<tr>
			<td><input type="checkbox" name="ck" value="${l.id }"></td>
			<td>${l.cus_id }</td>
			<td>${l.name }</td>
			<c:forEach items="${pageCus_msg.list2 }" var="u">
				<c:if test="${l.u_id eq u.id }">
					<td>${u.username }</td>	
				</c:if>
			</c:forEach>
			<td>${l.level }</td>
			<td>${l.area }</td>
			<td><a href="${pageContext.request.contextPath }/select.do?id=${l.id }&">编辑</a></td>
		</tr>
		</c:forEach>
		
		<tr>
			<td colspan="7" align="center">
				<a href="${pageContext.request.contextPath }/selectall.do?pageNum=1">首页</a>
				<c:choose >
					<c:when test="${pageCus_msg.pageNum ne 1 }">
						<a href="${pageContext.request.contextPath }/selectall.do?pageNum=${pageCus_msg.pageNum-1}">上一页</a>
					</c:when>
					<c:otherwise>
						<a>上一页</a>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${pageCus_msg.pageNum ge  pageCus_msg.pageSum}">
						<a>下一页</a>
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath }/selectall.do?pageNum=${pageCus_msg.pageNum+1}">下一页</a>
					</c:otherwise>
				</c:choose>
				<a href="${pageContext.request.contextPath }/selectall.do?pageNum=${pageCus_msg.pageSum}">尾页</a>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>