package kr.or.ddit.alarm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.aspectj.lang.JoinPoint;

import kr.or.ddit.alarm.service.AlarmService;
import kr.or.ddit.enumpkg.AlarmType;
import kr.or.ddit.vo.AlarmVO;
import kr.or.ddit.vo.IssueRecipientVO;
import kr.or.ddit.vo.IssueVO;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.TaskVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AlarmInsertController {
	
	@Inject
	private AlarmService service;
	
	public void noticeAlarmController(
			JoinPoint joinPoint
			){
		
		Object[] param = joinPoint.getArgs();
		NoticeVO notice = (NoticeVO) param[0];
		
		AlarmVO alarm = new AlarmVO();
		
		alarm.setAlarmType(AlarmType.ALARM_TYPE003);
		alarm.setpCode(notice.getPartCode());
		alarm.setAlarmTitle(notice.getNoticeTitle());
		alarm.setAlarmContents(notice.getNoticeContents());
		alarm.setMemId(notice.getMemId());
		alarm.setPostCode(notice.getNoticeCode());
		
		// 수신자 정보
		List<String> recipientList = new ArrayList<>();
		recipientList.add(notice.getPartCode()); // 공지사항은 프로젝트 내의 전체 멤버를 대상으로 한다.
		alarm.setRecipientList(recipientList);
		
		service.insertAlarm(alarm);
		
	}
	
	public void taskAlarmController(
			JoinPoint joinPoint
			){
		
		Object[] param = joinPoint.getArgs();
		TaskVO task = (TaskVO) param[0];
		
		AlarmVO alarm = new AlarmVO();
		
		alarm.setAlarmType(AlarmType.ALARM_TYPE002);
		alarm.setpCode(task.getpCode());
		alarm.setAlarmTitle(task.getWorkName());
		alarm.setAlarmContents(task.getWorkContents());
		// alarm.setMemId("발신자 없음");
		alarm.setPostCode(task.getWorkCode());
		
		// 수신자 정보
		List<String> recipientList = new ArrayList<>();
		recipientList.add(task.getMemId()); // 공지사항은 프로젝트 내의 전체 멤버를 대상으로 한다.
		alarm.setRecipientList(recipientList);
		
		service.insertAlarm(alarm);
		
	}
	
	
	public void issueAlarmController(
			JoinPoint joinPoint
			){
		
		Object[] param = joinPoint.getArgs();
		IssueVO issue = (IssueVO) param[0];
		
		AlarmVO alarm = new AlarmVO();
		
		alarm.setAlarmType(AlarmType.ALARM_TYPE001);
		alarm.setpCode(issue.getpCode());
		alarm.setAlarmTitle(issue.getIssueName());
		alarm.setAlarmContents(issue.getIssueContents());
		alarm.setMemId(issue.getMemId());
		alarm.setPostCode(issue.getIssueCode());
		
		// 수신자 정보
		List<String> recipientList = new ArrayList<>();
		
		List<IssueRecipientVO> issueRecipients = issue.getIssueRecipients();
		
		for (IssueRecipientVO recipient : issueRecipients) {
			recipientList.add(recipient.getMemId());
		}
		
		alarm.setRecipientList(recipientList);
		
		service.insertAlarm(alarm);
		
	}
	
}