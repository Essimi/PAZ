package kr.or.ddit.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaskEmergencyController {
	@RequestMapping("task/emergency.do")
	public String Access() {
		return "task/taskemergency";
	}
}
