<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>관리자 페이지</title>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
	<div class="container">
        <br>
        <div class="row">
            <h1>인수인계 수정</h1>
        </div>
        <hr>
        <form action="updateBoard.do?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
        <input type="hidden" name="articleCode" value="transfer" />
        <input type="hidden" name="articleNo" value="${ index }"/>
            <div class="row mb-3">
                <div class="col-6">
                    <label for="userId" class="form-label">작성자</label>
                    <input type="text" name="userId" value="${ TmpBoard.userId }" id="userId" class="form-control">
                </div>
                <div class="col-6">
                    <label for="writeDate" class="form-label">작성시간</label>
                    <input type="text" id="date" name="writeDate" class="form-control" id="writeDate">
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-12">
                    <label for="articleTitle" class="form-label">제목</label>
                    <input type="text" name="articleTitle" class="form-control" id="articleTitle" value="${ TmpBoard.articleTitle }"/>
                </div>
            </div>
           	<div class="row mb-3">
                <div class="col-12">
                    <label for="uploadFile" class="form-label">파일</label>
                    <input type="file" name="uploadFile" value="업로드" class="form-control" id="uploadFile" />
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-12">
                    <label for="articleContent" class="form-label">내용</label>
                </div>
            </div>
            <div class="row mb-3">
                <div class="col-12">
                    <textarea id="articleContent" name="articleContent" rows="10" class="form-control">${ TmpBoard.articleContent }</textarea>
                </div>
            </div>
            <div class="row">
                <div class="col-1">
                    <input type="submit" value="작성" class="btn btn-primary">
                </div>
                <div class="col-1">
                    <a href="board.do"><input type="button" value="취소" class="btn btn-primary"></a>
                </div>
            </div>
        </form>
    </div>
</body>
</html>