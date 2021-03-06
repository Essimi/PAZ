package kr.or.ddit.calendar.controller;

import java.io.IOException;

import javax.inject.Inject;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.calendar.service.CalendarService;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.vo.CalendarVO;
import kr.or.ddit.vo.MeetingVO;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CalendarInsertController {

	@Inject
	private CalendarService service;

		@RequestMapping("project/{pCode}/calendar/calendarInsert.do")
		public String CalendarInsert(
				@ModelAttribute("calendar") CalendarVO calendar,
				@PathVariable("pCode") String pCode,
				@AuthenticationPrincipal(expression="authMember") MemberVO authMember
				){
			return "calendar/calendarWrite";
		}
		
		@RequestMapping(value="project/{pCode}/calendar/calendarInsert.do", method = RequestMethod.POST)
		public String CalendarController(
				@Validated(InsertGroup.class) @ModelAttribute("calendar") CalendarVO calendar,
				Errors errors,
				Model model,
				@PathVariable("pCode") String pCode,
				@AuthenticationPrincipal(expression="authMember") MemberVO authMember
				) throws IOException {
			
			log.info("컨트롤러 들어옴 {} ", calendar.getScheduleName());
			
			log.info("asdasdasd {}", calendar);
			
			String viewName = null;
			String message = null;
			
			calendar.setpCode(pCode);
			
			if(!errors.hasErrors()) {
				ServiceResult result = service.createCalendar(calendar);
				
				log.info("service {}" , result);
				
				switch(result) {
				case OK:
					viewName = "redirect:/project/" + pCode + "/calendar/calendarList.do";
					break;
				case FAILED:
					viewName = "calendar/calendarWrite";
					message = "서버 오류, 잠시뒤에 다시 해보슈";
					break;
				}
			}else {
				return "calendar/calendarWrite";
			}
			
			model.addAttribute("calendar", calendar);
			model.addAttribute("message", message);
			
			return viewName;
			
		}
	}
