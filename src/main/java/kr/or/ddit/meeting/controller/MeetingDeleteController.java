package kr.or.ddit.meeting.controller;

import java.io.IOException;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
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
	
	
	@RequestMapping(value="meeting/delete.do", method=RequestMethod.POST)
	public String delete(
			@RequestParam("what") String meetingCode
			,@RequestParam("memId") String memId
			, RedirectAttributes redirectAttributes
//			,@SessionAttribute("member") MemberVO member
			) throws IOException {
		
			MeetingVO meeting = new MeetingVO();
			meeting.setMeetingCode(meetingCode);
			
			meeting.setMemId(memId);
			
			// SESSION 에 있는 아이디 .
//			String sesesionMemId = member.getMemId();
			
			ServiceResult result = service.meetingDelete(meeting);
			
//			if(!memId.equals(sesesionMemId)) result = ServiceResult.FAILED; 
			
			
			
			String viewName = null;
			String message = null;
			
			switch (result) {
			// 아이디기 일치하지 않을 시 
			case FAILED:
				viewName = "redirect:/meeting/select.do?what="+meetingCode;
				message = "아이디가 일치하지 않습니다.";
				break;
				
			case OK:
				viewName = "redirect:/meeting/list.do";
				break;

			default:
				viewName= "redirect:/meeting/select.do?what="+meetingCode;
				message = "서버 오류";
				break;
				
			}
			redirectAttributes.addFlashAttribute("message",message);
			return viewName;
	}
}
