package kr.or.ddit;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class Main {
	
	@Inject
	MemberService service;
	
	@RequestMapping("/main.do")
	public String main() {
		
		return "home";
	}
	
	@RequestMapping(value = "/makeProject.do", method = RequestMethod.POST)
	@ResponseBody
	public List<String> makeProject(Authentication authentication, Model model) {
		
		String viewName = null;
		String message = null;
		
		if(authentication == null) {
			message = "비로그인";
			viewName = "/login/login.do";
		}else {
			// 결제한 회원인지 검증합니다.
			User user = (User) authentication.getPrincipal();
			String memId = user.getUsername();			
			ServiceResult result = service.memperPay(memId);
			
			if(result.equals(ServiceResult.OK)) { // 결제한 회원
				message = "결제";
				viewName = "/project/myprojectList.do";
			}else if(result.equals(ServiceResult.FAILED)) { // 미결제 회원
				message = "미결제";
				viewName = "/project/myprojectList.do";
			}
		}
		// 메세지와 viewName 을 한번에 넘겨주기 위한 리스트 객체를 생성해줍니다.
		List<String> answerList = new ArrayList<String>();
		
		answerList.add(viewName);
		answerList.add(message);
				
		return answerList;
	}
}
