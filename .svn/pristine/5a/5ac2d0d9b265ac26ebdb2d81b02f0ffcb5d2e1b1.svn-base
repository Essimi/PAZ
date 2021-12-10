package kr.or.ddit.alarm.dao;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.AlarmVO;

@Repository
public interface AlarmDAO {
	
	/**
	 * 알람 코드 생성 및 조회
	 * @param 
	 * @return
	 */
	public String selectAlarmCode();
	
	/**
	 * 알람 등록
	 * @param
	 * @return
	 */
	public int insertAlarm(AlarmVO alarm);
	
	/**
	 * 알람 수신자 정보 등록
	 * @param
	 * @return
	 */
	public int insertRecipientList(AlarmVO alarm);

}
