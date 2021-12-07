<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  	
  	<link href="//cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.4.0/css/bootstrap4-toggle.min.css" rel="stylesheet">  
	<script src="//cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.4.0/js/bootstrap4-toggle.min.js"></script>
	
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<style>	
	tbody > tr > td:first-child > input{
		border:none;
		border-right:0px; 
		border-top:0px; 
		boder-left:0px; 
		boder-bottom:0px; 
		background-color: white;	
	}
</style>
<script>
	function test() {
		var arrData = new Array();
		console.log("node count : "+$("tbody").children().length);
		
		for(var i=1; i<=$("tbody").children().length; i++) {
			var tmpData = new Object();
			tmpData.username = $("#Record_"+i).children().eq(0).find("input").attr("value");
			console.log($("#Record_"+i).children().eq(0).find("input").attr("value"));
			if($("#Record_"+i).children().eq(3).find("input").is(":checked")) {
				tmpData.enabled = "true";
			}
			if(!$("#Record_"+i).children().eq(3).find("input").is(":checked")) {
				tmpData.enabled = "false";
			}
			arrData.push(tmpData);
		}
		
		$.ajax({
			type : "POST",
			url : "accountEnableInfo.do",
            data: JSON.stringify(arrData), //Array를 JSON string형태로 변환
            contentType: "application/json",
            beforeSend : function(xhr)
            {   
                xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
            },
            success : function() {
            	location.reload();
            	alert("권한 변경 완료");
			},
			error : function(request, error) {
				console.log("code : "+request.status+"\n"+"message : "+request.responseText+"\n"+"error : "+error);
			}
		})
	};
</script>
</head>
<body>
	<div class="container">
		<br>
		<h1>관리자 계정 설정</h1>
		<table class="table">
		  <thead>
		    <tr>
		      <th>계정명</th>
		      <th>패스워드</th>
		      <th>권한레벨</th>
		      <th>활성화 여부</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach var="index" begin="1" end="${ UsersList.size() }">
		  		<tr id="Record_${ index }">
		 				<td><input type="text" name="userId" value="${UsersList[index-1].userId}" disabled/></td>
		 				<td>${UsersList[index-1].userPw}</td>
		 				<td>${ManagerList[index-1].adminLevel}</td>
				<c:if test="${UsersList[index-1].enabled == 'true'}">
					<td><input type="checkbox" checked data-toggle="toggle" data-onstyle="success"></td>
				</c:if>
				<c:if test="${UsersList[index-1].enabled != 'true'}">
					<td><input type="checkbox" data-toggle="toggle" data-onstyle="success"></td>
				</c:if>
		  		</tr>
		  	</c:forEach>
		  </tbody>
		</table>
		<input type="submit" class="btn btn-primary" id="ManagerInfoSend" onclick="test()" value="적용">
		<a href="/admin/board.do"><button class="btn btn-primary">취소</button></a><br><br>
	</div>
</body>
</html>



