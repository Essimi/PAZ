package kr.or.ddit.task.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.task.service.TaskService;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.TaskVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("project/{pCode}/task/taskInsert.do")
public class TaskInsertController {
	
	@Inject
	TaskService service;
	
	@RequestMapping
	public String Access(@SessionAttribute("memList") List<ProjectVO> memList,
						 @PathVariable("pCode") String pCode,
					     Model model){
		
		
		log.info("여기 멤버 리스트 봐보ㅏ 인서트 : {}", memList);
		model.addAttribute("memList", memList);
		
		
		return "task/taskCreate";
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String taskInsert(@ModelAttribute("data") TaskVO task,
							 @SessionAttribute("project") ProjectVO project) {
		
		log.info("여기 taskInsert 야 : {} ", task);
		
		String topWorkCode = task.getTopWorkCode();
		 
		// 상위 업무 등록 시 -> 잘라주기.
		if(!StringUtils.isEmpty(topWorkCode)) {
			
			topWorkCode = topWorkCode.trim().substring(0, 9);
		}
			 
		// 상위 업무 코드 넣어주기 
		task.setTopWorkCode(topWorkCode);
	
		// taskVO 에 pCode 넣기
		task.setpCode(project.getpCode());
		
		log.info("여기 데이터 : {}", task);
		
		ServiceResult result = service.insertTask(task);

		return result.toString();
	}
}