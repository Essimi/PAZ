package kr.or.ddit.alarm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.alarm.service.AlarmService;
import kr.or.ddit.vo.AlarmVO;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AlarmMainViewController {
	
	@Inject
	private AlarmService service;
	
	@RequestMapping("project/{pCode}/alarm/alarmView.do")
	@ResponseBody
	public Map<String, Object> alarmInfo(
			
			@AuthenticationPrincipal(expression="authMember") MemberVO authMember
			, @PathVariable("pCode") String pCode
			
			) {
		
		log.info("지금 이까지는 오고있는지를 확인하기 위해서");
		
		Map<String, String> info = new HashMap<>();
		
		info.put("memId", authMember.getMemId());
		info.put("pCode", pCode);
		
		int alarmNumber = service.selectTotalAlarm(info);
		List<AlarmVO> alarmPreviewList = service.selectAlarmPreview(info);
		
		Map<String, Object> result = new HashMap<>();
		
		result.put("count", alarmNumber);
		result.put("alarmPreviewList", alarmPreviewList);
		
		return result;
		
	}

}