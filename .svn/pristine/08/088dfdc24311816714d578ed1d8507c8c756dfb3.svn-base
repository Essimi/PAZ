package kr.or.ddit.meeting.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.common.noticeAdmin.service.NoticeService;
import kr.or.ddit.meeting.service.MeetingService;
import kr.or.ddit.vo.AttatchVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MeetingDownloadController {
	
	@Inject
	MeetingService service;

	@RequestMapping("/meeting/download.do")
	public String download(@RequestParam("meetingCode") String meetingCode, Model model) {
		
		AttatchVO attatch = service.download(meetingCode);
		model.addAttribute("attatch", attatch);
		return "downloadView";
		
	}

}
