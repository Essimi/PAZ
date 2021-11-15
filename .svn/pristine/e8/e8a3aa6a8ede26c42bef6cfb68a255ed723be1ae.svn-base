package kr.or.ddit.setting.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.or.ddit.project.service.ProjectService;
import kr.or.ddit.project.service.RequestProjectService;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.RequestProjectVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemberSettingController {
	
	@Inject
	ProjectService service;
	
	@Inject
	RequestProjectService requestService;
	
	@RequestMapping("setting/memberSetting.do")
	public String memberSetting(@SessionAttribute("project") ProjectVO project,
								HttpSession session) {
	
		log.info("여기 멤버관리 컨트롤러 : {} ", project.toString());
		// project엔 pCode, memId 담겨있음.
		
		List<ProjectVO> memberList = service.listProjectMember(project);
		
		log.info("여기 멤버관리 리스트 봐봐 : {}", memberList.get(0).toString());
		
		
		// 멤버 요청 대기 리스트 
		List<RequestProjectVO> requestList = requestService.listRequestProjectHistory(project);
		
		session.setAttribute("requestList", requestList);
		session.setAttribute("memberList", memberList);
		
		log.info("세션임 : {} " , session.getAttribute("memberList").toString());
		log.info("세션임 : {} " , session.getAttribute("requestList").toString());
		
		return "setting/memberSetting";
	}

}
