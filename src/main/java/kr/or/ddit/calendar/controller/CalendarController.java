package kr.or.ddit.calendar.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.calendar.service.CalendarService;
import kr.or.ddit.vo.CalendarVO;
import kr.or.ddit.vo.CalendarWrapper;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CalendarController {
	
@Inject
CalendarService service;


	@ResponseBody
	@RequestMapping(value = "project/{pCode}/calendar/calendarfordata.do", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<CalendarWrapper> getCalendarList(
			@PathVariable("pCode") String pCode,
			@AuthenticationPrincipal(expression="authMember") MemberVO authMember
			) {
		
			
		PagingVO<CalendarVO> pagingVO = new PagingVO<>();
		CalendarVO calendar = new CalendarVO();
		calendar.setpCode(pCode);
		pagingVO.setDetailSearch(calendar);
		
		List<CalendarVO> dataList = service.selectCalendarList(pagingVO);
		pagingVO.setDataList(dataList); //캘린더 하나당 레퍼하나
		
		List<CalendarWrapper> calendarWrappers = new ArrayList<>();
		
		//dataList 반복문
		for(CalendarVO tmp : dataList) {
			//calendar 대상 wrapper
			log.info("test : {}", dataList);
			CalendarWrapper tmp2 = new CalendarWrapper(tmp);
			calendarWrappers.add(tmp2);
			log.info("calendar : {}", calendarWrappers);
		}
		
		return calendarWrappers;
	}
	
	@RequestMapping(value = "project/{pCode}/calendar/calendarMain.do")
	public String Access(
			@PathVariable("pCode") String pCode,
			@AuthenticationPrincipal(expression="authMember") MemberVO authMember
			) {
		
		return "calendar/calendarMain";
	}
}
