package kr.or.ddit.common.authentication.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import kr.or.ddit.vo.MemberVO;

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
	public String join(Authentication authentication, HttpServletRequest request, Model model){
		String viewName = "login/join";
		viewName = authenticationCheck(authentication, viewName);
		
		Map<String, ?> flashMap =  RequestContextUtils.getInputFlashMap(request);
		if(flashMap != null) {
			MemberVO userInfo = (MemberVO) flashMap.get("userInfo");
			model.addAttribute("userInfo", userInfo);
		}
		
		return viewName;
	}
}
