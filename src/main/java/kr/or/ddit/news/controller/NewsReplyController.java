package kr.or.ddit.news.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.news.service.NewsReplyService;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.NewsReplyVO;
import kr.or.ddit.vo.NewsVO;
import kr.or.ddit.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class NewsReplyController {
	
	@Inject
	private NewsReplyService service;
	
	@ResponseBody
	@RequestMapping(value = "/news/newsReplyList.do")
	private List<NewsReplyVO> newsReplyList(
			@ModelAttribute("newsReply") NewsReplyVO reply,
			@RequestParam("newsCode") String newsCode,
			HttpSession session,
			@AuthenticationPrincipal(expression="authMember") MemberVO authMember
			) {
		
		ProjectVO projectCode = (ProjectVO) session.getAttribute("project");
		reply.setNewsCode(newsCode);
		reply.setMemId(authMember.getMemId());
		reply.setMemNickname(authMember.getMemNickname());
		
		NewsReplyVO newsReply = new NewsReplyVO();
		

		
		return service.newsReplyList(newsReply);
		
			
		
	}
	
	
	@RequestMapping(value = "/news/newsReplyInsert.do", method=RequestMethod.POST)
	@ResponseBody
	public String replyInsert(
			@ModelAttribute("newsReply") NewsReplyVO newsReply,
			HttpSession session,
			@AuthenticationPrincipal(expression="authMember") MemberVO authMember
			){
		
		log.info("test : {}", newsReply);
		newsReply.setMemId(authMember.getMemId());
		newsReply.setMemNickname(authMember.getMemNickname());
		
		ServiceResult result = service.createReply(newsReply);
		
		if(result == ServiceResult.OK) {
			return "success";
		}else {
			return "fail";
		}
		
	}
	
	@RequestMapping(value = "/news/newsReplyUpdate.do", method=RequestMethod.POST)
	@ResponseBody
	public String replyUpdate(
			@ModelAttribute("newsReply") NewsReplyVO newsReply,
			HttpSession session,
			@AuthenticationPrincipal(expression="authMember") MemberVO authMember
			) {
		newsReply.setMemId(authMember.getMemId());
		newsReply.setMemNickname(authMember.getMemNickname());
		
		log.info("updatetest : {}", newsReply);
		ServiceResult result = service.modifyReply(newsReply);
		
		if(result == ServiceResult.OK) {
			return "success";
		}else {
			return "fail";
		}
		
	}
	
	@RequestMapping(value = "/news/newsReplyDelete.do")
	@ResponseBody
	public String replyDelete(
			@ModelAttribute("newsReply") NewsReplyVO newsReply,
			Model model,
			HttpSession session,
			@AuthenticationPrincipal(expression="authMember") MemberVO authMember
			) {
		newsReply.setMemId(authMember.getMemId());
		newsReply.setMemNickname(authMember.getMemNickname());
		
		log.info("updatetest : {}", newsReply);
		ServiceResult result = service.removeReply(newsReply);
		
		model.addAttribute("newsReply", newsReply);
		
		
		if(result == ServiceResult.OK) {
			return "OK";
		}else {
			return "fail";
		}
		
	}

	
}