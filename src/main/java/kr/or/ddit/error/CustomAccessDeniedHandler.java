package kr.or.ddit.error;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CustomAccessDeniedHandler implements AccessDeniedHandler{
	
	@Override
	public void handle(HttpServletRequest req, HttpServletResponse resp,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
		log.info("test");
		
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
		
		resp.sendRedirect(req.getContextPath() + "/error/accessDenied.do");
				
	}
}
