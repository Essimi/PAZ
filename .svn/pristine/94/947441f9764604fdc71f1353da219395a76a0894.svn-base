package kr.or.ddit.common.authentication.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthenticationController {
	
	private String authenticationCheck(Authentication authentication, String viewName) {
		if(authentication != null) {
			viewName = "redirect:/project/myprojectList.do";
		}
		return viewName;
	}
	
	@RequestMapping("login/login.do")
	public String login(Authentication authentication){
		String viewName = "login/login";
		viewName = authenticationCheck(authentication, viewName);
		
		return viewName;
	}
	
	@RequestMapping("login/join.do")
	public String join(Authentication authentication){
		String viewName = "login/join";
		viewName = authenticationCheck(authentication, viewName);
		
		return viewName;
	}
}
