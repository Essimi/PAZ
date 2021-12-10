package kr.or.ddit.common.noticeAdmin.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.common.noticeAdmin.service.NoticeService;
import kr.or.ddit.vo.NoticeVO;

@Controller
public class NoticeUpdateGetController {
	
	@Inject
	NoticeService service;
	
	@RequestMapping("/notice/noticeUpdate.do")
	public String getController(
			@RequestParam(value="noticeCode", required=true) String noticeCode
			,Model model) {
		
		NoticeVO notice = service.selectNotice(noticeCode);
		
		model.addAttribute("notice",notice);
		
		return "noticeAdmin/noticeUpdateView";
	}

}
