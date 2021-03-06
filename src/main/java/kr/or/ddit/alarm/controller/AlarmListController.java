package kr.or.ddit.alarm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.alarm.service.AlarmService;
import kr.or.ddit.vo.AlarmVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AlarmListController {
	
	@Inject
	private AlarmService service;
	
	@RequestMapping("project/{pCode}/alarm/alarmList.do")
	public String alarmList(
			
			@AuthenticationPrincipal(expression="authMember") MemberVO authMember
			, Model model
			, HttpSession session
			
			) {
		
		Map<String, String> info = new HashMap<String, String>();
		
		// 세션에서 프로젝트 코드를 가져온다.
		ProjectVO project = (ProjectVO) session.getAttribute("project");
		String pCode = project.getpCode();
		
		info.put("memId", authMember.getMemId());
		info.put("pCode", pCode);
		
		List<AlarmVO> alarmList = service.selectAlarmList(info);
		
		model.addAttribute("alarmList",alarmList);
		
		return "alarm/alarmList";
		
	}

}
