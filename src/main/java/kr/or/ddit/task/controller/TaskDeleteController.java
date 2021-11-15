package kr.or.ddit.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaskDeleteController {
	@RequestMapping("task/taskDelete.do")
	public String Access(){
		return "task/taskList";
	}
}