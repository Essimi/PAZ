package kr.or.ddit.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberJoinController {
	
	@RequestMapping("join.do")
	public String Access() {
		return "join/join";
	}
}
