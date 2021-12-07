<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>TEMP BOARD</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<style>
.pagination {
	text-align: center;
    display: block;
}


.pagination > li{
    display: inline-block;
    float: none;
}
</style>
<body>
	<h1>임시 게시판 페이지</h1><br><hr><br>
	<a href="insertBoard.do"><button>게시글 쓰기</button></a>
	<a href="/admin/adminAa/dashboard.do"><button>서버 리소스 보러가기</button></a>
	<a href="/admin/adminSa/accountEnableSet.do"><button>관리자 계정 활성화 설정</button></a>	
	<a href="chat-ws"><button>에코 채팅 테스트</button></a>	
	
	<form id="logout" action="/logout" method="post">
		<br><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="submit" value="로그아웃"/>
	</form>

	<div class="container">
	  <table class="table">
	    <thead>
	      <tr>
	        <th>순번</th>
	        <th>제목</th>
	        <th>작성자</th>
	        <th>작성일자</th>
	      </tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${ tbsList }" var="Object" begin="0" end="${ tbsList.size() }" varStatus="status">
	    		<tr style = "cursor:pointer;" onClick = "location.href='getBoard.do?index='+${Object.articleNo}">
    				<td>${Object.articleNo}</td>
    				<td>${Object.articleTitle}</td>
    				<td>${Object.userId}</td>
    				<td>${Object.writeDate}</td>
	    		</tr>
	    	</c:forEach>
	    </tbody>
	  </table>
	  <ul class="pagination">
	    <c:if test="${hasPrevious}">
	  		<li class="page-item"><a class="page_box_sub page-link" href="/admin/previous.do?page=${ page }">Previous</a></li>
	  	</c:if>
	  	<c:forEach begin="${ pageRange.bottom }" end="${pageRange.top}" step="1" var="index">
			<li class="page-item"><a class="page-link"href="/admin/board.do?page=${index}">${index}</a></li>
			<!--
 			<li class="page-item"><input class="pNum page-link" type="button" value="${status.count}"/></li>  
			-->
	 	</c:forEach>
	 	<c:if test="${hasNext}">
	 		<li class="page-item"><a class="page-link" href="/admin/next.do?page=${ page }">Next</a></li>
	 	</c:if>
	 </ul>
	</div>
	<form action="boardSearch.do" method="POST">
		<select name="searchCondition">
			<option value="writer">작성자</option>
			<option value="title">제목</option>
			<option value="content">내용</option>
		</select>
		<input type="text" name="searchText"/>
		<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }"/>
		<input type="submit" value="찾기"/>
	</form>
</body>
</html>