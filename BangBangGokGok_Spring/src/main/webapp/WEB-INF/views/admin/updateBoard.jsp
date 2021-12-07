<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>TEMP GET BOARD</title>
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
	<h1>임시 게시글 수정</h1><br><hr><br>
	<form action="updateBoard.do?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
		<input type="hidden" name="articleNo" value="${ index }"/>
		작성자 <input type="text" name="userId" value="${ TmpBoard.userId }">
		게시글 작성 시간 <input type="text" id="date" name="writeDate"><br><br>
		제목 <input type="text" name="articleTitle" value="${ TmpBoard.articleTitle }"/>
		파일 <input type="file" name="uploadFile" value="업로드"/><br><br>  
		내용 <textarea id="board_content" name="articleContent" cols="70" rows="10">${ TmpBoard.articleContent }</textarea><br>
		<input type="submit" value="적용">
		<a href="getBoard.do?index=${ index }"><input type="button" value="취소"></a>
	</form>
</body>
</html>