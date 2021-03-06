package kr.or.ddit.ganttChartTW.contoller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.project.service.ProjectService;
import kr.or.ddit.task.service.TaskService;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.TaskVO;


@Controller
public class GanttChartTWController {
	
	@Inject
	TaskService service;
	
	@Inject
	private ProjectService projectService;
	
	@RequestMapping(value = "project/{pCode}/ganttChartTW/ganttChartTW.do", method=RequestMethod.GET)
	public String JustTaskList(
			//@RequestParam String need,
			Model model,
			@PathVariable("pCode") String pCode,
			@ModelAttribute("pro") ProjectVO pro
			){
		
		//project에 속해있는 멤버를 jsp로 List형태로 보내고 싶다 
		TaskVO task = new TaskVO();
		task.setpCode(pCode);
		
		
		List<TaskVO> taskList = service.justTaskList(task);
		model.addAttribute("taskList", taskList);
		pro.setpCode(pCode);
		List<ProjectVO> memList = projectService.listProjectMember(pro);
		
		model.addAttribute("memList", memList);
		
		
		
		return "ganttChartTW/ganttChartTW";
		
	}


}
