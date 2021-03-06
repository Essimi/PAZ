package kr.or.ddit.task.controller;



import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.or.ddit.project.service.ProjectService;
import kr.or.ddit.task.service.TaskService;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.TaskVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("project/{pCode}/task/taskList.do")
@Slf4j
public class TaskListController {
	
	@Inject
	TaskService service;
	
	@Inject
	private ProjectService projectService;
	
	@RequestMapping
	public String access(@RequestParam(value="page", required=false, defaultValue = "1") int currentPage,
						 Model model,

						 
						 @AuthenticationPrincipal(expression="authMember") MemberVO authMember,
						 @SessionAttribute("project") ProjectVO project,
						 HttpSession session){

		
		TaskVO task = new TaskVO();
		
		task.setpCode(project.getpCode());
		
		// paging 처리 .. ! ? 
		PagingVO<TaskVO> pagingVO = new PagingVO<>(10,5);
		
		log.info("current :{}", currentPage);
		
		pagingVO.setCurrentPage(currentPage);
		
		// taskVO를 넣어줬음 !
		pagingVO.setDetailSearch(task);
		
		
		// 해당 프로젝트의 업무 리스트 가져오기 ?? 근데 왜 아무것도 안받아주지 ?? 
		service.retrieveTaskList(pagingVO);
		
		// Model 에 저장
		model.addAttribute("pagingVO", pagingVO);
		
		log.info("pagingVOdddd:{}", pagingVO.getDataList());
		
		// 해당 프로젝트 멤버 리스트
		List<ProjectVO> memList = projectService.listProjectMember(project);
		
//		model.addAttribute("memList", memList);
		
		// 일단.. 해놀게요..
		session.setAttribute("memList", memList);
		
		
		
		log.info("이거 포지션 뜨나 봐봐 {} ", project);

		return "task/taskList";
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String taskPost(@RequestParam(value="page", defaultValue = "1") int page,
						   @RequestParam("taskMember") String taskMember,
						   @RequestParam("taskStatus") String taskStatus,
						   @RequestParam("taskImportance") String taskImportance,
						   @RequestParam("taskName") String taskName,
						   @SessionAttribute("project") ProjectVO project,
						   Model model
			) {
		
			//modelAttribute 로 바꿔라...저게뭐냐 ~ !
		
			log.info("여기봐봐 : {}", taskMember);
			log.info("여기봐봐 : {}", taskStatus);
			log.info("여기봐봐 : {}", taskImportance);
			log.info("여기봐봐 : {}", taskName);
		
			TaskVO task = new TaskVO();
			
			task.setMemId(taskMember);
			task.setWorkStatus(taskStatus);
			task.setImportance(taskImportance);
			task.setWorkName(taskName);
			task.setpCode(project.getpCode());
			
			PagingVO<TaskVO> pagingVO = new PagingVO<>(10, 5);
			
			pagingVO.setCurrentPage(page);
			pagingVO.setDetailSearch(task);
		
		
		
			// 해당 프로젝트의 업무 리스트 가져오기
			service.retrieveTaskList(pagingVO);
			
			// Model 에 저장
			model.addAttribute("pagingVO", pagingVO);
			
			// 해당 프로젝트 멤버 리스트
			List<ProjectVO> memList = projectService.listProjectMember(project);
			
			model.addAttribute("memList", memList);
			
		
		return "task/taskList";
		
	}
	
}
