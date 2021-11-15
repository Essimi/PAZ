package kr.or.ddit.setting.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.project.service.ProjectService;
import kr.or.ddit.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SettingPageContoller {
	
	@Inject
	ProjectService service;
	
	@RequestMapping("setting/settingProject.do")
	public String settingPage(@ModelAttribute("project") ProjectVO project
			 			    , Model model) {
		
		// pCode, memId 는 session에 있을거야 ~ !
		
		
		return "setting/plSetting";
	}

}
