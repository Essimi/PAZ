package kr.or.ddit.common.authentication.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdminInterceptor extends HandlerInterceptorAdapter {

	// 전처리 Interceptor
	// 사용자가 요청을 보내면 처음으로 시작됨.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		log.info("==================================== INTERCEPTER START ====================================");
		log.info("요청받은 URI : {}", request.getRequestURI());
		log.info("===========================================================================================");
		
		// 로그인한 회원의 ID 정보를 받아옵니다.
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) auth.getPrincipal();
		String userName = user.getUsername();
			
		// 요청된 URI 진입 중 로그인한 회원의 아이디가 관리자일 경우
		if(request.getRequestURI().equals("/PAZ/qna/qnaUserList.do")) {
			if(userName.equals("admin")) {
				response.sendRedirect("/PAZ/qna/qnaList.do");
			}
		}
	
		
		return super.preHandle(request, response, handler);
	}
	
	// 후처리 Interceptor
	// 요청 결과 수행 후 처리 완료시 시작
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		log.info("==================================== INTERCEPTER END ====================================");
		
		super.postHandle(request, response, handler, modelAndView);
	}
}
