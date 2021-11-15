package kr.or.ddit.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaskListController {
	@RequestMapping("task.do")
	public String Access(){
		return "menu/task";
	}
}
