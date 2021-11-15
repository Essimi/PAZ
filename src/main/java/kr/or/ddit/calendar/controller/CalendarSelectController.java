package kr.or.ddit.calendar.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.calendar.service.CalendarService;
import kr.or.ddit.vo.CalendarVO;

@Controller
public class CalendarSelectController {
	
	@Inject
	private CalendarService service;

	@RequestMapping(value="/calendar/calendarView")
	public String selectCalendar(
			@RequestParam(value="what", defaultValue="0") CalendarVO calendar,
			Model model
			) {
		
		CalendarVO calendarOne = service.selectCalendar(calendar);
		model.addAttribute("calendarOne", calendarOne);
				
		
		return "calendar/calendarMain";
		
	}
}
