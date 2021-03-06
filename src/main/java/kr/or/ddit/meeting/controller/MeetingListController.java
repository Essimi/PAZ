package kr.or.ddit.meeting.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	@RequestMapping("project/{pCode}/meeting/list.do")
	public String meetingList(
			@PathVariable("pCode") String pCode,
			@RequestParam(value="page", required=false, defaultValue="1") int currentPage
			,@ModelAttribute("searchVO") SearchVO searchVO
			,Model model
//			@AuthenticationPrincipal(expression="authMember") MemberVO authMember
			//로그인정보와 프로젝트 번호가 필요
			){
			MeetingVO meeting = new MeetingVO();
			meeting.setpCode(pCode);
			
			
			
			PagingVO<MeetingVO> pagingVO = new PagingVO<>(10, 5);
			pagingVO.setCurrentPage(currentPage);
			pagingVO.setSearchVO(searchVO);
			pagingVO.setDetailSearch(meeting);
			service.meetingPageList(pagingVO);
			
			model.addAttribute("pagingVO",pagingVO);
		
		return "meeting/meetingList";
	}
	
	
}
