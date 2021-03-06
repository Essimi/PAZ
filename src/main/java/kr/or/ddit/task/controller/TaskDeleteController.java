package kr.or.ddit.task.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.task.service.TaskService;
import kr.or.ddit.vo.TaskVO;

@Controller
public class TaskDeleteController {
	
	@Inject
	TaskService service;
	
	@RequestMapping("task/taskDelete.do")
	@ResponseBody
	public String Access(@RequestParam("workCode") String workCode){
		
		TaskVO task = new TaskVO();
		
		task.setWorkCode(workCode);
		
		ServiceResult result = service.deleteTask(task);
		
		return result.toString();
	}
}