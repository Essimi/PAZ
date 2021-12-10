package kr.or.ddit.alarm.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.alarm.dao.AlarmDAO;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.AlarmVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AlarmServiceImpl implements AlarmService {
	
	@Inject
	private AlarmDAO dao;

	@Override
	public ServiceResult insertAlarm(AlarmVO alarm) {
		
		ServiceResult result = null;
		
		String alarmCode = dao.selectAlarmCode();
		
		// 글의 코드를 직접 저장한다.
		alarm.setAlarmCode(alarmCode);
		
		int rowcnt = dao.insertAlarm(alarm);
		
		if (rowcnt > 0) {
			dao.insertRecipientList(alarm);
			result = ServiceResult.OK;	
		} else {
			result = ServiceResult.FAILED;
		}
		
		return result;
		
	}

}
