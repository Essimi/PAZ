package kr.or.ddit.kanban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KanbanController {
	@RequestMapping("kanban.do")
	public String Access(){
		return "menu/kanban";
	}
}
