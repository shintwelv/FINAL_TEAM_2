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
</head>
<body>
	<div class="container">
        <br>
        <div class="row">
            <h1>인수인계 확인</h1>
        </div>
        <hr>
        <form action="#">
            <div class="row mb-3">
                <div class="col-6">
                    <label for="userId" class="form-label">작성자</label>
                    <input type="text" name="userId" value="${ TmpBoard.userId }" id="userId" class="form-control">
                </div>
                <div class="col-6">
                    <label for="writeDate" class="form-label">작성시간</label>
                    <input type="text" id="date" name="writeDate" class="form-control" id="writeDate" value="${ TmpBoard.writeDate }">
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
                    <label for="uploadFile" class="form-label">업로드된 파일</label>
                    <br>
                    <a href="/admin/download?fileName=${ TmpBoard.articleImage }">${ TmpBoard.articleImage }</a>
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
                <div class="col-12">
                    <a href="/admin/board.do"><input type="button" value="돌아가기" class="btn btn-primary"></a>
                    <a href="/admin/updateBoard.do?index=${ index }"><button type="button" class="btn btn-primary">수정</button></a>
                    <a href="/admin/deleteBoard.do?index=${ index }"><button type="button" class="btn btn-primary">삭제</button></a>
                </div>
            </div>
        </form>
    </div>
</body>
</html>