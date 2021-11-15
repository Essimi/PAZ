package kr.or.ddit.github.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.github.service.GitSettingService;
import kr.or.ddit.vo.GitVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class GitSetting {
	
	@Inject
	private GitSettingService service;
	
	// 깃허브 레파지토리 상세페이지 입니다.(PL)
	
	@RequestMapping("project/gitSetting.do" )
	public String gitSetting(Model model) {
	
		GitVO git = new GitVO();
		
//		git.setpCode("pcode");
//		git.setMemId("memId");
		
		git = service.retrieveGit(git);
		
		log.info("test : {}", git);
		
		model.addAttribute("git", git);
		
		return "gitHub/gitHubSetting";
		
		
	}
}
