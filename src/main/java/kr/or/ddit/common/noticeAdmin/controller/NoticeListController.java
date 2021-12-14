package kr.or.ddit.common.noticeAdmin.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.common.noticeAdmin.service.NoticeService;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PagingVO;

@Controller
public class NoticeListController {
	
	@Inject
	private NoticeService service;
	
	@RequestMapping("notice/noticeList.do")
	public String selectNoticeList(
			
			@RequestParam(value="page", required=false, defaultValue="1") int currentPage
			,Model model
			
			){
		
		
		PagingVO<NoticeVO> pagingVO = new PagingVO<>(10,5);
		pagingVO.setCurrentPage(currentPage);
		
		model.addAttribute("pagingVO",pagingVO);
		
		service.selectNoticeList(pagingVO);
		
		return "noticeAdmin/noticeListAdmin";
	}

}
