package kr.or.ddit.alarm.service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.AlarmVO;

public interface AlarmService {
	
	/**
	 * 알람 등록
	 * @param NoticeVO
	 * @return
	 */
	public ServiceResult insertAlarm(AlarmVO alarm);

}
