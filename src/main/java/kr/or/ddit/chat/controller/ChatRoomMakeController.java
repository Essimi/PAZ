package kr.or.ddit.chat.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.chat.service.ChattingService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.ChatRoomVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ChatRoomMakeController {
	
	@Inject
	private ChattingService service;
	
	@RequestMapping(value="project/{pCode}/chat/makeChat.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> chatMake(
			@RequestParam(value="memberList[]", required=true)List<String> memberList
			, @RequestParam(value="chatTitle", required=true) String chatTitle
			, @AuthenticationPrincipal(expression="authMember") MemberVO authMember
			, Model model
			, HttpSession session
			
			) {
		
		// chatVO에 정보를 담아 서비스 단으로 전달한다.
		
		ChatRoomVO chat = new ChatRoomVO();
		
		// 대화방의 코드 생성
		String chatroomCode = service.selectChatroomCode();
		
		// 대화방의 코드를 저장
		chat.setChatroomCode(chatroomCode);
		
		// memberList에 나의 아이디를 포함 시킨다.
		memberList.add(authMember.getMemId());
		
		// 세션에서 프로젝트 코드를 가져온다.
		ProjectVO project = (ProjectVO) session.getAttribute("project");
		String pCode = project.getpCode();
		
		log.info("챗룸코드를 잘 만들어오는지 {}", chatroomCode);
		
		chat.setChatroomTitle(chatTitle);
		chat.setpCode(pCode);
		
		ServiceResult result = service.insertChatRoom(chat, memberList);
		
		log.info("결과값 확인 {}",result);
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("result", result);
		map.put("chatroomCode", chatroomCode);
		
		return map;
	}

}
