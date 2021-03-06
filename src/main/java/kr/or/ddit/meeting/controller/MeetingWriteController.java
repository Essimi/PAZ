package kr.or.ddit.meeting.controller;

import java.io.IOException;
import java.lang.reflect.Parameter;
import java.util.List;

import javax.inject.Inject;

import org.springframework.aop.support.AopUtils;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.meeting.service.MeetingService;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.vo.DataListVO;
import kr.or.ddit.vo.MeetingVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProjectMemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
//@RequestMapping("/project/{pCode}/meeting/write.do")
@RequestMapping("/project/{pCode}/meeting/write.do")
public class MeetingWriteController {
	@Inject
	private MeetingService service;
	
	@Inject
	public void setService(MeetingService service) {
		this.service = service;
		log.info("주입된 target : {}, proxy 여부 : {}", service.getClass().getName(),AopUtils.isAopProxy(service));
	}
	
	
	@RequestMapping
	public String Access(@ModelAttribute("meeting") ProjectMemberVO projectMemberVO
			,@PathVariable("pCode") String pCode
//			,@RequestParam(value="pCode", required=true) String pCode
			,@AuthenticationPrincipal(expression="authMember") MemberVO authMember
		    ,Model model
			) {
		
		DataListVO<ProjectMemberVO> dataListVO = new DataListVO<>();
		dataListVO.setpCode(pCode);
		
		String authMemberMemId = authMember.getMemId();
		
		service.chackmember(dataListVO);	//n개의 값을 서비스 에서 받아온다.
		
		model.addAttribute("authMemberMemId", authMemberMemId);
		model.addAttribute("dataListVO",dataListVO);	//이것이 jsp EL함수로 쓰임
		
		return "meeting/meetingWrite";
				
	}
	

	@RequestMapping(method=RequestMethod.POST)
	public String meetingInsertPost(@Validated(InsertGroup.class) @ModelAttribute("meetingVO") MeetingVO meeting
			,Errors errors
			,@PathVariable("pCode") String pCode
			,@AuthenticationPrincipal(expression="authMember") MemberVO authMember
			,Model model
			
			){
		
		log.info("test : {}", meeting);
		
		String viewName = null;
		String message = null;
		
		
		DataListVO<ProjectMemberVO> dataListVO = new DataListVO<>();
		dataListVO.setpCode(pCode);
		
		String authMemberMemId = authMember.getMemId();
		
		service.chackmember(dataListVO);	//n개의 값을 서비스 에서 받아온다.
		
		model.addAttribute("authMemberMemId", authMemberMemId);
		model.addAttribute("dataListVO",dataListVO);	//이것이 jsp EL함수로 쓰임
		
		
		
		if(!errors.hasErrors()) {
			ServiceResult result = service.createMeeting(meeting);
			switch (result) {
			case OK:
				viewName = "redirect:/project/{pCode}/meeting/select.do?what="+meeting.getMeetingCode();
				break;

			default:
				viewName = "meeting/meetingWrite";
				message = "서버 오류, 잠시뒤 다시 시도 요청";
			}
			
		}else {
			viewName = "meeting/meetingWrite";
			
		}
		model.addAttribute("message",message);
		
		return viewName;
	}
	
}
