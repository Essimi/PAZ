package kr.or.ddit.project.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.project.service.RequestProjectService;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.RequestProjectVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class RequestProjectController {
	
	@Inject
	RequestProjectService service;


	// 프로젝트 요청 수락, 거절 선택 시 오는 페이지 
	@RequestMapping(value="project/requestProject.do")
	@ResponseBody
	public String Access(Model model,
			@RequestParam("value") String value,
			@RequestParam("memId") String memId,
			@RequestParam("msg") String msg
	) throws Exception{
		
		ServiceResult result = ServiceResult.FAILED;
		
		String[] array = value.split(",");
		
		log.info("array : {}, {}, {} ", array[0], array[1], array[2]);
		
		String pCode = array[0];
		String reqCode = array[1];
		String position = array[2];
		
		RequestProjectVO requestProjectVO = new RequestProjectVO();
		requestProjectVO.setpCode(pCode);
		requestProjectVO.setMemId(memId);
		requestProjectVO.setReqCode(reqCode);
		requestProjectVO.setPosition(position);
		
		String roleCode = position + pCode.substring(7);
		
		// 역할 코드 넣는 곳 
		requestProjectVO.setRoleCode(roleCode);
		
		log.info("역할코드 {}" , roleCode);
		
		
		
		if(msg.equals("ok")) {
			

			
			// 탈퇴했던 회원이 다시 수락하면
			
			// 프로젝트 참가 멤버 확인 (P_MEM에 있는 멤버)
			List<MemberVO> pMemList = service.SelectProjectMemberList(requestProjectVO);
			
			int cnt = 0;
			
			for(MemberVO member : pMemList) {
				if(member.getMemId().equals(memId)) {
					cnt ++;
				}
			}
			
			// p_mem에 이름이 있다면 , 즉 이미 참가했던 회원이라면
			if(cnt > 0) {
				
				ProjectVO projectVO = new ProjectVO();
				projectVO.setpCode(pCode);
				projectVO.setMemId(memId);
				
				// requestProjectVO 에 넣어줄 값들
				projectVO.setStatusCode("REQ_STATUS002");
				projectVO.setReqCode(reqCode);
				projectVO.setWorkTime("0");
			
				
				log.info("여기 여기 여기 여기 프로젝트브이오 :{} " , projectVO);
				
				// update 해줌 OutStatus 를.
				ServiceResult res = service.updatePmemOutCode(projectVO);
				
				if(res == ServiceResult.OK) {
					result = ServiceResult.OK;
				}else {
					result = ServiceResult.FAILED;
				}
				
			// p_mem에 이름이 없다면, 즉 새로운 회원
			}else {
				// 요청 수락
				requestProjectVO.setStatusCode("REQ_STATUS002");
				result = service.updateRequestProjecOk(requestProjectVO);
			}
				
				
			
		}else if (msg.equals("faild")) {
			// statusCode 거절
			requestProjectVO.setStatusCode("REQ_STATUS003");
			// status만 업데이트하는거 하나 만들어
			result = service.updateRequestProjectStatus(requestProjectVO);
		}
		
		log.info("toString {}" , requestProjectVO.toString());
		
		return result.toString();
	}
}