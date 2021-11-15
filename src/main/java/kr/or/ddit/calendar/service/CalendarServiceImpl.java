package kr.or.ddit.calendar.service;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.calendar.dao.CalendarDAO;
import kr.or.ddit.common.PKNotFoundException;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.CalendarVO;
import kr.or.ddit.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CalendarServiceImpl implements CalendarService {
	
	@Inject
	private CalendarDAO calendarDAO;

	@Transactional
	@Override
	public ServiceResult createCalendar(CalendarVO calendar) throws IOException {
		ServiceResult result = null;
		int rowcnt = calendarDAO.insertCalendar(calendar);
		if(rowcnt > 0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	@Override
	public List<CalendarVO> selectCalendarList(PagingVO<CalendarVO> pagingVO) {
		int totalRecord = calendarDAO.selectTotalRecord(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		return calendarDAO.selectCalendarList(pagingVO);
	}

	@Override
	public CalendarVO selectCalendar(CalendarVO calendar) {
		CalendarVO calendarOne = calendarDAO.selectCalendar(calendar);
		if(calendarOne == null) {
			throw new PKNotFoundException(calendar + "없음");
		}
		
		return calendarOne;
	
	}

	@Transactional
	@Override
	public ServiceResult modifyCalendar(CalendarVO calendar) {
		ServiceResult result = null;
		int rowcnt = calendarDAO.updateCalendar(calendar);
		
		log.info("테스트 {}", calendar);
		
		if(rowcnt > 0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		
		
		return result;
	}

	@Transactional
	@Override
	public ServiceResult removeCalendar(CalendarVO calendar) {
		ServiceResult result = null;
		log.info("하하 {}", result);
		int rowcnt = calendarDAO.deleteCalendar(calendar);
		log.info("하하 {}", calendar);
		if(rowcnt > 0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

}
