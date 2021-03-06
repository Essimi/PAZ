package kr.or.ddit.meeting.controller;

import java.io.IOException;

import javax.inject.Inject;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.meeting.service.MeetingService;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.validate.groups.UpdateGroup;
import kr.or.ddit.vo.DataListVO;
import kr.or.ddit.vo.MeetingVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProjectMemberVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("project/{pCode}/meeting/modify.do")
public class MeetingModifyController {
	@Inject
	private MeetingService service;
	@RequestMapping
	public String getController(@ModelAttribute("meeting") ProjectMemberVO projectMemberVO
		,@PathVariable("pCode") String pCode
		,@RequestParam("what") String meetingCode
		,@AuthenticationPrincipal(expression="authMember") MemberVO authMember
		,Model model
		//프로젝트 세션정보(pcode)와 로그인 정보 필요함
			) {
		
		String authMemberMemId = authMember.getMemId();
		
		
		
		MeetingVO meeting = service.meetingSelect(meetingCode);
		model.addAttribute("meeting", meeting);
		
		DataListVO<ProjectMemberVO> dataListVO = new DataListVO<>();
		dataListVO.setpCode(pCode);
		dataListVO.setMeetingCode(meetingCode);
		service.chackSelect(dataListVO);
		model.addAttribute("dataListVO", dataListVO);
		model.addAttribute("authMemberMemId", authMemberMemId);
		
		
		return "meeting/meetingModify";
	}
	
	
	
	
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String meetingUpdatePost(@Validated(UpdateGroup.class)@ModelAttribute("meeting") MeetingVO meeting
			,@PathVariable("pCode") String pCode
			,BindingResult errors
			,Model model
			) throws IOException {
		log.info("test : {}", meeting);
		
		String viewName = null;
		String message = null;
		
		if(!errors.hasErrors()) {
			ServiceResult result = service.meetingModify(meeting);
			switch (result) {
			case OK:
				viewName = "redirect:/project/{pCode}/meeting/select.do?what="+ meeting.getMeetingCode();
				break;
				
			default:
				viewName = "meeting/meetingSelect";
				message = "서버 오류, 잠시뒤 다시 시도 요청";
			}
		} else {
			viewName = "meeting/meetingSelect";
		}
		
		model.addAttribute("message",message);
		
		return viewName;
	}
	
	
	
	
}
