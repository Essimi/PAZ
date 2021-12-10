package kr.or.ddit.chat.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.chat.service.ChattingService;
import kr.or.ddit.vo.MemberProfileVO;
import kr.or.ddit.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ChattingProfileController {
	
	@Inject
	private ChattingService service;
	
	@RequestMapping("chat/chattingProfile.do")
	@ResponseBody
	public MemberProfileVO chattingProfile(
			
			@RequestParam(value="memId", required=true) String memId
			,Model model
			, HttpSession session
			
			) {
		
		// 세션에서 프로젝트 코드를 가져온다.
		ProjectVO project = (ProjectVO) session.getAttribute("project");
		String pCode = project.getpCode();
		
		Map<String, String> info = new HashMap<>();
		
		info.put("memId", memId);
		info.put("pCode", pCode);
		
		MemberProfileVO member = new MemberProfileVO();
				
		member = service.selectMember(info);
		
		return member;
	}
	

}