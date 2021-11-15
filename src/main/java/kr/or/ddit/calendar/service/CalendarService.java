package kr.or.ddit.calendar.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.CalendarVO;
import kr.or.ddit.vo.PagingVO;

public interface CalendarService {
	
	public ServiceResult createCalendar(CalendarVO calendar) throws IOException;
	
	public List<CalendarVO> selectCalendarList(PagingVO<CalendarVO> pagingVO);
	
	public CalendarVO selectCalendar(CalendarVO calendar);
	
	public ServiceResult modifyCalendar(CalendarVO calendar);
	
	public ServiceResult removeCalendar(CalendarVO calendar);
	
	
	

}
