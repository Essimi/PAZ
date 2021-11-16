package kr.or.ddit.news.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.news.service.NewsService;
import kr.or.ddit.vo.NewsVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class NewsListController {
	
	@Inject
	private NewsService service;
	
	@RequestMapping(value = "/news/newsList.do", method=RequestMethod.GET)
	public String newsList(
			@ModelAttribute("newsVO") NewsVO news,
			Model model
			){
		List<NewsVO> dataList = service.newsList(news);
		news.setDataList(dataList);
		
		log.info("dataList {}", news);
		
		
		model.addAttribute("news", news);
		
		log.info("dataList {}", news);
		
		return "news/newsList";
	}
	
	@RequestMapping(value ="/news/newsList.do", method=RequestMethod.POST)
	public String NewsListPost(
			@ModelAttribute("newsVO") NewsVO news,
			Model model

			) {
		
		List<NewsVO> dataList = service.newsList(news);
		news.setDataList(dataList);
		
		log.info("dataList {}", news);
		
		
		model.addAttribute("news", news);
		
		log.info("dataList {}", news);
		
		return "news/newsList";
		
	}
}
