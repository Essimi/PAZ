package kr.or.ddit.common.qna.controller;


import javax.inject.Inject;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.common.PKNotFoundException;
import kr.or.ddit.common.qna.service.QnAService;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.QnaVO;

@Controller
public class QnAUserListController {
	
	@Inject
	private QnAService service;
	
//	고객 입장에서의 질문글 조회
//	회원이 로그인한 id의 값을 토대로 리스트를 출력합니다.
	
	@RequestMapping("qna/qnaUserList.do")
	public String qnaNotAnswerList(@RequestParam(value = "page", required = false, defaultValue = "1") int currentPage, Model model,
									@AuthenticationPrincipal(expression="authMember") MemberVO authMember) throws PKNotFoundException {
		
		QnaVO qna = new QnaVO();
		
		// 세션에서 현재 로그인한 회원의 정보를 받아옵니다.
		qna.setMemId(authMember.getMemId());
		
		PagingVO<QnaVO> pagingVO = new PagingVO<>(10,5);
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setDetailSearch(qna);
				
		service.retrieveQnAListUser(pagingVO);
				
		model.addAttribute("pagingVO", pagingVO);
						    	
		return "serviceCenter/QnAUserList";
		
	}
}
