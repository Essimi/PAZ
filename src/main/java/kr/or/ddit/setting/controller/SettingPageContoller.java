package kr.or.ddit.setting.controller;


import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.setting.service.ProjectSettingService;
import kr.or.ddit.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SettingPageContoller {
	
//	@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	미사용 CODE 입니다.............. (정책 변경)
//	관련된 모든 파일들 또한 사용하지 않습니다................................
//	@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

	@Inject
	ProjectSettingService service;
	
	
	// 프로젝트 세팅페이지 진입(추가결제, 환불, 프로젝트 완료)
	@RequestMapping("setting/settingProject.do")
	public String settingPage() {
				
		return "setting/plSetting";
	}
	
	// 프로젝트를 완료 상태로 변경합니다.
	@RequestMapping(value = "setting/projectComplete.do", method = RequestMethod.POST)
	public String projectComplete(HttpSession session, RedirectAttributes redi) {
			
		// 프로젝트 완료 조건을 위해 현재 세션에서 프로젝트 번호를 받아옵니다.
		ProjectVO projectCode = (ProjectVO) session.getAttribute("project");
		
		String message = null;
		String view = null;
		
		ServiceResult result = null;
		
		// 프로젝트 상태를 변경합니다.
		result = service.projectComplete(projectCode.getpCode());
				
		if(result.equals(ServiceResult.OK)) { // 상태 변경이 완료된다면
			message = "상태변경이 완료되었습니다.";
			view = "redirect:/project/myprojectList.do";
		}else {
			message = "상태변경이 실패하였습니다.";
			view = "redirect:/setting/settingProject.do";
		}
		
		redi.addFlashAttribute("message", message);
		return view;
	}
}
