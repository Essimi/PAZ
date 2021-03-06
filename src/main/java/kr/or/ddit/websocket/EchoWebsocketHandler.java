package kr.or.ddit.websocket;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.chat.service.ChatroomSelectServiceImpl;
import kr.or.ddit.vo.ChatMemberVO;
import kr.or.ddit.vo.ChatMessageVO;
import kr.or.ddit.vo.ChatRoomVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class EchoWebsocketHandler extends TextWebSocketHandler {

	@Inject
	private ChatroomSelectServiceImpl service;

	@Resource(name = "roomList")
	private Map<String, ChatRoomVO> ChatroomList;

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {

		log.info("추가되는 session 웹소켓 주소 {}", session.getUri());

		String url = session.getUri().toString();
		String[] arr = url.split("/");

		String arrChatroomCode = arr[arr.length - 2];

		log.info("잘라오는 채팅룸 코드 {}", arrChatroomCode);

		// String pCode, String chatroomTitle, String chatroomDate
		ChatRoomVO data = new ChatRoomVO();

		data = service.selectChatroomForConstructor(arrChatroomCode);

		String chatroomCode = arrChatroomCode;
		String pCode = data.getpCode();
		String chatroomTitle = data.getChatroomTitle();
		String chatroomDate = data.getChatroomDate();

		if (ChatroomList.containsKey(arrChatroomCode)) {
			ChatroomList.get(arrChatroomCode).enterChatroom(session);
		} else {
			ChatRoomVO chatRoomVO = new ChatRoomVO(chatroomCode, pCode, chatroomTitle, chatroomDate);
			ChatroomList.put(chatroomCode, chatRoomVO);

			log.info("ChatroomList.get(chatroomCode) {}", ChatroomList.get(chatroomCode).getChatroomTitle());
			log.info("ChatroomList.get(chatroomCode) {}", ChatroomList.get(chatroomCode).getChatroomCode());

			ChatroomList.get(chatroomCode).enterChatroom(session);
		}
		
		ChatRoomVO chatRoomVO = ChatroomList.get(arrChatroomCode);
		
		for (ChatMemberVO member : chatRoomVO.getMemberSet()) {

			WebSocketSession tmp = null;
			tmp = member.getSession();

			Queue<ChatMessageVO> messageList = chatRoomVO.getMessageList();

			log.debug("Queue<ChatMessageVO> : {}", messageList);

			for (ChatMessageVO chat : messageList) {

				Map<String, Object> oldMessage = new HashMap<>();

				// messageVO를 JOSN 형태로 변환한다.
				oldMessage.put("memId", chat.getSender().getMemId());
				oldMessage.put("memNickname", chat.getSender().getMemNickname());
				oldMessage.put("saveName", chat.getSender().getSaveName());
				oldMessage.put("chatTime", chat.getChatTime());
				oldMessage.put("content", chat.getContent());

				String oldJsonMsg = new ObjectMapper().writeValueAsString(oldMessage);

				tmp.sendMessage(new TextMessage(oldJsonMsg));

			}

		}
		

	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		
		String url = session.getUri().toString();
		String[] arr = url.split("/");

		String chatroomCode = arr[arr.length - 2];
		
		ChatroomList.get(chatroomCode).outChatroom(session);

	}

	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		log.error("연결 에러 발생", exception);
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {

		ChatMessageVO messageVO = new ChatMessageVO();

		// 현재의 시간 정보
		Date chatTime = new Date();
		
		SimpleDateFormat pattern = new SimpleDateFormat("yyyy년 MM월 dd일 aa hh시 mm분 ss초"); 
		String stringChatTime = pattern.format(chatTime);

		// 실제 전달 된 메시지를 가지고 있다.
		String content = (String) message.getPayload();

		messageVO.enterSender(session);
		messageVO.setChatTime(stringChatTime);
		messageVO.setContent(content);

		Map<String, Object> messageMap = new HashMap<>();

		// messageVO를 json 형태로 변환한다.
		messageMap.put("memId", messageVO.getSender().getMemId());
		messageMap.put("memNickname", messageVO.getSender().getMemNickname());
		messageMap.put("saveName", messageVO.getSender().getSaveName());
		messageMap.put("chatTime", messageVO.getChatTime());
		messageMap.put("content", messageVO.getContent());

		String jsonMsg = new ObjectMapper().writeValueAsString(messageMap);

		String url = session.getUri().toString();
		String[] arr = url.split("/");

		String arrChatroomCode = arr[arr.length - 2];

		ChatRoomVO chatRoomVO = null;

		if (ChatroomList.containsKey(arrChatroomCode)) {
			chatRoomVO = ChatroomList.get(arrChatroomCode);
		}

		ChatroomList.get(arrChatroomCode).setMessageList(messageVO);
		
		for (ChatMemberVO member : chatRoomVO.getMemberSet()) {
			
			WebSocketSession tmp = null;
			tmp = member.getSession();
			tmp.sendMessage(new TextMessage(jsonMsg));
			
		}

	}

}
