<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/user/login" method="post">
	username:<input type="text" name="username" value="${user.username }"/><br/>
	password:<input type="password" name="password"><br/>
	<input type="submit" value="login"/>
	<font color="red">${errorMsg}</font>
	<font color="red">${msg}</font>
<hr>
用zhangsan 1234登录，拥有admin和teacher角色、user:*和student:*权限，可以查看和保存<br>
用lisi 12345登录，拥有teacher角色、student:*权限，只能查看
</form>
</body>
</html>