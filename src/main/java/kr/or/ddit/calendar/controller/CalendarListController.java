package kr.or.ddit.calendar.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.calendar.service.CalendarService;
import kr.or.ddit.vo.CalendarVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.SearchVO;

@Controller
public class CalendarListController {
	
	@Inject
	private CalendarService service;

	@RequestMapping("/calendar/calendarList.do")
	public String CalendarList(
		@RequestParam(value="page", required = false, defaultValue = "1")int currentPage, Model model
			) {
		
		
		
		PagingVO<CalendarVO> pagingVO = new PagingVO<>();
		pagingVO.setCurrentPage(currentPage);
		
		//set
		
		List<CalendarVO> dataList = service.selectCalendarList(pagingVO);
		pagingVO.setDataList(dataList);
		
		model.addAttribute("pagingVO", pagingVO);
		
		return "calendar/calendarList";
		
		
	}
}
	
	
	
	

