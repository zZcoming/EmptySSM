<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
	<a href="<%=request.getContextPath()%>/user/home">查看id=1的用户</a><br>
	<a href="<%=request.getContextPath()%>/user/save?username=Test&password123&age=23">
		新增一个用户，并查询。username=Test、age=23 </a><br>
</body>
</html>