package kr.or.ddit.calendar.controller;

import java.io.IOException;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.calendar.service.CalendarService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.CalendarVO;

@Controller

public class CalendarUpdateController {

	@Inject
	private CalendarService service;
	
	
	@RequestMapping(value = "calendar/calendarUpdate.do", method=RequestMethod.GET)
	public String getCalendarModifyForm(
			 CalendarVO calendar,
			 Model model
			 
			) {
		
		CalendarVO calendarOne = service.selectCalendar(calendar);
		
		model.addAttribute("calendar", calendarOne);
		
		return "calendar/calendarModify";
		
	}
	
	@RequestMapping(value = "calendar/calendarUpdate.do", method=RequestMethod.POST)
	public String CalendarUpdateController(
			@ModelAttribute("calendar") CalendarVO calendar,
			Errors errors,
			Model model
			) throws IOException{
		
		String viewName = null;
		String message = null;
		
		if(!errors.hasErrors()) {
			ServiceResult result = service.modifyCalendar(calendar);
			
			switch(result) {
			case OK:
				viewName = "redirect:/calendar/calendarList.do";
				break;
			case FAILED:
				viewName = "calendar/calendarModify";
				message = "서버 오류, 잠시 후 다시 실행해주세요.";
				break;
			}
		}
		
		model.addAttribute("calendar", calendar);
		model.addAttribute("message", message);
		
		return viewName;
	}
	
	
	
			
}
