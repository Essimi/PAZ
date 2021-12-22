package kr.or.ddit.alarm.controller;

import javax.inject.Inject;

import org.aspectj.lang.JoinPoint;

import kr.or.ddit.alarm.service.AlarmService;
import kr.or.ddit.vo.IssueVO;
import kr.or.ddit.vo.TaskVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AlarmDeleteControllerAOP {
	
	@Inject
	private AlarmService service;
	
	public void noticeAlarmDeleteController(
			JoinPoint joinPoint
			){
		
		Object[] param = joinPoint.getArgs();
		String postCode = (String) param[0];
		
		service.deleteAlarmAOP(postCode);
		
	}
	
	public void taskAlarmDeleteController(
			JoinPoint joinPoint
			){
		
		Object[] param = joinPoint.getArgs();
		TaskVO task = (TaskVO) param[0];
		String postCode = task.getWorkCode();
		
		service.deleteAlarmAOP(postCode);
		
	}
	
	
	public void issueAlarmDeleteController(
			JoinPoint joinPoint
			){
		
		Object[] param = joinPoint.getArgs();
		IssueVO issue = (IssueVO) param[0];
		String postCode = issue.getIssueCode();
		
		service.deleteAlarmAOP(postCode);
		
	}

}
