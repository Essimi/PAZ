package kr.or.ddit.meeting.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.meeting.service.MeetingService;
import kr.or.ddit.vo.MeetingVO;
import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class MeetingSelectController {
	@Inject
	private MeetingService service;
	
	
	@RequestMapping("meeting/select.do")
	public String MeetingSelect(@RequestParam(name="what") String meetingCode
			, Model model
			){
		
		
		
		MeetingVO meeting = service.meetingSelect(meetingCode);
		
		model.addAttribute("meeting",meeting);
		
		return "meeting/meetingSelect";
		
	}
	
	
}
