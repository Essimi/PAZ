package kr.or.ddit.calendar.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.calendar.service.CalendarService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.CalendarVO;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CalendarDeleteController {

	@Inject
	private CalendarService service;

	
	@ResponseBody
	@RequestMapping(value = "project/{pCode}/calendar/calendarDelete.do", method=RequestMethod.GET)
	public Map<String, Object> getCalendarModifyForm(
			 CalendarVO calendar,
			 Model model,
			 @PathVariable("pCode") String pCode,
				@AuthenticationPrincipal(expression="authMember") MemberVO authMember
			 
			) {
		calendar.setpCode(pCode);
		ServiceResult result = service.removeCalendar(calendar);
		model.addAttribute("calendar", calendar);
		
		String message = null;
		
		//vo대신
		Map<String, Object> res = new HashMap<>();
		res.put("result", result);
		
		if(result == ServiceResult.OK) {
			res.put("redirect", "project/{pCode}/calendar/calendarList.do");
			message = "성공하였습니다";

		}else {
			
			message = "실패하였습니다.";
		}
		
		res.put("message", message);
		return res;
		
		
	}
	
	
		@RequestMapping(value = "project/{pCode}/calendar/calendarDelete.do", method=RequestMethod.POST)
		public String Access(
				CalendarVO calendar,
				Model model,
				 @PathVariable("pCode") String pCode,
					@AuthenticationPrincipal(expression="authMember") MemberVO authMember
				){
			calendar.setpCode(pCode);
			
			ServiceResult result = service.removeCalendar(calendar);
			model.addAttribute("calendar", calendar);
			log.info("하하3 {}", calendar);
			
			return "calendar/calendarList";
		}
	}

