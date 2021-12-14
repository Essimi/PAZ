
package kr.or.ddit.common.qna.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.apache.logging.log4j.core.appender.rewrite.MapRewritePolicy.Mode;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.common.qna.service.QnAService;
import kr.or.ddit.enumpkg.ResultStatus;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.QnaVO;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class QnAWriteController {
		
	@Inject
	private QnAService service;
	
// 고객센터 게시글의 상세조회 입니다.
	
	@RequestMapping("qna/qnaView.do")
	public String qnaView(@RequestParam("QnANo") String qandaCode ,Model model){
					
		QnaVO qna = service.retrieveQnA(qandaCode);
								
		model.addAttribute("qna", qna);
				
		return "serviceCenter/QnAView";
	}
	
//  글 작성 폼으로 이동 입니다.
//  글 신규 작성	
	
	@RequestMapping("qna/qnaWrite.do")
	public String getQnAWrite(@ModelAttribute("qna") QnaVO qna) {
					
		return "serviceCenter/QnAWrite";
	}
	
	@RequestMapping(value = "qna/qnaWrite.do", method = RequestMethod.POST)
	public String postQnAWrite(@Validated(InsertGroup.class) @ModelAttribute("qna") QnaVO qna, Errors errors, Model model,
								@AuthenticationPrincipal(expression="authMember") MemberVO authMember, RedirectAttributes redirect) {
		
		String viewName = null;
								
		qna.setMemId(authMember.getMemId());
		
		ResultStatus status = ResultStatus.FAIL;
										
		if(!errors.hasErrors()) {
			ServiceResult result = service.createQnA(qna);
			
			switch (result) {
			case OK:
				viewName = "redirect:/qna/qnaView.do?QnANo="+qna.getQandaCode();
				status = ResultStatus.INSERT;
				redirect.addFlashAttribute("status", status);
				break;
			default:
				viewName = "serviceCenter/QnAWrite";
				status = ResultStatus.FAIL;
				
				break;
			}
		}else {
			viewName = "serviceCenter/QnAWrite";
			status = ResultStatus.FAIL;
		}
		

		model.addAttribute("status", status);
		
		return viewName;
	}
	
//  글 수정	
//  글 작성 폼으로 이동 입니다.
	
	@RequestMapping("qna/qnaUpdate.do")
	public String getQnAUpdate(@RequestParam("QnANo") String QnANo, @ModelAttribute("qna") QnaVO qna, Model model
								) {
		
		QnaVO qnaUpdate = service.retrieveQnA(QnANo);
								
		model.addAttribute("qnaUpdate", qnaUpdate);
	
		return "serviceCenter/QnAModify";
	}
	
	@RequestMapping(value = "qna/qnaUpdate.do", method = RequestMethod.POST)
	public String postQnAUpdate(@Validated @ModelAttribute("qna") QnaVO qna, Errors errors, 
			                   Model model,
			                   @AuthenticationPrincipal(expression="authMember") MemberVO authMember, RedirectAttributes redirect) {
				
		String viewName = null;
				
		ResultStatus status = ResultStatus.FAIL;
		
		qna.setMemId(authMember.getMemId());
						
		if(!errors.hasErrors()) {
			ServiceResult result = service.modifyQnA(qna);
			
			switch (result) {
			case OK:
				if(authMember.getMemId().equals("admin")) {
					
					viewName = "redirect:/qna/qnaView.do?QnANo="+qna.getQandaCode();
					status = ResultStatus.INSERT;
					redirect.addFlashAttribute("status", status);
					
				}else if(!authMember.getMemId().equals("admin")){
					
					viewName = "redirect:/qna/qnaView.do?QnANo="+qna.getQandaCode();
					status = ResultStatus.INSERT;
					redirect.addFlashAttribute("status", status);
				}
				
				break;
			default:
				viewName = "serviceCenter/QnAModify";
				status = ResultStatus.FAIL;
				break;
			}
		}else {
			viewName = "serviceCenter/QnAModify";
			model.addAttribute("qnaUpdate", qna);
			status = ResultStatus.FAIL;
		}
		
		model.addAttribute("status", status);
		
		return viewName;
	}
}
