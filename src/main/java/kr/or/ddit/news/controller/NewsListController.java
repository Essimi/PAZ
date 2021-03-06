package kr.or.ddit.news.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.news.service.NewsService;
import kr.or.ddit.project.service.ProjectService;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.NewsVO;
import kr.or.ddit.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class NewsListController {
	
	@Inject
	private NewsService service;
	
	@Inject
	private ProjectService projectService;
	
	@RequestMapping(value = "project/{pCode}/news/newsList.do", method=RequestMethod.GET)
	public String newsList(
			@ModelAttribute("newsVO") NewsVO news,
			@PathVariable("pCode") String pCode,
			Model model,
			@AuthenticationPrincipal(expression="authMember") MemberVO authMember,
			@ModelAttribute("pro") ProjectVO pro
			){
		
		news.setpCode(pCode);
		news.setMemId(authMember.getMemId());
		news.setMemNickname(authMember.getMemNickname());
		news.setMemIkon(authMember.getMemIkon());
		
		List<NewsVO> dataList = service.newsList(news);
		news.setDataList(dataList);
		
		
		model.addAttribute("dataList", dataList);
		pro.setpCode(pCode);
		List<ProjectVO> memList = projectService.listProjectMember(pro);
		
		
		
		model.addAttribute("memList", memList);
		
		return "news/newsList";
	}
	
	@RequestMapping(value ="project/{pCode}/news/newsList.do", method=RequestMethod.POST)
	public String NewsListPost(
			@ModelAttribute("newsVO") NewsVO news,
			Model model,
			@PathVariable("pCode") String pCode,
			@AuthenticationPrincipal(expression="authMember") MemberVO authMember

			) {
		news.setpCode(pCode);
		news.setMemId(authMember.getMemId());
		news.setMemNickname(authMember.getMemNickname());
		
		
		List<NewsVO> dataList = service.newsList(news);
		news.setDataList(dataList);
		
		model.addAttribute("news", news);
		
		return "news/newsList";
		
	}
}
