package kr.or.ddit.meeting.controller;

import java.io.IOException;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.meeting.service.MeetingService;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.validate.groups.UpdateGroup;
import kr.or.ddit.vo.DataListVO;
import kr.or.ddit.vo.MeetingVO;
import kr.or.ddit.vo.ProjectMemberVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequestMapping("/meeting/modify.do")
@Controller
public class MeetingModifyController {

	@Inject
	private MeetingService service;
	
	@RequestMapping
	public String getController(@ModelAttribute("meeting") ProjectMemberVO projectMemberVO
		,@RequestParam("what") String meetingCode
		,@RequestParam("what2") String pCode
		,Model model
			) {
		
		MeetingVO meeting = service.meetingSelect(meetingCode);
		model.addAttribute("meeting", meeting);
		
		DataListVO<ProjectMemberVO> dataListVO = new DataListVO<>();
		dataListVO.setpCode(pCode);
		service.chackmember(dataListVO);
		model.addAttribute("dataListVO", dataListVO);
		
		
		return "meeting/meetingModify";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String meetingUpdatePost(@Validated(UpdateGroup.class)@ModelAttribute("meeting") MeetingVO meeting
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
				viewName = "redirect:/meeting/select.do?what="+ meeting.getMeetingCode()+"&what2="+meeting.getpCode();
				break;
				
			default:
				viewName = "meeting/select";
				message = "서버 오류, 잠시뒤 다시 시도 요청";
			}
		} else {
			viewName = "meeting/select";
		}
		
		model.addAttribute("message",message);
		
		return viewName;
	}
	
	
	
	
}
