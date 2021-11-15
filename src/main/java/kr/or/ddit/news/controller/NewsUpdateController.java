package kr.or.ddit.news.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewsUpdateController {


		@RequestMapping("news/newsUpdate.do")
		public String Access(){
			return "news/newsModify";
		}
	}