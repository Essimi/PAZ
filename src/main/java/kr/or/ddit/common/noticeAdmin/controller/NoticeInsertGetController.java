package kr.or.ddit.common.noticeAdmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticeInsertGetController {
	
	@RequestMapping("/notice/noticeInsert.do")
	public String getController() {
		return "notice/noticeInsertView";
	}

}
