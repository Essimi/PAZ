package kr.or.ddit.chat.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.chat.dao.ChattingDAO;
import kr.or.ddit.vo.ChatRoomVO;

@Service
public class ChatroomSelectServiceImpl {
	
	@Inject
	private ChattingDAO dao;
	
	public ChatRoomVO selectChatroomForConstructor(String chatroomCode) {
		
		ChatRoomVO data = new ChatRoomVO();
		data = dao.selectChatroomForConstructor(chatroomCode);
		
		return data;
		
	}

}
