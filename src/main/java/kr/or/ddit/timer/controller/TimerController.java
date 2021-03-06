package kr.or.ddit.timer.controller;


import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.timer.service.TimerService;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.TimerVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TimerController {
	
	@Inject
	TimerService service;
	
	@RequestMapping(value = "project/timer/timerStart.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String timerInsert(@AuthenticationPrincipal(expression = "authMember") MemberVO authMember,
							HttpSession session, @RequestParam("timeSum") String timeSum, HttpServletRequest req) {
		
		// 세션에서 필요한 값들을 받아옵니다.
		ProjectVO projectCode = (ProjectVO) session.getAttribute("project");
		String pCode = projectCode.getpCode();
		String memId = authMember.getMemId();
		
		// 메세지를 전송하기 위해 생성합니다.
		String message = null;
		
		// 우선 해당 회원의 상태를 체크합니다.
		TimerVO onOffInfo = new TimerVO();
		onOffInfo = service.OnOffInfo(memId);
		
		log.info("test : {}", timeSum);
		
		if(onOffInfo == null) {
			
			// 첫 출근일 경우 입니다.
			
			// 저장을 위한 time 객체를 생성해줍니다.
			TimerVO time = new TimerVO();
			
			// 데이터를 주입합니다.
			time.setMemId(memId);
			time.setpCode(pCode);
			time.setWhStart(timeSum);
			
			ServiceResult result = null;
			
			// 출근시간을 기록합니다.
			result = service.timerStart(time);
			
			if(result.equals(ServiceResult.OK)) {
				message = "타이머가 시작되었습니다."; // 데이터베이스 저장 성공
				
				// 출퇴근 버튼 변경을 위해 scope 에 등록합니다.
				ServletContext application = req.getServletContext();
				application.setAttribute(memId, "ON");
			}else {
				message = "타이머가 실패하였습니다. 다시 시도해주세요"; // 데이터베이스 저장 실패
			}
			
		}
		
		else if(onOffInfo.getOnOff().equals("ON")) {
			
			// 출근 버튼을 이미 눌렀을 경우 입니다. (출근 상태)
			ServletContext application = req.getServletContext();
			application.setAttribute(memId, "ON");
			message = "회원님은 이미 출근상태 입니다. 출근한 프로젝트의 이름 = " + onOffInfo.getPtitle();
			
		}else if(onOffInfo.getOnOff().equals("OFF")){
			
			// 정상적으로 퇴근을 한 후, 출근버튼을 눌렀을 경우 입니다.(퇴근 상태)
			// null 일 경우 - 첫 출근일 경우 입니다.
			
			// 저장을 위한 time 객체를 생성해줍니다.
			TimerVO time = new TimerVO();
			
			// 데이터를 주입합니다.
			time.setMemId(memId);
			time.setpCode(pCode);
			time.setWhStart(timeSum);
			
			ServiceResult result = null;
			
			// 출근시간을 기록합니다.
			result = service.timerStart(time);
						
			if(result.equals(ServiceResult.OK)) {
				message = "타이머가 시작되었습니다."; // 데이터베이스 저장 성공
				
				// 출퇴근 버튼 변경을 위해 scope 에 등록합니다.
				ServletContext application = req.getServletContext();
				application.setAttribute(memId, "ON");
				
			}else {
				message = "타이머가 실패하였습니다. 다시 시도해주세요"; // 데이터베이스 저장 실패
			}
			
		}
		
		return message;
	}
	
	@RequestMapping(value = "project/timer/timerEndInfo.do", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public TimerVO timerEndInfo(@AuthenticationPrincipal(expression = "authMember") MemberVO authMember, Model model) {
		
		// 세션에서 필요한 값들을 받아옵니다.
		String memId = authMember.getMemId();
		
		TimerVO onOffInfo = new TimerVO();
		onOffInfo = service.OnOffInfo(memId);		
				
		return onOffInfo;
	}
	
	
	
	@RequestMapping(value = "project/timer/timerEnd.do", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String timerEnd(@AuthenticationPrincipal(expression = "authMember") MemberVO authMember,
						   @RequestParam("timeSum") String timeSum, @RequestParam("whCode") String whCode, 
						   HttpServletRequest req) {
			
		String memId = authMember.getMemId();
		
		// 메세지를 보내기 위해 생성해줍니다.
		String message = null;
		
		// 데이터 전송을 위해 객체를 생성해줍니다.
		TimerVO timer = new TimerVO();
		
		// 객체에 데이터를 담아줍니다.
		timer.setMemId(memId);
		timer.setWhCode(whCode);
		timer.setWhEnd(timeSum);
		
		ServiceResult result = service.timerEnd(timer);
		
		if(result.equals(ServiceResult.OK)) {
			
			message = "퇴근이 완료되었습니다.";
			
			// 출근시 넣어준 데이터를 삭제하기 위해 scope 에서 삭제시켜줍니다.
			ServletContext application = req.getServletContext();
			application.removeAttribute(memId);
			
		}else if(result.equals(ServiceResult.FAILED)) {
			
			message = "알 수 없는 이유로 실패하였습니다. 다시 시도해주세요";
			
		}
		
		return message;
		
	}
}
