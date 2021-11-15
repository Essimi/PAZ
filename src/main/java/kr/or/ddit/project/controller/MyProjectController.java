package kr.or.ddit.project.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.project.service.ProjectService;
import kr.or.ddit.project.service.RequestProjectService;
import kr.or.ddit.vo.MemberVO;
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
	
	

	@RequestMapping(value = "project/myprojectList.do", method=RequestMethod.GET)
	public String myProjectList(
			@RequestParam(required = false, defaultValue = "1")int pCode,
			Model model
//			@SessionAttribute(value="authMember", required=true) MemberVO authMember
			){ // 로그인 한 값 세션에 넣고, 나중에 받아올거임.
		
		
		// 내 프로젝트 리스트 
	    ProjectVO projectVO = new ProjectVO();
	      
	    List<ProjectVO> dataList = service.selectMyProjectList(projectVO);
	    model.addAttribute("dataList", dataList);
	    
	    
		// 프로젝트 요청 리스트
		// 일단 아무 아이디나 넣겠습니다.. 된게 없응게 
		MemberVO member = new MemberVO();
		member.setMemId("aa002"); // 임의로 넣은 값임!
		
		List<RequestProjectVO> requestList = requestService.selectRequestList(member);
		
		if(!requestList.isEmpty())
			// 요청 리스트 model 에 넣기 
			model.addAttribute("requestList", requestList);
		
		log.info("iuhiuh{}", requestList);
		
		
		// PL 프로젝트 리스트 
		List<ProjectVO> plList = service.listMyProjectPl(member);
		
		if(!plList.isEmpty())
			model.addAttribute("plList", plList);

		for(int i = 0; i < plList.size(); i++) {
			log.info("plList : {}", plList.get(i).getpCode());
		}
		
		model.addAttribute("memId", "aa002");
		
		
		return "myProject";
	}



		// 리스트 클릭 시 해당 페이지로 이동 
		@RequestMapping(value="project/{projectName}/projectView.do", method=RequestMethod.POST)
		public String selectMyproject(
				@PathVariable String projectName,
				@RequestParam(value="memId") String memId,
				@RequestParam("pCode") String pCodeValue,
				Model model,
				HttpSession session
				) {
			//ProjectVO project = service.selectMyProject();
			//model.addAttribute("project", project);
			
			log.info("Controller까지 옴");
			log.info(pCodeValue);
			log.info(projectName);
			
			
			ProjectVO project = new ProjectVO();
			project.setpCode(pCodeValue);
			project.setMemId(memId);
			
			String position = service.selectPosition(project).getPosition();

			session.setAttribute("position", position);
			session.setAttribute("project", project);
			
			return "project/projectView";
			
		}
	}



