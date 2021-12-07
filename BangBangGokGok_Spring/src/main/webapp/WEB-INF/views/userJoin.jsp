<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>임시 회원 가입</title>
</head>
<body>
	<h1>임시 회원가입 페이지</h1>
	<hr>
	<form action="userJoin.do" method="post">
		아이디 : <input type="text" name="userId">
		비밀번호 : <input type="text" name="userPw">
		<input type="hidden" name="enabled" value="true"><br>
		<label for="sel1">권한 리스트 :</label>
		<select id="sel1" name="adminLevel">
			<option>A</option>
			<option>AA</option>
			<option>SA</option>
		</select><br>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>