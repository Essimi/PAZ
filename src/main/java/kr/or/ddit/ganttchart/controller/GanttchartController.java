package kr.or.ddit.ganttchart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GanttchartController {
	@RequestMapping("ganttchart/ganttChart.do")
	public String Access(){
		return "ganttchart/ganttChart";
	}
}
