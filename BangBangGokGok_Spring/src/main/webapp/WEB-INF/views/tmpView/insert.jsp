<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert User</title>
</head>
<body>
	<h1>Insert user</h1>
	<form action="insertProcess.do" method="post" enctype="multipart/form-data">
		user_id : <input type="text" name="user_id"/> <br/>
		user_pw: <input type="text" name="user_pw"> <br/>
		user_name: <input type="text" name="user_name"> <br/>
		nickname: <input type="text" name="user_nickname"> <br/>
		email: <input type="email" name="user_email"> <br/>
		phone_number: <input type="text" name="phone_number"> <br/>
		user_basic_address: <input type="text" name="user_basic_address"> <br/>
		user_detail_address: <input type="text" name="user_detail_address"> <br/>
		profile_image: <input type="file" name="profile_image"> <br/>
		birth: <input type="date" name="birth"> <br/>
		gender: <input type="text" name="gender"> <br/>
		admin (Y/N): <input type="text" name="admin"> <br/>
		<input type="submit" value="등록">
	</form>
</body>
</html>