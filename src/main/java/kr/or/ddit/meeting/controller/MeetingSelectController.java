package kr.or.ddit.meeting.controller;

import javax.inject.Inject;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.meeting.service.MeetingService;
import kr.or.ddit.vo.AttatchVO;
import kr.or.ddit.vo.MeetingVO;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class MeetingSelectController {
	
	@Inject
	private MeetingService service;
	
	
	@RequestMapping("project/{pCode}/meeting/select.do")
	public String MeetingSelect(@RequestParam(name="what") String meetingCode
			,@PathVariable("pCode") String cPode
			, Model model
			,@AuthenticationPrincipal(expression="authMember") MemberVO authMember
			//로그인정보와 프로젝트 코드가 필요함
			){
		
		String authMemberMemId = authMember.getMemId();
		
		MeetingVO meeting = service.meetingSelect(meetingCode);

		model.addAttribute("meeting",meeting);

		model.addAttribute("authMemberMemId",authMemberMemId);
		
		return "meeting/meetingSelect";
		
	}
	
	
}
