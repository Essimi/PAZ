package kr.or.ddit.setting.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.project.service.RequestProjectService;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.RequestProjectVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemberInviteController {
	
	@Inject
	RequestProjectService service;
	
	@RequestMapping("setting/memberInvite.do")
	@ResponseBody
	public String memberInvited(@RequestParam("recipient") String recipient,
								@RequestParam("position") String position,
								@RequestParam("workTime") String workTime,
								@SessionAttribute("project") ProjectVO project,
								@SessionAttribute("memberList") List<ProjectVO> memberList) {
		
		String realResult = null;

		ServiceResult result = service.selectMemberInfo(recipient);
		
		// 아이디가 존재하면.
		if(result.equals(ServiceResult.OK)) {
			
			int cnt = 0; 
			
			// 회원이 프로젝트 내에 존재하는지 
			for(ProjectVO projectMem : memberList) {
				
				if(projectMem.getMemId().equals(recipient)) {
					cnt ++;
				}
				
			}
			
			// 회원이 프로젝트에 이미 존재한다면.
			if(cnt > 0) {
				
				int memOut = 0;
				
				for(ProjectVO projectMem : memberList) {
					// 프로젝트 탈퇴 회원
					if(projectMem.getOutStatus().equals("1") && projectMem.getMemId().equals(recipient)) {
						memOut++;
					}
				}
				
				// p_mem 에 존재하지만 탈퇴한 회원
				if(memOut > 0) {// 요청한 사람 리스트
					
					List<RequestProjectVO> requestList = service.listRequestProjectHistory(project);
					
					int requestListCnt = 0;
					
					// 만약 요청 리스트에 이 사람이 있으면 걍 돌아가
					for(RequestProjectVO requestMem : requestList) {
						
						log.info("requestmem, recipient : {}, {}", requestMem.getMemId(), recipient);
						
						if(requestMem.getRecipient().trim().equals(recipient.trim())) {
							
							requestListCnt++;
						}
					}
					
//					project.setMemId(recipient);
//					ServiceResult outRes = service.updatePmemOutCode(project);
					
					// 탈퇴한 회원한테 요청 시
					if(requestListCnt == 0) {
						
						RequestProjectVO requestProject = new RequestProjectVO();
						
						requestProject.setSender(project.getMemId());
						requestProject.setpCode(project.getpCode());
						requestProject.setRecipient(recipient);
						requestProject.setPosition(position);
						requestProject.setWorkTime(workTime);
						requestProject.setPartName(project.getPartName());
						
						ServiceResult res = null;
						res = service.InsertRequstProjectHistory(requestProject);
						
						if(res == ServiceResult.OK) {
							realResult = "ok";
						}else {
							realResult = "requestMem";
						}
						
					}else {
						realResult = "failed";
					}
					
				}else {
					realResult = "failed";
				}
				
				
				
			// 회원이 프로젝트 내에 존재하지 않으면 
			}else {
				
				// 요청한 사람 리스트
				List<RequestProjectVO> requestList = service.listRequestProjectHistory(project);
				
				int requestListCnt = 0;
				
				// 만약 요청 리스트에 이 사람이 있으면 걍 돌아가
				for(RequestProjectVO requestMem : requestList) {
					
					log.info("requestmem, recipient : {}, {}", requestMem.getMemId(), recipient);
					
					if(requestMem.getRecipient().trim().equals(recipient.trim())) {
						
						requestListCnt++;
					}
				}
				
				if(requestListCnt == 0) {
					
					RequestProjectVO requestProject = new RequestProjectVO();
					
					requestProject.setSender(project.getMemId());
					requestProject.setpCode(project.getpCode());
					requestProject.setRecipient(recipient);
					requestProject.setPosition(position);
					requestProject.setWorkTime(workTime);
					requestProject.setPartName(project.getPartName());
					
					ServiceResult res = null;
					res = service.InsertRequstProjectHistory(requestProject);
					
					// 요청 보내기 성공 (디비에 insert 성공)
					if(res == ServiceResult.OK) {
						realResult = "ok";
					}else {
						realResult ="requestMem";
					}
				}else {
					realResult ="requestMem";
				}
				
			}
		// 아이디가 존재하지 않는다면
		}else {
			realResult = "failed";
		}
		
		return realResult;
		
	}

}
