<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
</head>
<body>
	<h1>임시 로그인 페이지</h1>
	<hr>
	<c:if test="${ loginFaile == 'true' }">
		아이디 또는 패스워드 정보를 확인해 주세요.
	</c:if>
	<form action="/login" method="post">
		<input type="text" name="username" value="admin_sa">
		<input type="text" name="password" value="admin_sa">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="submit" value="로그인">
	</form>
</body>
</html>