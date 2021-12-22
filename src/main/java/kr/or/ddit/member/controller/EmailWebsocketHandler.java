package kr.or.ddit.member.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EmailWebsocketHandler extends TextWebSocketHandler{
	private Map<String, WebSocketSession> connectionList;
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		if(connectionList == null) {
			connectionList = new HashMap<>();
		}
		String sessionId = session.getId();
		connectionList.put(sessionId, session);
		Map<String, String> messageMap = new HashMap<>();
		messageMap.put("id", sessionId);
		String jsonMsg = new ObjectMapper().writeValueAsString(messageMap);
		session.sendMessage(new TextMessage(jsonMsg));
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		Map<String, String> messageMap = new HashMap<>();
		messageMap.put("msg", "이메일 인증이 완료되었습니다.");
		String jsonMsg = new ObjectMapper().writeValueAsString(messageMap);
		
		String sessionId = message.getPayload();
		for(Entry<String, WebSocketSession> entry : connectionList.entrySet()) {
			if(sessionId.equals(entry.getKey())){
				WebSocketSession conSession = entry.getValue();
				conSession.sendMessage(new TextMessage(jsonMsg));
			}
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		String sessionId = session.getId();
		connectionList.remove(sessionId);
	}
}
