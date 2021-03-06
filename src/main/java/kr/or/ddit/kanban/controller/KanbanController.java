package kr.or.ddit.kanban.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.kanban.service.KanBanService;
import kr.or.ddit.task.service.TaskService;
import kr.or.ddit.vo.KanbanVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.SLinkedList;
import kr.or.ddit.vo.TaskVO;

@Controller
public class KanbanController {

	
	@Inject
	private TaskService taskservice;
	
	@RequestMapping(value = "project/{pCode}/kanban/kanban.do", method=RequestMethod.GET)
	public String Access(
			Model model,
			
			@PathVariable("pCode") String pCode,
			@AuthenticationPrincipal(expression="authMember") MemberVO authMember
			) {
		TaskVO task = new TaskVO();
		task.setpCode(pCode);
		task.setMemId(authMember.getMemId());
		/*kanban.setpCode(pCode);
		kanban.setMemId(authMember.getMemId());*/
		
		List<TaskVO> taskList = taskservice.justKanbanList(task);
		model.addAttribute("taskList", taskList);
		model.addAttribute("authMember", authMember);
		//model.addAttribute("map", map);
		
		return "kanban/kanban";
	}
	
	@RequestMapping(value = "project/{pCode}/kanban/kanban.do", method=RequestMethod.POST)
	public String selectKanbanCardList(
			@ModelAttribute("kanban") TaskVO kanban,
			@PathVariable("pCode") String pCode,
			@AuthenticationPrincipal(expression="authMember") MemberVO authMember,
			Model model
			
			){
		
		kanban.setpCode(pCode);
		kanban.setMemId(authMember.getMemId());
		
		ServiceResult result = taskservice.stateCard(kanban);
		model.addAttribute("result", result);
		
		return "kanban/kanban";
	
		
	}
}
