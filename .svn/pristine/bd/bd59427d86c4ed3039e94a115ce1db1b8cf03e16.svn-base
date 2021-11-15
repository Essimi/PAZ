package kr.or.ddit.setting.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.project.service.ProjectService;
import kr.or.ddit.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemberDeleteController {
	
	@Inject
	ProjectService service;
	
	@RequestMapping("setting/deleteMember.do")
	@ResponseBody
	public String deleteMember (@RequestParam("deleteMember") String deleteMember,
							  @SessionAttribute("project") ProjectVO project) {
		
		log.info("바꾸기 전 {} ", project.getMemId());
		
		project.setMemId(deleteMember);
		
		log.info("바꾸고 나서 {} ", project.getMemId());
		
		ServiceResult result = service.deleteProjectMember(project);
		
		return result.toString();

	}
	

}
