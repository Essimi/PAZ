package kr.or.ddit.news.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewsListController {
	@RequestMapping("news/newsList.do")
	public String Access(){
		return "news/newsList";
	}
}
