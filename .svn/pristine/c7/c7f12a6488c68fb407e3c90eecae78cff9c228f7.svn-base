package kr.or.ddit.alarm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.alarm.service.AlarmService;
import kr.or.ddit.enumpkg.ServiceResult;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AlarmDeleteController {
	
	@Inject
	private AlarmService service;
	
	@RequestMapping("alarm/alarmDelete.do")
	@ResponseBody
	public Map<String, String> deleteAlarm(
			
			@RequestParam(value="myId", required=true) String myId
			, @RequestParam(value="alarmCode", required=true) String alarmCode
			, Model model
			, HttpSession session
			
			) {
		
		Map<String, String> info = new HashMap<>();
		
		info.put("myId", myId);
		info.put("alarmCode", alarmCode);
		
		ServiceResult result = service.deleteAlarm(info);
		
		return info;
	}

}
