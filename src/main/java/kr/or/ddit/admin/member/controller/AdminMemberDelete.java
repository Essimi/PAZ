package kr.or.ddit.admin.member.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.admin.member.service.AdminMemberService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.MemberVO;

@Controller
public class AdminMemberDelete {
	
	@Inject
	AdminMemberService service;
	
	@RequestMapping("admin/adminMemberDelete.do")
	@ResponseBody
	public String memberDelete (@RequestParam("outCode") String outCode,
								@RequestParam("memId") String memId) {
		
		
		MemberVO member = new MemberVO();
		
		member.setOutCode(outCode);
		member.setMemId(memId);
		
		ServiceResult result = service.updateMemberOutCode(member);
		

		return result.toString();
	}

}
