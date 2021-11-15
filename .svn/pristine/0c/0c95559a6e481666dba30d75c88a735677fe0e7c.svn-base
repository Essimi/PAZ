package kr.or.ddit.calendar.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.CalendarVO;
import kr.or.ddit.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;

@Repository
public interface CalendarDAO {
	
	public List<CalendarVO> selectCalendarList(PagingVO<CalendarVO> pagingVO);
	
	public int insertCalendar(CalendarVO calendar);
	
	public int selectTotalRecord(PagingVO<CalendarVO> pagingVO);
	
	public CalendarVO selectCalendar(CalendarVO calendar);
	
	public int updateCalendar(CalendarVO calendar);
	
	public int deleteCalendar(CalendarVO calendar);
	

}
