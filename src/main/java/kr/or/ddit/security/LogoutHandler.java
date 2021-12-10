package kr.or.ddit.security;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import kr.or.ddit.member.dao.LoginInfoDAO;

@Component
public class LogoutHandler implements LogoutSuccessHandler{

	@Inject
	LoginInfoDAO infoDAO;
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		if(authentication != null) { // 데이터가 없을 경우를 대비하기 위해 조건문 추가 (예 - 로그인 상태에서 서버를 재시작한 후 로그아웃 버튼 누름)
			
			User user = (User) authentication.getPrincipal();
			String memId = user.getUsername();
			
			// 로그아웃 시간 저장
			infoDAO.insertLogoutInfo(memId);
		}
		
		response.sendRedirect(request.getContextPath());
	}

}
