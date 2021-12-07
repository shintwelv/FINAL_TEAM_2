<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>TEMP GET BOARD</title>
</head>
<body>
	<h1>임시 게시글 보기</h1><br><hr><br>
		작성자 <input type="text" name="transferWriterId" value="${ TmpBoard.userId }">
		게시글 작성 시간 <input type="text" name="transferDate" value="${ TmpBoard.writeDate }"><br><br>
		제목 <input type="text" name="transferName" value="${ TmpBoard.articleTitle }"/>
		업로드된 파일 : <a href="/admin/download?fileName=${ TmpBoard.articleImage }">${ TmpBoard.articleImage }</a><br><br>  
		내용 <textarea id="board_content" name="transferContent" cols="70" rows="10">${ TmpBoard.articleContent }</textarea><br>
		<a href="/admin/board.do"><button>돌아가기</button></a>
		<a href="/admin/updateBoard.do?index=${ index }"><button>수정</button></a>
		<a href="/admin/deleteBoard.do?index=${ index }"><button>삭제</button></a>
</body>
</html>