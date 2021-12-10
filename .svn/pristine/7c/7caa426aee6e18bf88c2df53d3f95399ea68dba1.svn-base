package kr.or.ddit.dashboardPl.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.dashboardPl.service.PLDashboardService;
import kr.or.ddit.vo.PLDashboardVO;

@Controller
public class PLDashboardController {

	@Inject
	PLDashboardService service;
	
	@RequestMapping("project/{pCode}/projectPLStatus.do")
	public String Access(
			Model model,
			@PathVariable("pCode") String pCode
			) {
		//업무 담당자별 할당 비율
		List<PLDashboardVO> taskManagerRatio = service.taskManagerRatio(pCode);
		model.addAttribute("taskManagerRatio",taskManagerRatio);
		//요청 받은건 요청한 건
		List<PLDashboardVO> issueManagerment = service.issueManagement(pCode);
		model.addAttribute("issueManagerment",issueManagerment);
		
		//긴급업무 상위업무 진척도
		List<PLDashboardVO> topTaskStatus = service.topTaskStatus(pCode);
		model.addAttribute("topTaskStatus", topTaskStatus);
		
		//팀 업무 상태 그래프
		List<PLDashboardVO> teamState = service.teamState(pCode);
		model.addAttribute("teamState", teamState);
		
		//팀 업무 상태 그래프
		List<PLDashboardVO> teamWorkTime = service.teamWorkTime(pCode);
		model.addAttribute("teamWorkTime", teamWorkTime);
		
		
		return "dashBoard/pldashboard";
	}
}

