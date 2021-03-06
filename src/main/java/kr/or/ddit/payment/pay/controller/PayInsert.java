package kr.or.ddit.payment.pay.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.payment.pay.service.PayService;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PayVO;
import kr.or.ddit.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PayInsert {
	
	@Inject
	private PayService service;

//	결제 메소드 입니다.
	@RequestMapping(value = "project/PayAddition.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String payAddition(@Valid @ModelAttribute("PayVO") PayVO pay, Errors errors,
								@AuthenticationPrincipal(expression="authMember") MemberVO authMember) {
		
		String message = null;
									
		// 세션에서 아이디를 받아와야 합니다.
		pay.setMemId(authMember.getMemId());
						
		// 검증 주석
		if(!errors.hasErrors()) {
			ServiceResult result = service.createPayRecord(pay);
			switch(result) {
				
			case OK:
				message = "결제에 성공했습니다.";
				break;
			default:
				message = "결제에 실패했습니다.";
				break;
			}
		}else {
			message = "결제에 실패했습니다... 검증 실패.";
		}
				
		return message;
				
	}
	
	// 추가 결제 메소드 입니다.
	@RequestMapping(value = "project/PayPlusAddition.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String plusPayAddition(@Valid @ModelAttribute("PayVO") PayVO pay, Errors errors,
								@AuthenticationPrincipal(expression="authMember") MemberVO authMember) {
		
		String message = null;
									
		// 세션에서 아이디를 받아와야 합니다.
		pay.setMemId(authMember.getMemId());
						
		// 검증 주석
		if(!errors.hasErrors()) {
			ServiceResult result = service.createPlusPayRecord(pay);
			log.info("test : {}", result);
			switch(result) {
			
				
			case OK:
				message = "결제에 성공했습니다.";
				break;
			default:
				message = "결제에 실패했습니다.";
				break;
			}
		}else {
			message = "결제에 실패했습니다... 검증 실패.";
		}
				
		return message;
				
	}
}
