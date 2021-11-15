package kr.or.ddit.common.authentication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PassFindController {
	@RequestMapping("find/Pass.do")
	public String Access() {
		return "login/findPass";
	}
}
