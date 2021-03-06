package kr.or.ddit.alarm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.alarm.service.AlarmService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.TaskVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AlarmUpdateController {
	
	@Inject
	private AlarmService service;
	
	@RequestMapping("project/{pCode}/alarm/alarmUpdate.do")
	public String updateAlarm(
			
			@AuthenticationPrincipal(expression="authMember") MemberVO authMember
			, @PathVariable("pCode") String pCode
			, @RequestParam(value="alarmCode", required=true) String alarmCode
			, @RequestParam(value="postCode", required=true) String postCode
			, @RequestParam(value="alarmCheck", required=true) String alarmCheck
			, Model model
			, HttpSession session
			
			) {
		
		log.info("일단 이곳을 타는지 확인한다*********************************");
		
		Map<String, String> info = new HashMap<>();
		
		info.put("myId", authMember.getMemId());
		info.put("alarmCode", alarmCode);
		
		if (alarmCheck.equals("1")) {
			ServiceResult result = service.updateAlarm(info);
		}
		
		String viewName = null;
		
		if (postCode.contains("NOTICE")) {
			viewName = "redirect:/project/" + pCode + "/projectNotice/projectNoticeSelect.do?noticeCode=" + postCode;
		} else if (postCode.contains("WORK")) {
			Map<String, String> taskInfo = new HashMap<>();
			
			taskInfo.put("workCode", postCode);
			taskInfo.put("pCode", pCode);
			
			TaskVO task = service.selectTask(taskInfo);
			
			model.addAttribute("task", task);
			
			viewName = "task/taskSelect";
		} else if (postCode.contains("ISSUE")) {
			viewName = "redirect:/project/" + pCode + "/issue/issueSelect.do?issueCode=" + postCode;
		} else {
			viewName = "redirect:/project/" + pCode + "/alarm/alarmList.do";
		}
		
		return viewName;
		
	}

}
