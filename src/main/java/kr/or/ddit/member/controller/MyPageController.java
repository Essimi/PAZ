package kr.or.ddit.member.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.admin.member.service.AdminMemberService;
import kr.or.ddit.enumpkg.ResultStatus;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.project.service.ProjectService;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProjectVO;

@Controller
public class MyPageController {
	
	@Inject
	private MemberService memberService;
	
	@Inject
	private AdminMemberService adminService;
	
	@Inject
	private ProjectService projectService;
	
	@RequestMapping("mypage/myPage.do")
	public String Access(
			@AuthenticationPrincipal(expression="authMember") MemberVO authMember,
			Model model
			){
		MemberVO memberInfo = memberService.selectMember(authMember);
		model.addAttribute("memberInfo", memberInfo);
		
		return "member/myPage";
	}
	
	@RequestMapping("mypage/memberDelete.do")
	public String delete(
			@AuthenticationPrincipal(expression="authMember") MemberVO authMember,
			HttpSession session,
			HttpServletResponse resp,
			Model model,
			RedirectAttributes redirect
			) {
		String viewName = null;
		ServiceResult status = null;
		// PL인 프로젝트가 존재하면 탈퇴처리가 되지 않음.
		List<ProjectVO> plList = projectService.listMyProjectPl(authMember);
		if(plList.isEmpty()) {
			ServiceResult result = adminService.updateMemberOutCode(authMember);
			switch (result) {
			case OK:
				Cookie rememberMe = new Cookie("remember-me", null);
				
				rememberMe.setMaxAge(0); // 유효시간을 0으로 설정
				rememberMe.setPath("/PAZ");
				resp.addCookie(rememberMe); 
				
				viewName = "redirect:/login/logout.do";
				session.setAttribute("memberStatus", ResultStatus.DELETE);
				break;
			default:
				viewName = "redirect:/mypage/myPage.do";
				status = ServiceResult.FAILED;
				break;
			}
		}else {
			viewName = "redirect:/mypage/myPage.do";
			status = ServiceResult.PKDUPLICATED;
		}
		// 문제상황  session.invalidate()하면 로그아웃 처리가 안됨. => redirect해서 cookie가 삭제가 안되는듯.
		// 문제상황 status값이 넘어가지 않아서 토스트창이 실행되지 않는듯.
		
		// redirect후 보여지는 jsp에서 status를 한번만 꺼내쓸수 있다.
		redirect.addFlashAttribute("status", status);
		
		return viewName;
	}
	
	@RequestMapping(value="mypage/leftMemberInfo.do", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public MemberVO leftMemberInfo(
			@ModelAttribute("leftMenuMember") MemberVO member
			) {
		MemberVO memberInfo = memberService.selectMember(member);
		
		return memberInfo;
	}
	
}
