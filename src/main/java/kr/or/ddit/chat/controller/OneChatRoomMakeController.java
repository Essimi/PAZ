package kr.or.ddit.chat.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.chat.service.ChattingService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.ChatRoomVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class OneChatRoomMakeController {
	
	@Inject
	private ChattingService service;
	
	@RequestMapping(value="project/{pCode}/chat/oneMakeChat.do")
	@ResponseBody
	public Map<String, Object> oneChatMake(
			
			@RequestParam(value="yourId", required=true) String yourId
			, @RequestParam(value="yourNickname", required=true) String yourNickname
			, @AuthenticationPrincipal(expression="authMember") MemberVO authMember
			, Model model
			, HttpSession session
			
			) {
		
		// 필요한 정보를 저장하는 chatVO 생성
		ChatRoomVO chat = new ChatRoomVO();
		String chatroomCode = null;
		
		Map<String, Object> resultMap = new HashMap<>();
		
		// 세션에서 프로젝트 코드를 가져온다.
		ProjectVO project = (ProjectVO) session.getAttribute("project");
		String pCode = project.getpCode();
		
		// 나의 아이디와 닉네임을 가져온다.
		String myId = authMember.getMemId();
		String myNickname = authMember.getMemNickname();
		
		// 나의 아이디와 상대방의 아이디를 저장할 List 생성
		List<String> memberList = new ArrayList<String>();
		
		memberList.add(myId);
		
		// 채팅방의 정보를 조회한다.
		// 만약 채팅방이 존재한다면 그 채팅방의 정보를 저장하는 chatVO
		ChatRoomVO chatInfo = new ChatRoomVO();
		
		// 채팅방 존재 여부 조회를 위한 파라미터 정보가 저장되는 Map
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("pCode", pCode);
		
		// 만약 나의 아이디와 상대방의 아이디가 동일하다면 나를 대상으로 하는 채팅으로 판단한다.
		// 채팅방의 존재 여부를 조회한다.
		if (!myId.equals(yourId)) {
			
			memberList.add(yourId);
			
			data.put("myId", myId);
			data.put("yourId", yourId);
			chatInfo = service.selectChatRoomCheck(data);
			
		} else {
			
			// 나 혼자 참여하는 채팅일 경우
			data.put("myId", myId);
			chatInfo = service.selectChatRoomOneCheck(data);
			
		}
		
		log.info("멤버리스트 조회 {}", memberList);
		
		if (chatInfo == null) {
			
			chatroomCode = service.selectChatroomCode();
			
			// 대화방의 코드를 저장
			chat.setChatroomCode(chatroomCode);
			
			log.info("챗룸코드를 잘 만들어오는지 {}", chatroomCode);
			
			// 대화방의 채팅방 이름은 나의 닉네임과 상대방의 닉네임으로 만들어 진다.
			
			if (!myId.equals(yourId)) {
				chat.setChatroomTitle(myNickname + "님과 " + yourNickname + "님의 대화");
			} else {
				chat.setChatroomTitle(myNickname + "♥");
			}
			
			chat.setpCode(pCode);
			
			ServiceResult result = service.insertChatRoom(chat, memberList);
			
			resultMap.put("result", result);
			resultMap.put("chatroomCode", chatroomCode);

			log.info("채팅방 등록 시 결과값 확인 {}",result);
			log.info("chatroomCode 확인 {}",chatroomCode);
			
		} else {
			
			resultMap.put("result", "OK");
			resultMap.put("chatroomCode", chatInfo.getChatroomCode());
			
		}
		
		return resultMap;
		
	}

}
