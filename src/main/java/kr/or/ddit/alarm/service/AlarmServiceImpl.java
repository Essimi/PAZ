package kr.or.ddit.alarm.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.alarm.dao.AlarmDAO;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.AlarmVO;
import kr.or.ddit.vo.TaskVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AlarmServiceImpl implements AlarmService {
	
	@Inject
	private AlarmDAO dao;
	
	@Override
	public int selectTotalAlarm(Map<String, String> info) {
		int totalNumber = dao.selectTotalAlarm(info);
		return totalNumber;
	}
	
	@Override
	public List<AlarmVO> selectAlarmPreview(Map<String, String> info) {
		List<AlarmVO> alarmPreviewList = dao.selectAlarmPreview(info);
		return alarmPreviewList;
	}
	
	@Override
	public List<String> selectMemberList(String pCode) {
		List<String> memberList = dao.selectMemberList(pCode);
		return memberList;
	}

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

	@Override
	public List<AlarmVO> selectAlarmList(Map<String, String> info) {
		List<AlarmVO> alarmList = dao.selectAlarmList(info);
		log.info("알람리스트에는 무엇이 담기었는가/서비스단 {}",alarmList);
		return alarmList;
	}

	@Override
	public ServiceResult deleteAlarm(Map<String, String> info) {
		ServiceResult result = null;
		
		int deleteResult = dao.deleteAlarm(info);
		
		if (deleteResult > 0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		
		return result;
	}

	@Override
	public ServiceResult updateAlarm(Map<String, String> info) {
		ServiceResult result = null;
		
		int deleteResult = dao.updateAlarm(info);
		
		if (deleteResult > 0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		
		return result;
	}

	@Override
	public TaskVO selectTask(Map<String, String> info) {
		TaskVO task = dao.selectTask(info);
		return task;
	}

	@Override
	public ServiceResult deleteAlarmAOP(String postCode) {
		ServiceResult result = null;
		
		int deleteResult = dao.deleteAlarmAOP(postCode);
		
		if (deleteResult > 0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		
		return result;
	}

}
