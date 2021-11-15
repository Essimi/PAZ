package kr.or.ddit.common.qna.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.common.qna.service.QnAService;
import kr.or.ddit.enumpkg.ServiceResult;


@Controller
public class QnADeleteController {
	
	@Inject
	private QnAService service;
	
//  글 삭제	
//  글 삭제 유무를 업데이트 합니다.
	
	@RequestMapping("project/qnaDelete.do")
	public String postQnAWrite(@RequestParam("QnANo") String qandaCode, RedirectAttributes redirectAttributes) {
				
		ServiceResult result = null;
		
	    result = service.removeQnA(qandaCode);
	    
	    String viewName = null;
	    String message = null;
	    	    
	    if(result.equals(ServiceResult.OK)){
	    	viewName = "redirect:/project/qnaUserList.do";
	    	message = "삭제 성공";
	    }else {
	    	viewName = "redirect:/project/qnaView.do?QnANo="+qandaCode;
	    	message = "삭제 실패";
	    }
	    
	    redirectAttributes.addFlashAttribute("message",message);
	    return viewName;
	}
}
