package kr.or.ddit.news.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewsInsertController {


		@RequestMapping("news/newsInsert.do")
		public String Access(){
			return "news/newsWrite";
		}
	}
