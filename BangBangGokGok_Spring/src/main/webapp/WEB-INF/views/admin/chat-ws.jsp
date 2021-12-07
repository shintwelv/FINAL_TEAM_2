<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script>
	var wsocket;
	
	function connect() {
		wsocket = new WebSocket("ws://localhost:8999/chat-ws.do");
		wsocket.onopen = onOpen;
		wsocket.onmessage = onMessage;
		wsocket.onclose = onClose;
	}
	
	function disconnect() {
		wsocket.close();
	}
	
	function onOpen(evt) {
		appendMessage("연결되었습니다.");
	}
	
	function onMessage(evt) {
		var data = evt.data;
		console.log("original data : "+data)
		if(data.substring(0, 4) == "msg:") {
			if(data.substring(5, $("#nickname").val().length+5) == $("#nickname").val()) {
				appendMessage("<strong id='myStr'>" + data.substring(4) + "</strong>");
			}
			if(data.substring(5, $("#nickname").val().length+5) != $("#nickname").val()) {
				appendMessage(data.substring(4));
			}
		}
	}
	
	function onClose(evt) {
		appendMessage("연결을 끊었습니다.");
	}
	
	function send() {
		var nickname = $("#nickname").val();
		var msg = $("#message").val();
		wsocket.send("msg:[" + nickname + "] > " + msg);
		$("#message").val("");
	}
	
	function appendMessage(msg) {
		$("#chatMessageArea").append(msg+"<br>");
		var chatAreaHeight = $("#chatArea").height();
		var maxScroll = $("#chatMessageArea").height() - chatAreaHeight;
		$("#chatArea").scrollTop(maxScroll);
	}
	
	$(document).ready(function() {
		$("#message").keypress(function(event) {
			var keycode = (event.keyCode ? event.keyCode : event.witch);
			if(keycode == '13') {
				send();
			}
			event.stopPropagation();
		});
		$("#sendBtn").click(function() { send(); });
		$("#enterBtn").click(function() { connect(); });
		$("#exitBtn").click(function() { disconnect(); });
	})
	
</script>
<style>
	#chatArea {
	width : 400px;
	height : 100px;
	}
	
	#myStr {
		float: right;
	}
</style>
</head>
<body>
	<div class="container">
        <br>
        <div class="row">
            <h1>관리자 단체 채팅</h1>
        </div>
        <hr>
        <div class="row">
            <a href="/admin/board.do"><button class="btn btn-primary">대시보드</button></a><br><br>
            <input type="hidden" id="nickname" value="<sec:authentication property="name"/>">
        </div>

        <h1>채팅</h1>
        <input type="text" id="message">
        <input type="button" id="sendBtn" value="전송" class="btn btn-primary"><br><br>

        <div id="chatArea" style="overflow-y: auto; border: 1px solid black;">
            <div id="chatMessageArea">
            </div>
        </div>
        <div class="row mt-3">
        	<div class="col-1">
		        <input type="button" id="enterBtn" value="입장" class="btn btn-primary">
        	</div>
        	<div class="col-1">
		        <input type="button" id="exitBtn" value="나가기" class="btn btn-danger">
        	</div>
        </div>
    </div>
</body>
</html>