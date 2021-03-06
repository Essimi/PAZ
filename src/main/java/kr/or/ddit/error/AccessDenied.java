package kr.or.ddit.error;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AccessDenied {
	
	@RequestMapping("/error/accessDenied.do")
	public ModelAndView accessDenied(Model model, HttpServletResponse resp, HttpServletRequest req) {
		
		// security  - accessDenied 관련 Class
		
		// 쿠키 삭제
//		Cookie rememberMe = new Cookie("remember-me", null);
//		
//		rememberMe.setMaxAge(0); // 유효시간을 0으로 설정
//		rememberMe.setPath("/PAZ");
//		resp.addCookie(rememberMe);
//		
//		// 세션 삭제
//		HttpSession session = req.getSession();
//		session.invalidate();
	
		log.info("==============================error log==============================");
		log.info("CustomAccessDeniedHandler. 예외처리 입니다.(권한 없음)");
		log.info("==============================error end==============================");
		
		String message = "비정상적인 권한 접근 입니다.";
				
		ModelAndView re = new ModelAndView();
		re.setViewName("errorPage/totalErrorPage");
		re.addObject("message", message);
		re.addObject("code", HttpStatus.BAD_REQUEST);
		re.addObject("codeNumber", "403");
		re.addObject("url", req.getRequestURL());
		
		return re;
		
	}
}
