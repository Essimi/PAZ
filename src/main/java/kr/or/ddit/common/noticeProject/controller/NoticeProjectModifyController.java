package kr.or.ddit.common.noticeProject.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.common.noticeProject.Service.ProjectNoticeService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.ProjectVO;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class NoticeProjectModifyController {
	
	@Inject
	ProjectNoticeService service;
	
	@RequestMapping(value="project/{pCode}/projectNotice/projectNoticeModify.do", method=RequestMethod.GET)
	public String getController(
			
			@RequestParam(value="noticeCode", required=true) String noticeCode
			, RedirectAttributes redirectAttributes
			, @AuthenticationPrincipal(expression="authMember") MemberVO authMember
			, Model model
			, HttpSession session
			
			) {
		
		// 세션에서 프로젝트 코드를 가져온다.
		ProjectVO project = (ProjectVO) session.getAttribute("project");
		String pCode = project.getpCode();
		
		String viewName = null;
		String message = null;
		
		NoticeVO notice = service.selectProjectNotice(noticeCode);
		
		// 현재 로그인한 회원의 아이디 정보
		String savedId = authMember.getMemId();
		String noticeId = notice.getMemId();
		
		if (!savedId.equals(noticeId)) {
			
			viewName = "redirect:/project/" + pCode + "/projectNotice/projectNoticeSelect.do?noticeCode=" + noticeCode;
			message = "당신이 수정할 수 없는 글 입니다.";
			
		} else {
			
			viewName = "noticeProject/projectNoticeUpdateView";
			
		}
		
		redirectAttributes.addFlashAttribute("message", message);
		model.addAttribute("notice",notice);
		
		return viewName;
	}
	
	
	@RequestMapping(value="project/{pCode}/projectNotice/projectNoticeModify.do", method=RequestMethod.POST)
	public String postController(
			
			@Validated @ModelAttribute("notice") NoticeVO notice
			, @AuthenticationPrincipal(expression="authMember") MemberVO authMember
			, Errors errors
			, Model model
			, HttpSession session
			
			) {
		
		String viewName = null;
		
		// 세션에서 프로젝트 코드를 가져온다.
		ProjectVO project = (ProjectVO) session.getAttribute("project");
		String partCode = project.getpCode();
		String pCode = project.getpCode();
		
		if(!errors.hasErrors()) {
			
			ServiceResult result = service.updateProjectNotice(notice);
			
			switch(result) {
			
				case FAILED:
					viewName = "redirect:/project/" + pCode + "/projectNotice/projectNoticeSelect.do?noticeCode="+notice.getNoticeCode();
					break;
				case OK:
					viewName = "redirect:/project/" + pCode + "/projectNotice/projectNoticeSelect.do?noticeCode="+notice.getNoticeCode();
					break;
			}
			
		} else {
			viewName = "noticeProject/projectNoticeUpdateView";
		}
		
		return viewName;
	}
	
}
