package kr.or.ddit.common.noticeAdmin.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.common.noticeAdmin.service.NoticeService;
import kr.or.ddit.vo.AttatchVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class NoticeDownloadController {
	
	@Inject
	NoticeService service;

	@RequestMapping("notice/download.do")
	public String download(@RequestParam("noticeCode") String noticeCode, Model model) {
		
		AttatchVO attatch = service.download(noticeCode);
		model.addAttribute("attatch", attatch);
		return "downloadView";
		
	}

}
