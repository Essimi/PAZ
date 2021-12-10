package kr.or.ddit.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.vo.MemberVO;

@Controller
public class FindMemberController {
	@Inject
	private MemberService memberService;
	
	@RequestMapping("login/find/pass.do")
	public String findPass() {
		return "login/findPass";
	}
	
	@RequestMapping(value="login/find/passMailCheck.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> mailCheck(
			@ModelAttribute("findMember") MemberVO member
			) {
		Map<String, Object> resultMap = new HashMap<>();
		if(memberService.memberIdCheck(member) != ServiceResult.OK) {
			ServiceResult result = memberService.memberEmailCheck(member);
			switch (result) {
			case OK:
				resultMap.put("status", ServiceResult.OK);
				resultMap.put("message","등록한 메일로 임시비밀번호가 전송되었습니다.");
				break;
			default:
				resultMap.put("status", ServiceResult.FAILED);
				resultMap.put("message", "등록한 이메일이 존재하지 않습니다. 다시 확인해주세요.");
				break;
			}
		}else {
			resultMap.put("status", ServiceResult.FAILED);
			resultMap.put("message", "아이디를 확인해주세요.");
		}
		
		return resultMap;
	}
	
}
