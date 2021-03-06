package kr.or.ddit.setting.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.project.service.ProjectService;
import kr.or.ddit.project.service.RequestProjectService;
import kr.or.ddit.vo.MemberVO;
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
	
	// 멤버 설정 페이지 들어갈 떄
	@RequestMapping("project/{pCode}/setting/memberSetting.do")
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
	
	
	// PL 권한 이양 시 
	@RequestMapping("project/{pCode}/setting/plSelect.do")
	@ResponseBody
	public String plSelect(
						   @PathVariable("path") String pCode,
						   @RequestParam("memId") String memId,
						   @RequestParam("position") String position,
						   @AuthenticationPrincipal(expression = "authMember") MemberVO member) {
		
		log.info("여기이이이잉 : {}, {}", memId, position);
		
		
		// memId - 권한 지정자, member.getmemId - 나(현재 PL), position - 내가 등록될 역할, 지정자는 PL로 등록해주면 됨
		
		// PL 지정자 정보VO
		ProjectVO plMember = new ProjectVO();
		plMember.setMemId(memId);
		plMember.setPosition("PL");
		plMember.setpCode(pCode);
		
		// 내(현재 PL) 정보 VO
		ProjectVO pl = new ProjectVO();
		pl.setMemId(member.getMemId());
		pl.setPosition(position);
		pl.setpCode(pCode);
		
		
		// 지정자와 PL 의 정보가 담긴 List
		List<ProjectVO> projectList = new ArrayList<>();
		projectList.add(plMember);
		projectList.add(pl);
		
		// 서비스 호출 - 서비스에서 값을 나눠서 쿼리문 2번 실행 해야함
		ServiceResult result = service.updatePosition(projectList);
		
//		if(result == ServiceResult.OK) {
//			member.setMemRoles(memRoles);
//		}
		
		return result.toString();
		
	}

}
