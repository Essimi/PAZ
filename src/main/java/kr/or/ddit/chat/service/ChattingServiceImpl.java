package kr.or.ddit.chat.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.chat.dao.ChattingDAO;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.ChatRoomVO;
import kr.or.ddit.vo.MemberProfileVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChattingServiceImpl implements ChattingService {
	
	@Inject
	private ChattingDAO dao;

	@Override
	public List<MemberProfileVO> selectProjectMember(Map<String, String> info) {
		
		List<MemberProfileVO> memberList = dao.selectProjectMember(info);
		return memberList;
		
	}

	@Override
	public MemberProfileVO selectMember(Map<String, String> info) {
		
		MemberProfileVO member = dao.selectMember(info);
		return member;
		
	}
	
	@Override
	public String selectChatroomCode() {
		
		String chatroomCode = dao.selectChatroomCode();
		return chatroomCode;
		
	}


	@Override
	public ServiceResult insertChatRoom(ChatRoomVO chat, List<String> memberList) {
		
		// 채팅방을 등록한다.
		int chatResult = dao.insertChatroom(chat);
		
		// 채팅방 멤버 등록을 위한 MAP 생성
		Map<String, Object> memList = new HashMap<String, Object>();
		
		memList.put("chatroomCode", chat.getChatroomCode());
		memList.put("memberList", memberList);
		
		// 채팅방의 멤버 정보를 등록한다.
		int memberResult = dao.insertChatMem(memList);
		
		ServiceResult result = null;
		
		if (chatResult > 0 && memberResult > 0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		
		return result;
	}

	@Override
	public List<ChatRoomVO> selectchatRoom(Map<String, String> info) {
		List<ChatRoomVO> chatRoomList = dao.selectchatRoom(info);
		return chatRoomList;
	}

	@Override
	public ChatRoomVO selectChatRoomCheck(Map<String, Object> data) {
		ChatRoomVO chatInfo = dao.selectChatRoomCheck(data);
		return chatInfo;
	}

	@Override
	public ChatRoomVO selectChatRoomOneCheck(Map<String, Object> data) {
		ChatRoomVO chatInfo = dao.selectChatRoomOneCheck(data);
		return chatInfo;
	}

	@Override
	public ServiceResult deleteChatMem(Map<String, String> info) {
		
		ServiceResult result = null;
		
		int resultCnt = dao.deleteChatMem(info);
		
		if (resultCnt > 0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		
		return result;
	}



}
