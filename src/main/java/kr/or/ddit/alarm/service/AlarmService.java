package kr.or.ddit.alarm.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.AlarmVO;

public interface AlarmService {
	
	/**
	 * 멤버 리스트 조회
	 * @param 
	 * @return 
	 */
	public List<String> selectMemberList(String pCode);
	
	/**
	 * 알람 등록
	 * @param NoticeVO
	 * @return
	 */
	public ServiceResult insertAlarm(AlarmVO alarm);
	
	/**
	 * 알람 리스트 조회
	 * @param 
	 * @return 
	 */
	public List<AlarmVO> selectAlarmList(Map<String, String> info);
	
	/**
	 * 알람 삭제
	 * @param 
	 * @return 
	 */
	public ServiceResult deleteAlarm(Map<String, String> info);
	
	/**
	 * 알람 상태 변경
	 * @param 
	 * @return 
	 */
	public ServiceResult updateAlarm(Map<String, String> info);

}
