package kr.or.ddit.dashboard.controller;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.dashboard.sevice.PEDashBoardService;
import kr.or.ddit.vo.DashBoardVO;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PEDashBoard {
	
	@Inject
	private PEDashBoardService service;
	
	// 해당 프로젝트에서의 내 총 업무 수량과, 지금까지 완료한 업무의 수량을 출력합니다.
	@RequestMapping("project/{pCode}/projectPEStatus.do")
	public String projectMyStatus(@AuthenticationPrincipal(expression="authMember") MemberVO authMember,
								@PathVariable("pCode") String pCode, Model model) {

		String memId = authMember.getMemId();
		
		DashBoardVO dashBoard = new DashBoardVO();
		
		dashBoard.setpCode(pCode);
		dashBoard.setMemId(memId);
				
		// 해당 프로젝트에서의 내 총 업무 수량과, 지금까지 완료한 업무의 수량을 출력합니다.
		DashBoardVO myStatus = service.projectMyStatus(dashBoard);
		
		// 해당 프로젝트에서의 총 업무 수량과 현재 날짜 기준 일주일 안에 발생한 업무의 수량을 나타냅니다.
		DashBoardVO allTask = service.projectAllTaskStatus(dashBoard);
		
		// 최상위업무(LEVEL 1) 와 해당 상위업무들의 이름, 진행도를 나타냅니다.
		List<DashBoardVO> topTaskStatus = service.topTaskStatus(dashBoard);
		
		// 해당 프로젝트의 올해 발생 이슈들의 달 값만 추출한 후 해당 달의 이슈 발생건을 출력합니다.
		List<DashBoardVO> monthIssue = service.projectMonthIssue(dashBoard);
		
		// 해당 프로젝트의 올해 진행기간 중 가장 많은 이슈가 발생한 달 순으로(4등 까지) 추출합니다.
		List<DashBoardVO> monthIssueRank = service.projectMonthIssueRank(dashBoard);
		
		// 해당 프로젝트에서 나의 업무들의 상태를 추출합니다.
		List<DashBoardVO> myTaskStatus = service.myTaskStatus(dashBoard);
		HashMap<String, Integer> myTaskStatusMap = new HashMap<String, Integer>();
		
		myTaskStatusMap.put("Todo", myTaskStatus.get(0).getWorkStatusCount());
		myTaskStatusMap.put("Process",  myTaskStatus.get(1).getWorkStatusCount());
		myTaskStatusMap.put("Done", myTaskStatus.get(2).getWorkStatusCount());
		
		// 해당 프로젝트에서 나의 이슈들의 상태 수 를 추출합니다.
		List<DashBoardVO> myIssueStatus = service.myIssueStatus(dashBoard);
		HashMap<String, Integer> myIssueStatusMap = new HashMap<String, Integer>();
	
		myIssueStatusMap.put("IMPORTANCE001", myIssueStatus.get(0).getImportanceCount());
		myIssueStatusMap.put("IMPORTANCE002", myIssueStatus.get(1).getImportanceCount());
		myIssueStatusMap.put("IMPORTANCE003", myIssueStatus.get(2).getImportanceCount());
		myIssueStatusMap.put("IMPORTANCE004", myIssueStatus.get(3).getImportanceCount());
		
		// 해당 프로젝트에서 개인의 가장 상위 업무의 이슈 발생건 을 추출합니다.
		List<DashBoardVO> rootTaskIssue = service.rootTaskIssue(dashBoard);

		log.info("test1 : {}", myStatus);
		log.info("test2 : {}", allTask);
		log.info("test3 : {}", topTaskStatus);
		log.info("test4 : {}", monthIssue);
		log.info("test5 : {}", monthIssueRank);
		log.info("test6 : {}", myTaskStatusMap);
		log.info("test7 : {}", myIssueStatusMap);
		log.info("test8 : {}", rootTaskIssue);
		
		model.addAttribute("myStatus", myStatus);
		model.addAttribute("allTask", allTask);
		model.addAttribute("topTaskStatus", topTaskStatus);
		model.addAttribute("monthIssue", monthIssue);
		model.addAttribute("monthIssueRank", monthIssueRank);
		model.addAttribute("myTaskStatusMap", myTaskStatusMap);
		model.addAttribute("myIssueStatusMap", myIssueStatusMap);
		model.addAttribute("rootTaskIssue", rootTaskIssue);

		return "dashBoard/pedashboard";
	}
}
