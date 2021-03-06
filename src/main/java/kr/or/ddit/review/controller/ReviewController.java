package kr.or.ddit.review.controller;

import javax.inject.Inject;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.review.service.ReviewService;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ReviewVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ReviewController {
	
	@Inject
	ReviewService service;
	
	
	public void updateReviewStatus (){
		
		ServiceResult result = service.updateReviewStatus();
		
		log.info("***********"+ result.toString() + "****************");

	}
	
	
	@RequestMapping("review/reviewUpdate.do")
	@ResponseBody
	public String reviewSave(@ModelAttribute("review") ReviewVO review,
			 				 @AuthenticationPrincipal(expression="authMember") MemberVO authMember) {
		
		
		log.info("여기까진 온다 마 : {}", review);
		ServiceResult result = null;
		
		review.setMemId(authMember.getMemId());
		
		result = service.insertreview(review);
		
		if(result == ServiceResult.OK) {	
			authMember.setReviewStatus("0");
		}
		
		
		return result.toString();
	}
	
	@RequestMapping("review/reviewDelete.do")
	@ResponseBody
	public String reviewDelete(@AuthenticationPrincipal(expression="authMember") MemberVO authMember) {
		
		return null;
		
	}
}
