<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/bootstrap.min.css">
</head>
<body>
<div style="height: 50px;"></div>
	
	 <div class="container">
			<h1 class="page-header"> 用户登录</h1>
			<h4>${ereor }</h4>
			<form class="form-horizontal" action="${pageContext.request.contextPath }/login" method="post">
				<div class="form-group">
					<div class="col-md-5">
						<input type="text" class="form-control" name="loginName" placeholder="用户名"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-5">
						<input type="password" class="form-control"  name="loginPassword" placeholder="密码"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-5">
						<button class="btn btn-primary"> 登    录</button>
					</div>
				</div>
			</form>
		</div>
	
		<div style="height: 1500px;"></div>
</body>
</html>