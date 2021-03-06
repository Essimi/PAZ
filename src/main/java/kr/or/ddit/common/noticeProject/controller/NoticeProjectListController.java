package kr.or.ddit.common.noticeProject.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.common.noticeProject.Service.ProjectNoticeService;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProjectVO;


@Controller
public class NoticeProjectListController {
	
	@Inject
	ProjectNoticeService service;
	
	@RequestMapping("project/{pCode}/projectNotice/projectNoticeList.do")
	public String selectNoticeList(
			
			@RequestParam(value="page", required=false, defaultValue="1") int currentPage
			, Model model
			, HttpSession session
			
			){
		
		// 세션에서 프로젝트 코드를 가져온다.
		ProjectVO project = (ProjectVO) session.getAttribute("project");
		String partCode = project.getpCode();
		
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setPartCode(partCode);
		
		PagingVO<NoticeVO> pagingVO = new PagingVO<>(10,5);
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setDetailSearch(noticeVO);
		
		service.selectProjectNoticeList(pagingVO);
		
		model.addAttribute("pagingVO",pagingVO);
		
		return "noticeProject/projectNoticeListView";
	}
	
	
}
