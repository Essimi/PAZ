package kr.or.ddit.news.controller;

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

@Controller
public class NewsUpdateController {

	@Inject
	private NewsService service;

		@RequestMapping(value = "project/{pCode}/news/newsUpdate.do", method=RequestMethod.GET)
		public String getNewsModifyForm(
				NewsVO news,
				Model model,
				@PathVariable("pCode") String pCode,
				@AuthenticationPrincipal(expression="authMember") MemberVO authMember
				){
			news.setpCode(pCode);
			news.setMemId(authMember.getMemId());
			
			NewsVO newsOne = service.selectNews(news);
			
			model.addAttribute("news", newsOne);
			
			
			return "news/newsModify";
		}
		
		@RequestMapping(value = "project/{pCode}/news/newsUpdate.do", method=RequestMethod.POST)
		public String NewsUpdate(
				@PathVariable("pCode") String pCode,
				@AuthenticationPrincipal(expression="authMember") MemberVO authMember,
				@ModelAttribute("news") NewsVO news,
				Errors errors,
				Model model
				) {
			
			String viewName = null;
			String message = null;
			news.setpCode(pCode);
			news.setMemId(authMember.getMemId());
			
			if(!errors.hasErrors()) {
				ServiceResult result = service.modifyNews(news);
				
				switch(result) {
				case OK : 
					viewName = "redirect:/project/" + pCode + "/news/newsList.do";
					break;
				case FAILED:
					viewName = "news/newsModify";
					message = "?????? ??????, ?????? ??? ?????? ??????????????????";
					break;
				}
			}
			
			model.addAttribute("news", news);
			model.addAttribute("message", message);
			
			return viewName;
			
		}
	}