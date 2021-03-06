package kr.or.ddit.common.qna.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.common.qna.service.QnAService;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.QnaVO;

@Controller
public class QnAAllListController {
	
	@Inject
	private QnAService service;
	
//	관리자 입장에서의 고객센터 리스트 조회
//	조건 없는 모든 글이 조회됩니다.

	@RequestMapping("qna/qnaList.do")
	public String qnaAllList(@RequestParam(value = "page", required = false, defaultValue = "1") int currentPage, Model model) {
		
		PagingVO<QnaVO> pagingVO = new PagingVO<>(10,5);
		pagingVO.setCurrentPage(currentPage);
		
		service.retrieveQnAList(pagingVO);
		
		model.addAttribute("pagingVO", pagingVO);
						    	
		return "serviceCenter/QnAList";
		
	}
	
//	관리자 입장에서의 고객센터 리스트 조회
//	답변글이 없는 글만 조회됩니다.

	@RequestMapping("qna/qnaNotAnswerList.do")
	public String qnaNotAnswerList(@RequestParam(value = "page", required = false, defaultValue = "1") int currentPage, Model model) {
		
		PagingVO<QnaVO> pagingVO = new PagingVO<>(10,5);
		pagingVO.setCurrentPage(currentPage);
		
		service.retrieveNotAnswerQnAList(pagingVO);
		
		model.addAttribute("pagingVO", pagingVO);
						    	
		return "serviceCenter/QnAList";
		
	}
	
//	관리자 입장에서의 고객센터 리스트 조회
//	삭제된 글만 조회됩니다.
	
	@RequestMapping("qna/qnaDeleteList.do")
	public String qnaDeleteList(@RequestParam(value = "page", required = false, defaultValue = "1") int currentPage, Model model) {
		
		PagingVO<QnaVO> pagingVO = new PagingVO<>(10,5);
		pagingVO.setCurrentPage(currentPage);
		
		service.retrieveQnADeleteList(pagingVO);
		
		model.addAttribute("pagingVO", pagingVO);
						    	
		return "serviceCenter/QnAList";
		
	}
	
	
}
