package kr.or.ddit.meeting.controller;

import java.io.IOException;

import javax.inject.Inject;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.meeting.service.MeetingService;
import kr.or.ddit.vo.MeetingVO;
import kr.or.ddit.vo.MemberVO;

@Controller
public class MeetingDeleteController {
	
	
	@Inject
	private MeetingService service;
	
	
	@RequestMapping(value="project/{pCode}/meeting/delete.do", method=RequestMethod.POST)
	public String delete(
			@RequestParam("what") String meetingCode
			,@PathVariable("pCode") String pCode 
			,@RequestParam("memId") String memId
			, RedirectAttributes redirectAttributes
			,@AuthenticationPrincipal(expression="authMember") MemberVO authMember
			) throws IOException {
		
			MeetingVO meeting = new MeetingVO();
			meeting.setMeetingCode(meetingCode);
			
			meeting.setMemId(memId);
			
			// 로그인 정보에 있는 아이디 .
			String authMemberMemId = authMember.getMemId();
			
			ServiceResult result = service.meetingDelete(meeting);
			
			if(!memId.equals(authMemberMemId)) result = ServiceResult.FAILED; 
			
			
			
			String viewName = null;
			String message = null;
			
			switch (result) {
			// 아이디기 일치하지 않을 시 
			case FAILED:
				viewName = "redirect:/project/{pCode}/meeting/select.do?what="+meetingCode;
				message = "아이디가 일치하지 않습니다.";
				break;
				
			case OK:
				viewName = "redirect:/project/{pCode}/meeting/list.do";
				break;

			default:
				viewName= "redirect:/project/{pCode}/meeting/select.do?what="+meetingCode;
				message = "서버 오류";
				break;
				
			}
			redirectAttributes.addFlashAttribute("message",message);
			return viewName;
	}
}
