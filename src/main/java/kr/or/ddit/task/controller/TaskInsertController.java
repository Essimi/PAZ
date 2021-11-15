package kr.or.ddit.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaskInsertController {
	@RequestMapping("task/taskInsert.do")
	public String Access(){
		return "task/taskCreate";
	}
}