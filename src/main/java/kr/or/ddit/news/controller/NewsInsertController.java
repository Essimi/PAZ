package kr.or.ddit.news.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.news.service.NewsService;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.NewsVO;
import kr.or.ddit.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class NewsInsertController {
	
	@Inject
	private NewsService service;


		@RequestMapping(value = "project/{pCode}/news/newsInsert.do", method=RequestMethod.GET)
		public String getInsert(
				@ModelAttribute("news") NewsVO news,
				@PathVariable("pCode") String pCode,
				@AuthenticationPrincipal(expression="authMember") MemberVO authMember
				){
			return "news/newsWrite";
		}
		
		@RequestMapping(value="project/{pCode}/news/newsInsert.do", method=RequestMethod.POST)
		public String InsertController(
				@ModelAttribute("news") NewsVO news,
				Errors errors,
				Model model,
				@PathVariable("pCode") String pCode,
				@AuthenticationPrincipal(expression="authMember") MemberVO authMember
				) throws IOException {
			
			String viewName = null;
			String message = null;
			news.setpCode(pCode);
			news.setMemId(authMember.getMemId());
			news.setMemNickname(authMember.getMemNickname());
			
			if(!errors.hasErrors()) {
				ServiceResult result = service.createNews(news);
				
				log.info("여ㅑ기 컨트롤러 {}", result.toString());
				switch(result) {
				case OK:
					viewName = "redirect:/project/{pCode}/news/newsList.do";
					break;
				}
			}else {
					return "news/newsWrite";
				}
			model.addAttribute("news", news);
			model.addAttribute("message", message);
			
			return viewName;
			}
			
			
		}
	
