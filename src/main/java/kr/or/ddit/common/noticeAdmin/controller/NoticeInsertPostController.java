package kr.or.ddit.common.noticeAdmin.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.common.noticeAdmin.service.NoticeService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.NoticeVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class NoticeInsertPostController {
	
	@Inject
	private NoticeService service;

	@RequestMapping(value="notice/noticeInsert.do", method=RequestMethod.POST)
	public String insertNotice(
			
			@Validated @ModelAttribute("notice") NoticeVO notice,
			Errors errors,
			Model model
			
			){
		
		String viewName = null;
		String msg = null;
		
		notice.setPartCode("0");
		notice.setMemId("admin");
		
		if(!errors.hasErrors()) {
			
			log.info("공지사항의 내용 값 {}", notice.getNoticeContents());
			
			ServiceResult result = service.insertNotice(notice);
			
			switch(result) {
			
			case OK:
				viewName = "redirect:/notice/notice.do?noticeCode="+notice.getNoticeCode();
				break;
			default:
				viewName = "noticeAdmin/noticeInsertView";
			}
			
		} else {
			
			viewName = "noticeAdmin/noticeInsertView";
			
		}
		
		model.addAttribute("msg", msg);
		
		return viewName;
		
	}

}