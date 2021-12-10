package kr.or.ddit.timer.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.timer.dao.TimerDAO;
import kr.or.ddit.vo.TimerVO;

@Service
public class TimerServiceImpl implements TimerService {
	
	@Inject
	private TimerDAO timerDao;
	
	@Override
	public TimerVO OnOffInfo(String memId) {
		
		return timerDao.OnOffInfo(memId);
	
	}

	@Transactional
	@Override
	public ServiceResult timerStart(TimerVO timer) {
		
		ServiceResult result = null;
		
		int rowcnt = timerDao.timerStart(timer);
		
		if(rowcnt > 0) {
			
			result = ServiceResult.OK;
			
		}else {
			
			result = ServiceResult.FAILED;
			
		}
		
		return result;
		
	}

	@Transactional
	@Override
	public ServiceResult timerEnd(TimerVO timer) {
		
		ServiceResult result = null;
		
		int rowcnt = timerDao.timerEnd(timer);
		
		if(rowcnt > 0) {
			
			result = ServiceResult.OK;
			
		}else {
			
			result = ServiceResult.FAILED;
			
		}
		
		return result;
		
	}
}
