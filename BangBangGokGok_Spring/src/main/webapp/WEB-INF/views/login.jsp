<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h1>관리자 로그인</h1>
            <hr>
        </div>
        <c:if test="${ loginFaile == 'true' }">
            <div class="row">
                <div class="col">
                    <span>
                        아이디 또는 패스워드 정보를 확인해 주세요.
                    </span>
                </div>
            </div>
        </c:if>
        <form action="/login" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <div class="mb-3">
                <label for="userId" class="form-label">아이디</label>
                <input type="text" class="form-control" name="userId" id="userId" placeholder="ex. admin_sa" required>
            </div>
            <div class="mb-3">
                <label for="userPw" class="form-label">비밀번호</label>
                <input type="password" class="form-control" name="userPw" id="userPw" placeholder="ex. admin_sa"
                    required>
            </div>
            <button class="btn btn-primary" type="submit">로그인</button>
        </form>
    </div>
</body>

</html>