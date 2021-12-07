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
    <div class="container">
        <br>
        <div class="row">
            <h1>관리자 계정 생성</h1>
        </div>
        <hr>
        <div class="row">
            <form action="userJoin.do" method="post">
                <input type="hidden" name="enabled" value="true">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <div class="mb-3">
                    <label for="userId" class="form-label">아이디</label>
                    <input type="text" class="form-control" name="userId" id="userId" required>
                </div>
                <div class="mb-3">
                    <label for="userPw" class="form-label">비밀번호</label>
                    <input type="password" class="form-control" name="userPw" id="userPw" required>
                </div>
                <div class="mb-3">
                    <label for="sel1" class="form-label">권한</label>
                    <select name="adminLevel" id="sel1" class="form-select">
                        <option value="A">A</option>
                        <option value="AA">AA</option>
                        <option value="SA">SA</option>
                    </select>
                </div>
                <button class="btn btn-primary" type="submit">회원가입</button>
                <a href="/index.jsp"><button class="btn btn-primary" type="button">돌아가기</button></a>
            </form>
        </div>
    </div>
</body>

</html>