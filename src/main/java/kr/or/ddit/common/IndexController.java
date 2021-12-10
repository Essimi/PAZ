package kr.or.ddit.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.or.ddit.vo.MemberVO;

@Controller
public class IndexController{
	
	@RequestMapping("/index.do")
	public String index(){
		
		return "util/index";
		//클래스 새로 만들어서 로그인 회원가입 (공통부분만)
	}
}
