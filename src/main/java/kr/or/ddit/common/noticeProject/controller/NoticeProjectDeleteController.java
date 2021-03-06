package kr.or.ddit.common.noticeProject.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.common.noticeProject.Service.ProjectNoticeService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class NoticeProjectDeleteController {
	
	@Inject
	ProjectNoticeService service;
	@RequestMapping("project/{pCode}/projectNotice/projectNoticeDelete.do")
	public String delete(
			
		@RequestParam(value="noticeCode", required=true) String noticeCode
		, @AuthenticationPrincipal(expression="authMember") MemberVO authMember
		, RedirectAttributes redirectAttributes
		, HttpSession session
		
	) {
		
		// 세션에서 프로젝트 코드를 가져온다.
		ProjectVO project = (ProjectVO) session.getAttribute("project");
		String pCode = project.getpCode();
		
		String viewName = null;
		String message = null;
		ServiceResult result = null;
		
		NoticeVO notice = service.selectProjectNotice(noticeCode);
		
		// 현재 로그인한 회원의 아이디 정보
		String savedId = authMember.getMemId();
		String noticeId = notice.getMemId();
		
		if (!savedId.equals(noticeId)) {
	
			viewName = "redirect:/project/" + pCode + "/projectNotice/projectNoticeSelect.do?noticeCode=" + noticeCode;
			message = "당신이 삭제할 수 없는 글 입니다.";
			
		} else {
			result = service.deleteProjectNotice(noticeCode);
			viewName = "redirect:/project/" + pCode + "/projectNotice/projectNoticeList.do";
			
			log.info("지금 이곳을 타고있다1");
			
			switch (result) {
			
			case FAILED:
				log.info("지금 이곳을 타고있다2");
				viewName = "redirect:/project/" + pCode + "projectNotice/projectNoticeSelect.do?noticeCode=" + noticeCode;
				message = "예상하지 못 한 오류로 인하여 공지사항 삭제에 실패하였습니다.";
				break;
			case OK:
				log.info("지금 이곳을 타고있다3");
				viewName = "redirect:/project/" + pCode + "/projectNotice/projectNoticeList.do";
				break;
			
			}
			
		}
		
		redirectAttributes.addFlashAttribute("message", message);
		return viewName;
		
	}
	
	
}
