package kr.or.ddit.alarm.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.AlarmVO;
import kr.or.ddit.vo.TaskVO;

public interface AlarmService {
	
	/**
	 * 전체 알람 수
	 * @param 
	 * @return 
	 */
	public int selectTotalAlarm(Map<String, String> info);
	
	/**
	 * 미리보기 알람 리스트 조회
	 * @param 
	 * @return 
	 */
	public List<AlarmVO> selectAlarmPreview(Map<String, String> info);
	
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
	
	/**
	 * 업무 상세 조회
	 * @param 
	 * @return 
	 */
	public TaskVO selectTask(Map<String, String> info);
	
	/**
	 * AOP를 통하여 원글이 삭제된 알람을 동시에 삭제한다.
	 * @param 
	 * @return 
	 */
	public ServiceResult deleteAlarmAOP(String postCode);
	
}
