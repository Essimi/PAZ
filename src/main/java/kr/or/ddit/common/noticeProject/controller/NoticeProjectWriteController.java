package kr.or.ddit.common.noticeProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticeProjectWriteController {
	@RequestMapping("noticeProject/write.do")
	public String Access() {
		return "noticeProject/noticeWrite";
	}
}
