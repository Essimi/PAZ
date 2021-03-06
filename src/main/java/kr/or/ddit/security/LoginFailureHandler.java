package kr.or.ddit.security;

import java.io.IOException;
import java.util.Locale;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.utils.MessageUtils;

/**
 * 로그인 실패시 처리할 객체
 * @author pc01
 *
 */
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {
	
	@Resource(name="messageUtils")
	MessageUtils msgUtils;
	
	@Override
	public void onAuthenticationFailure(
			HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception
			) throws IOException, ServletException {
		
		String errorMsg = null;
		
		// 유저가 존재하지 않을때
		if(exception instanceof UsernameNotFoundException){
			errorMsg = msgUtils.getMessage("error.UsernameNotFoundException");
		// 비밀번호 불일치
		}else if(exception instanceof BadCredentialsException) {
			errorMsg = msgUtils.getMessage("error.BadCredentials", Locale.KOREA);
        } else if(exception instanceof InternalAuthenticationServiceException) {
        	errorMsg = msgUtils.getMessage("error.BadCredentials");
        } else if(exception instanceof DisabledException) {
        	errorMsg = msgUtils.getMessage("error.Disaled");
        } else if(exception instanceof CredentialsExpiredException) {
        	errorMsg = msgUtils.getMessage("error.CredentialsExpired");
        }
		
		request.getSession().setAttribute("errorMsg", errorMsg);
		response.sendRedirect(request.getContextPath() + "/login/login.do");
	}
	
}
