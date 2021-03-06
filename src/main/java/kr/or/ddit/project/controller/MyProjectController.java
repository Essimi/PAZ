package kr.or.ddit.project.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.common.noticeProject.Service.ProjectNoticeService;
import kr.or.ddit.dashboard.sevice.PEDashBoardService;
import kr.or.ddit.project.service.ProjectService;
import kr.or.ddit.project.service.RequestProjectService;
import kr.or.ddit.vo.CalendarVO;
import kr.or.ddit.vo.DashBoardVO;
import kr.or.ddit.vo.IssueVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.RequestProjectVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MyProjectController {

	@Inject
	private ProjectService service;
	
	@Inject
	private RequestProjectService requestService;
	
	@Inject
	private ProjectNoticeService noticeService;
	
	@Inject
	private PEDashBoardService DashService;
	
	@RequestMapping(value = "project/myprojectList.do", method=RequestMethod.GET)
	public String myProjectList(
			Model model,
			@AuthenticationPrincipal(expression = "authMember") MemberVO member
			){ // 로그인 한 값 세션에 넣고, 나중에 받아올거임.
		
		log.info("일단 타는지에 대해서");
		
		// 내 프로젝트 리스트 
	    ProjectVO projectVO = new ProjectVO();
	    projectVO.setMemId(member.getMemId());
	    
	    List<ProjectVO> dataList = service.selectMyProjectList(projectVO);
	    model.addAttribute("dataList", dataList);
	    
	    
		// 프로젝트 요청 리스트
		List<RequestProjectVO> requestList = requestService.selectRequestList(member);
		
		if(!requestList.isEmpty()) {
			// 요청 리스트 model 에 넣기 
			model.addAttribute("requestListList", requestList);
		}
	
		log.info("iuhiuh{}", requestList);
		
		
		// PL 프로젝트 리스트 
		List<ProjectVO> plList = service.listMyProjectPl(member);
		
		
		if(!plList.isEmpty()) {
			model.addAttribute("plList", plList);
		}
		
		for(int i = 0; i < plList.size(); i++) {
			log.info("plList : {}", plList.get(i).getpCode());
		}
	
		
		model.addAttribute("reviewStatus", member.getReviewStatus());
		
		return "myProject/myProject";
	}



	// 리스트 클릭 시 해당 페이지로 이동 
	@RequestMapping(value="project/{pCode}/projectView.do")
	public String selectMyproject(@RequestParam(value="page", required=false, defaultValue="1") int currentPage, @PathVariable("pCode") String pCode,
								@AuthenticationPrincipal(expression="authMember") MemberVO member, Model model, HttpSession session
								) {
	
		// projectSelect pCode 넘겨줄 VO
		ProjectVO project = new ProjectVO();
		project.setpCode(pCode);
		project.setMemId(member.getMemId());
		
		// 해당 프로젝트에서 회원의 position
		String position = service.selectPosition(project).getPosition();
		
		// 해당 프로젝트의 모든 정보 받아옴 - memId 와 position 도 넣어줌
		ProjectVO projectAll = service.selectProject(project);
		projectAll.setpCode(pCode);
		projectAll.setMemId(member.getMemId());
		projectAll.setPosition(position);
		
		// 근데 이미 jsp에서 position 으로 받은게 많아서 걍 놔둘게요  
		session.setAttribute("position", position);
		session.setAttribute("project", projectAll);
		

		
//		 ----------- 프로젝트 메인페이지 정보 관련 Code 입니다.
//		사용한 VO - DashBoard / Issue / Calendar
//		사용한 Service, DAO - DashBoard
		
//		로그인한 프로젝트의 총 업무 수량, 진행중인 업무 수량, 완료된 업무 수량을 불러옵니다.
		DashBoardVO projectWorkCount = DashService.projectWorkCount(pCode);
		
//		로그인한 프로젝트의 긴급 이슈 리스트를 출력합니다.
		List<IssueVO> mainIssueList = DashService.mainIssueList(pCode);

//		해당 프로젝트의 참여자들을 불러옵니다.
		List<DashBoardVO> memberList = DashService.memberList(pCode);
		
// 		스케쥴 리스트를 불러옵니다.
		List<CalendarVO> projectMainCalendarList = DashService.projectMainCalendarList(pCode);
		
		
		log.info("test1 {}", projectWorkCount);
		log.info("test2 {}", mainIssueList);
		log.info("test3 {}", memberList);
		log.info("test4 {}", projectMainCalendarList);
		
		// 진입한 프로젝트의 프로젝트 정보를 가져옵니다.
		// 상단에서 projectAll 에 이미 모든 정보가 담겨있습니다.
		
		log.info("test : {}", projectAll);
		model.addAttribute("projectAll",projectAll);
		model.addAttribute("projectWorkCount",projectWorkCount);
		model.addAttribute("mainIssueList",mainIssueList);
		model.addAttribute("memberList",memberList);
		model.addAttribute("projectMainCalendarList",projectMainCalendarList);
		
		return "project/projectView";
			
	}
	
	@RequestMapping(value="project/{pCode}/projectView.do", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public PagingVO<NoticeVO> projectNoticeList(
			
			@RequestParam(value="page", required = false, defaultValue="1") int currentPage
			, @PathVariable("pCode") String pCode
			, Model model
			
			) {
		
		// 메인페이지에 공지사항을 출력하기 위해서******************** 시작
		
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setPartCode(pCode);
		
		PagingVO<NoticeVO> pagingVO = new PagingVO<>(5,5);
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setDetailSearch(noticeVO);
				
		noticeService.selectProjectNoticeList(pagingVO);
		
		// 메인페이지에 공지사항을 출력하기 위해서******************** 종료
				
		return pagingVO;
		
	}
	
}
