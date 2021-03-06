package kr.or.ddit.common.noticeProject.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.common.noticeProject.Service.ProjectNoticeService;
import kr.or.ddit.vo.NoticeVO;

@Controller
public class NoticeProjectSelectController {
	
	@Inject
	ProjectNoticeService service;
	
	@RequestMapping("project/{pCode}/projectNotice/projectNoticeSelect.do")
	public String NoticeProjectSelect(
			
			@RequestParam(value="noticeCode", required=true) String noticeCode
			,Model model
			
			) {
		
		NoticeVO notice = service.selectProjectNotice(noticeCode);
		model.addAttribute("notice", notice);
		
		return "noticeProject/projectNoticeView";
	}
	
}
