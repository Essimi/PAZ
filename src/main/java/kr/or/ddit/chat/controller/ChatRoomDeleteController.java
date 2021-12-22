package kr.or.ddit.chat.controller;

import java.util.HashMap;
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
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ChatRoomDeleteController {
	
	@Inject
	private ChattingService service;
	
	@RequestMapping(value="project/{pCode}/chat/chatDelete.do")
	@ResponseBody
	public Map<String, Object> chatMake(
			@RequestParam(value="deleteId", required=true)String deleteId
			, @RequestParam(value="deleteChatroomCode", required=true) String deleteChatroomCode
			, @AuthenticationPrincipal(expression="authMember") MemberVO authMember
			, Model model
			, HttpSession session
			
			) {
		
		
		log.info("일단 타기는 하는지 봐야하니까*******************");
		
		Map<String, String> info = new HashMap<>();
		
		info.put("deleteId", deleteId);
		info.put("deleteChatroomCode", deleteChatroomCode);
		
		ServiceResult result = service.deleteChatMem(info);
		
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", result);
		
		return resultMap;
	}

}
