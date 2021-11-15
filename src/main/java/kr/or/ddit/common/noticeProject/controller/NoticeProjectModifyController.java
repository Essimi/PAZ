package kr.or.ddit.common.noticeProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticeProjectModifyController {
	@RequestMapping("noticeProject/modify.do")
	public String Access() {
		return "noticeProject/noticeModify";
	}
}
