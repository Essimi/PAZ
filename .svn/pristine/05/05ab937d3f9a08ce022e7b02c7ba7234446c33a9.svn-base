package kr.or.ddit.common.noticeAdmin.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.common.noticeAdmin.service.NoticeService;
import kr.or.ddit.enumpkg.ServiceResult;

@Controller
public class NoticeDeleteController {
	
	@Inject
	NoticeService service;
	
	@RequestMapping("notice/noticeDelete.do")
	public String delete(
		@RequestParam(value="noticeCode", required=true) String noticeCode
		,RedirectAttributes redirectAttributes
	) {
		
		ServiceResult result = service.deleteNotice(noticeCode);
		
		String viewName = null;
		String message = null;
		
		switch (result) {
		
			case FAILED:
				viewName = "redirect:/notice/notice.do?noticeCode="+noticeCode;
				message = "당신이 삭제할 수 없는 글 입니다.";
				break;
			case OK:
				viewName = "redirect:/notice/noticeList.do";
				break;
		}
		
		redirectAttributes.addFlashAttribute("message", message);
		return viewName;
		
	}
	
}
