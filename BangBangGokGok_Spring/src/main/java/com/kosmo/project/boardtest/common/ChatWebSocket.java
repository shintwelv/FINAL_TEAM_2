package com.kosmo.project.boardtest.common;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatWebSocket extends TextWebSocketHandler{

	private Map<String, WebSocketSession> users = new ConcurrentHashMap<String, WebSocketSession>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log(session.getId() + " 연결 성공");
		users.put(session.getId(), session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		log(session.getId() + "로부터 메시지 수신 : " + message.getPayload());
		for(WebSocketSession wsock : users.values()) {
			wsock.sendMessage(message);
			log(wsock.getId() + "에 메시지 발송 : " + message.getPayload());
		}
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		log(session.getId() + "예외 발생 : " + exception.getMessage());
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log(session.getId() + " 연결 종료");
		users.remove(session.getId());
	}
	
	private void log(String logmsg) {
		System.out.println(new Date() + " : " + logmsg);
	}
}
