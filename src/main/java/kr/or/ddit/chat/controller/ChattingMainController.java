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

import kr.or.ddit.chat.service.ChattingService;
import kr.or.ddit.vo.ChatRoomVO;
import kr.or.ddit.vo.MemberProfileVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ChattingMainController {
	
	@Inject
	private ChattingService service;
	
	@RequestMapping("project/{pCode}/chat/chatting.do")
	public String chattingMain(
			
			@AuthenticationPrincipal(expression="authMember") MemberVO authMember
			, Model model
			, HttpSession session
			
			) {
		
		// 세션에서 프로젝트 코드를 가져온다.
		ProjectVO project = (ProjectVO) session.getAttribute("project");
		String pCode = project.getpCode();
		
		Map<String, String> info = new HashMap<>();
		
		info.put("memId", authMember.getMemId());
		info.put("pCode", pCode);
		
		// 프로젝트의 멤버 정보에 대한 조회
		List<MemberProfileVO> memberList = new ArrayList<>();
		memberList = service.selectProjectMember(info);
		
		// 채팅방 정보에 대한 조회
		List<ChatRoomVO> chatRoomList = new ArrayList<>();
		chatRoomList = service.selectchatRoom(info);
		
		model.addAttribute("memberList",memberList);
		model.addAttribute("chatRoomList",chatRoomList); 
		
		return "chat/chattingMain";
		
	}
	
}