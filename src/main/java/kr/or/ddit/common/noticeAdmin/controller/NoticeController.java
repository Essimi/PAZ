package kr.or.ddit.common.noticeAdmin.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.common.noticeAdmin.service.NoticeService;
import kr.or.ddit.vo.NoticeVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class NoticeController {
	
	@Inject
	private NoticeService service;
	
	@RequestMapping("notice/notice.do")
	public String selectNotice(
			
			@RequestParam(value="noticeCode", required=true) String noticeCode
			,Model model
			
			){
		
		NoticeVO notice = service.selectNotice(noticeCode);
		
		log.info("첨부파일 데이터가 잘 담기는가에 대한 테스트 {}", notice.getAttatch().getRealName());
		
		model.addAttribute("notice",notice);
		
		return "noticeAdmin/noticeView";
	}

}
