package kr.or.ddit.common.noticeAdmin.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.common.noticeAdmin.service.NoticeService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.NoticeVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class NoticeUpdatePostController {
	
	@Inject
	NoticeService noticeService;
	
	@RequestMapping(value="/notice/noticeUpdate.do", method=RequestMethod.POST)
	public String postController(
			
			@Validated @ModelAttribute("notice") NoticeVO notice
			,Errors errors
			,Model model
			,RedirectAttributes redirectAttributes
			
			) {
		
		String viewName = null;
		String message = null;
		
		if(!errors.hasErrors()) {
			
			ServiceResult result = noticeService.updateNotice(notice);
			
			log.info("결과값. {}", result);
			
			switch(result) {
			
				case FAILED:
					viewName = "redirect:/notice/notice.do?noticeCode="+notice.getNoticeCode();
					message = "당신이 수정할 수 없는 글 입니다.";
					break;
				case OK:
					viewName = "redirect:/notice/notice.do?noticeCode="+notice.getNoticeCode();
					break;
			}
			
		} else {
			viewName = "noticeAdmin/noticeUpdateView";
		}
		
		redirectAttributes.addFlashAttribute("message", message);
		return viewName;
	}

}
