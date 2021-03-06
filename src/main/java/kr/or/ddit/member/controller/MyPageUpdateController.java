package kr.or.ddit.member.controller;

import javax.inject.Inject;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.validate.groups.UpdateGroup;
import kr.or.ddit.vo.MemberVO;

@Controller
public class MyPageUpdateController {
	@Inject
	MemberService memberService;
	
	@RequestMapping("mypage/myPageUpdate.do")
	public String Access(
			@AuthenticationPrincipal(expression="authMember") MemberVO authMember,
			Model model
			){
		MemberVO memberInfo = memberService.selectMember(authMember);
		model.addAttribute("memberInfo", memberInfo);
		
		return "member/myPageModify";
	}
	
	@RequestMapping(value="mypage/myPageUpdate.do", method=RequestMethod.POST)
	public String update(
			@Validated(UpdateGroup.class) @ModelAttribute("updateMember") MemberVO member,
			Errors errors,
			Model model 
			) {
		ServiceResult result = memberService.memberUpdate(member);
		String viewName = null;
		String message = null;
		switch (result) {
		case OK:
			viewName = "redirect:/mypage/myPage.do";
			break;
		default:
			viewName = "redirect:/mypage/myPageUpdate.do";
			message = "서버상의 문제로 다시 시도해주세요.";
			break;
		}
		model.addAttribute("message", message);
		
		return viewName;
	}
}
