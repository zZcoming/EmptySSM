<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
<title><sitemesh:write property='title' /></title>
<sitemesh:write property='head' />
</head>
<body>
	<header>由SiteMesh拼接的header</header>
	<shiro:user>
		<h3>欢迎[<shiro:principal/>]登录</h3>
	</shiro:user>
	<%-- <c:if test="${not empty roles}">
		该用户的角色为：
		<c:forEach var="role_item" items="roles">
			${role_item}  
		</c:forEach>
	</c:if>
	<c:if test="${not empty permissions}">
		该用户的权限为：
		<c:forEach var="permissions_item" items="permissions">
			${permissions_item}  
		</c:forEach>
	</c:if> --%>
	<hr />
	<sitemesh:write property='body' />
	<hr />	
	<footer>由SiteMesh拼接的footer</footer>
</body>
</html>