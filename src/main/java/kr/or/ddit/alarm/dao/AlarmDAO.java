package kr.or.ddit.alarm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.AlarmVO;
import kr.or.ddit.vo.TaskVO;

@Repository
public interface AlarmDAO {
	
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
	 * 알람 코드 생성 및 조회
	 * @param 
	 * @return
	 */
	public String selectAlarmCode();
	
	/**
	 * 멤버 리스트 조회
	 * @param 
	 * @return 
	 */
	public List<String> selectMemberList(String pCode);
	
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
	public int deleteAlarm(Map<String, String> info);
	
	/**
	 * 알람 상태 변경
	 * @param 
	 * @return 
	 */
	public int updateAlarm(Map<String, String> info);
	
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
	public int deleteAlarmAOP(String postCode);

}
