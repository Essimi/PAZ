package kr.or.ddit.task.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.task.service.TaskService;
import kr.or.ddit.vo.TaskVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TaskSelectViewController {
	
	@Inject
	private TaskService service;
	
	
	@RequestMapping(value="project/{pCode}/task/selectTaskView.do", method = RequestMethod.POST)
	public String acces(@ModelAttribute("taskForm") TaskVO task,
						Model model) {
		
		
		log.info("테스트다 뭐가 다르냐 : {}", task);
		
		TaskVO taskVO = service.selectTask(task);
		
		log.info("qwer {}", taskVO);
		
		task.setModifyHistoryList(taskVO.getModifyHistoryList());
		
		
		model.addAttribute("task", task);
		
		
		log.info("taskttt: {} ", task);

		

		return "task/taskSelect";
	}

}
