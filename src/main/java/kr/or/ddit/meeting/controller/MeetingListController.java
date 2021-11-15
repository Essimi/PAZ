package kr.or.ddit.meeting.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.meeting.service.MeetingService;
import kr.or.ddit.vo.MeetingVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class MeetingListController {
	@Inject
	private MeetingService service;
	
	@RequestMapping("meeting/list.do")
	public String meetingList(
			@RequestParam(value="page", required=false, defaultValue="1") int currentPage
			,@ModelAttribute("searchVO") SearchVO searchVO
			,Model model
			){
		
			PagingVO<MeetingVO> pagingVO = new PagingVO<>();
			pagingVO.setCurrentPage(currentPage);
			pagingVO.setSearchVO(searchVO);
			
			service.meetingPageList(pagingVO);
			log.info("페이징브이오 : {}",pagingVO.getDataList());
			model.addAttribute("pagingVO",pagingVO);
		
		return "meeting/meetingList";
	}
	
	
}
