package kr.or.ddit.common.noticeProject.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.common.noticeProject.Service.ProjectNoticeService;
import kr.or.ddit.vo.AttatchVO;

@Controller
public class NoticeProjectDownloadController {
	
	@Inject
	ProjectNoticeService service;
	
	@RequestMapping("project/{pCode}/projectNotice/projectNoticeDownload.do")
	public String download(@RequestParam("noticeCode") String noticeCode, Model model) {
		
		AttatchVO attatch = service.downloadProjectAttatch(noticeCode);
		model.addAttribute("attatch", attatch);
		return "downloadView";
		
	}

}
