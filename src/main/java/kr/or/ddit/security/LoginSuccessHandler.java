package kr.or.ddit.security;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.dao.LoginInfoDAO;


/**
 * 로그인 성공시 처리할 객체
 * @author pc01
 *
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
	
	@Inject
	LoginInfoDAO infoDAO;
	
	@Override
	public void onAuthenticationSuccess(
			HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		User user = (User) authentication.getPrincipal();
		String memId = user.getUsername();
		
		// 로그인 성공 시간 데이터 입력
		infoDAO.insertLoginInfo(memId);
		
		// ADMIN권한을 가질경우 ADMIN페이지로 이동
		String viewName = "/";
		Collection<GrantedAuthority> authorities =  user.getAuthorities();
		for(GrantedAuthority auth : authorities) {
			if(auth.getAuthority().toUpperCase().equals("ADMIN")) {
				viewName = "/admin/adminMain.do";
			}
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("memberStatus", ServiceResult.OK);
		response.sendRedirect(request.getContextPath() + viewName);
	}
	
}
