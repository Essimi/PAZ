package kr.or.ddit.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.vo.MemberVO;

@Controller
public class MemberJoinController {
	
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value="login/join.do", method=RequestMethod.POST)
	public String Access(
			@Validated(InsertGroup.class) @ModelAttribute("member") MemberVO member,
			Errors errors
			) throws Exception {
		String viewName = null;
//		ServiceResult result = memberService.createMember(member);
		ServiceResult result = ServiceResult.FAILED;
		switch (result) {
		case OK:
			viewName = "redirect:/";
			break;
		default:
			viewName = "redirect:";
			break;
		}
		
		return viewName;
	}
	
	@RequestMapping(value="login/idcheck.do", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, String> Access(
			@RequestParam("inputId") String inputId
			) {
		MemberVO member = new MemberVO();
		member.setMemId(inputId);
		
		String status = null;
		String message = null;
		String color = null;
		ServiceResult result = memberService.MemberIdCheck(member);
		switch (result) {
		case OK:
			message = "사용 가능한 아이디입니다.";
			color = "green";
			status = "OK";
			break;
		default:
			message = "이미 사용중인 아이디입니다.";
			color = "red";
			status = "FAIL";
			break;
		}
		
		Map<String, String> dataMap = new HashMap<>();
		dataMap.put("message", message);
		dataMap.put("color", color);
		dataMap.put("status", status);
		
		return dataMap;
	}
	
}
