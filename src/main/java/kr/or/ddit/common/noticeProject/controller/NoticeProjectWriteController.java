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

import kr.or.ddit.common.noticeProject.Service.ProjectNoticeService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class NoticeProjectWriteController {
	
	@Inject
	ProjectNoticeService service;
	
	@RequestMapping(value="project/{pCode}/projectNotice/projectNoticeInsert.do", method=RequestMethod.GET)
	public String getController() {
		return "noticeProject/projectNoticeInsertView";
	}
	
	@RequestMapping(value="project/{pCode}/projectNotice/projectNoticeInsert.do", method=RequestMethod.POST)
	public String postController(
			
			@Validated @ModelAttribute("notice") NoticeVO notice
			, @AuthenticationPrincipal(expression="authMember") MemberVO authMember
			, Errors errors
			, Model model
			, HttpSession session
			
			){
		
		String viewName = null;
		
		// 세션에서 프로젝트 코드를 가져온다.
		ProjectVO project = (ProjectVO) session.getAttribute("project");
		String partCode = project.getpCode();
		String pCode = project.getpCode();
		
		notice.setPartCode(partCode);
		notice.setMemId(authMember.getMemId());
		
		if(!errors.hasErrors()) {
			
			ServiceResult result = service.insertProjectNotice(notice);
			
			switch(result) {
				case OK:
					viewName = "redirect:/project/" + pCode + "/projectNotice/projectNoticeSelect.do?noticeCode="+notice.getNoticeCode();
					break;
					
				default:
					viewName = "noticeProject/projectNoticeInsertView";
			}
			
		} else {
			viewName = "noticeProject/projectNoticeInsertView";
		}
		
		return viewName;
		
	}
	
	
}
