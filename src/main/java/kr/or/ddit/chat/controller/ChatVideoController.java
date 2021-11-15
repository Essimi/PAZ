package kr.or.ddit.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatVideoController {
	@RequestMapping("chat/video.do")
	public String Access() {
		return "chat/chatvideo";
	}
}
