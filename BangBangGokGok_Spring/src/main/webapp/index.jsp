<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>관리자 페이지</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>
    <script src='main.js'></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body>
    <br />
    <div class="container">
        <div class="row">
            <div class="col">
                <h1>관리자 페이지</h1>
            </div>
        </div>
        <hr><br>
        <a href="/userJoin"><button type="button" class="btn btn-primary">관리자 계정 생성</button></a>
        <a href="/admin/board.do"><button type="button" class="btn btn-primary">게시판 바로가기</button></a>
    </div>
</body>

</html>