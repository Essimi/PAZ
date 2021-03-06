package kr.or.ddit.task.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.task.service.TaskService;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.TaskVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j

public class TaskUpdateController {
	
	@Inject
	TaskService service;
	
	// 업무 수정 페이지 
	@RequestMapping(value="project/{pCode}/task/taskUpdate.do", method=RequestMethod.POST)
	public String access(@ModelAttribute("task") TaskVO task,
						 @PathVariable("pCode") String pCode){
		
		log.info("여기 업무 수정 : {} ", task);
		
		return "task/taskModify";
	}
	
	// 상위 업무 검색
	@RequestMapping(value="task/taskSearch.do", method=RequestMethod.POST)
	@ResponseBody
	public List<TaskVO> search(@SessionAttribute("project") ProjectVO project,
						 @RequestParam("searchWorkName") String searchWorkName) {
		
		log.info("여기 서치 단어 : {}", searchWorkName);
		// pCode, name
		
		TaskVO task = new TaskVO();
		task.setWorkName(searchWorkName);
		task.setpCode(project.getpCode());
		
		log.info("여기 테스크 투스트링 : {} " , task.toString());
		
		List<TaskVO> searchList = service.selectTopTaskSearchList(task);
		
		log.info("여긴 서치 리스트 :  {} " , searchList.toString());
		
		return searchList;
	}
	
	
	
	
	// 업무 수정 확인 
	@RequestMapping(value="project/{pCode}/task/taskUpdateCheck.do", method = RequestMethod.POST)
	@ResponseBody
	public String taskUpdate(@ModelAttribute("data") TaskVO newTask,
							 @SessionAttribute("project") ProjectVO project
							 ) throws Exception { // 이제 project 아니고 authentic? 거기서 받아와 
		
		String newTopWorkCode = newTask.getTopWorkCode();
		
		// 상위 업무 null 일 때, 아무 값 넣어주기 
		log.info("newTopWorkCode: {} ", newTopWorkCode);
		
		if(newTopWorkCode == null) {
			newTopWorkCode = "null";
		}
		
		// 상위 업무 변경 시 -> 잘라주기.
		if(newTask.getTopWorkCode()!=null && newTask.getTopWorkCode().length() > 9) {
			log.info("여기 타나?");
			log.info("test : {}", newTask);
			newTopWorkCode = newTask.getTopWorkCode().trim().substring(0, 9);
		}
			 
		// 상위 업무 코드 넣어주기 
		newTask.setTopWorkCode(newTopWorkCode);
		
		// progress 맞춰주기
		if(newTask.getProgress().equals("100")) {
			newTask.setProgress("PROGRESS0" + newTask.getProgress());
		}else if(newTask.getProgress().equals("0")){
			newTask.setProgress("PROGRESS0000");
		}
		else {
			newTask.setProgress("PROGRESS00" + newTask.getProgress());
		}

		

		// pCode, modifierId 넣어줌
		newTask.setpCode(project.getpCode());
		newTask.setModifierId(project.getMemId());
	
		log.info("여기봐보바ㅗ바봐봡: {}",newTask.toString());
		
		log.info("asdasdasdasdsad){}", newTask.getTopWorkCode());
		
		// 업데이트 서비스에 newTask 넘김
		ServiceResult result = service.updateTask(newTask);
		
		
		return result.toString();
	}
}
