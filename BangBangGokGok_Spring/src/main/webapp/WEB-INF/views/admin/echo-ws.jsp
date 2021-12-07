<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>임시 ECHO 페이지</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	$(document).ready(function() {
		console.log("dot1");
		$("#sendBtn").click(function() {
			sendMessage();
		})
	});
	
	var wsocket;
	
	function sendMessage() {
		wsocket = new WebSocket("ws://localhost:8999/echo-ws.do");
		wsocket.onmessage = onMessage;
		wsocket.onclose = onClose;
		console.log("dot12");
		wsocket.onopen = function() {
			console.log("dot22");
			wsocket.send( $("#message").val() );
		};
	}
	
	function onMessage(evt) {
		var data = evt.data;
		alert("서버에서 데이터 받음 : "+data);
		wsocket.close();
	}
	
	function onClose(evt) {
		alert("연결 끊김");
	}
	
</script>
</head>
<body>
	<input type="text" id="message">
	<input type="button" id="sendBtn" value="전송"/>
</body>
</html>