<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>TEMP BOARD WRITE</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){
		now();
	});
	
	function now() {
		let time = new Date();
		let now = time.getFullYear() + 
		"-" + (time.getMonth()+1) +
		"-" + time.getDate() +
		" " + ("00" + time.getHours()).slice(-2) + 
		":" + ("00" + time.getMinutes()).slice(-2) + 
		":" + ("00" + time.getSeconds()).slice(-2);
		
		$("#date").val(now);
	}
</script>

</head>
<body>
	<h1>임시 게시글 쓰기</h1><br><hr><br>
	<form action="insertBoard.do?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
		작성자 <input type="text" name="transferWriterId" value="${ username }">
		게시글 작성 시간 <input type="text" id="date" name="transferDate"><br><br>
		제목 <input type="text" name="transferName" value="제목"/>
		파일 <input type="file" name="uploadFile" value="업로드"/> <br><br>
		내용 <textarea id="board_content" name="transferContent" cols="70" rows="10">내용</textarea><br>
		<input type="submit" value="게시글 쓰기">
		<a href="board.do"><input type="button" value="취소"></a>
	</form>
		
	 
</body>
</html>