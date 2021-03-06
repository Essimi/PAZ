package kr.or.ddit.github.controller;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.github.service.GitSettingService;
import kr.or.ddit.utils.MessageUtils;
import kr.or.ddit.vo.GitVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class GitSetting {
	
	@Resource(name="messageUtils")
	MessageUtils msgUtils;
	
	@Inject
	private GitSettingService service;
	
	// 깃허브 레파지토리 상세페이지 입니다.(PL)
	
	@RequestMapping("project/{pCode}/gitHub/gitSetting.do" )
	public String gitSetting(Model model, @AuthenticationPrincipal(expression="authMember") MemberVO authMember,
			 				@PathVariable("pCode") String pCode) {
	
		GitVO git = new GitVO();
		
		git.setpCode(pCode);
		git.setMemId(authMember.getMemId());
		
		git = service.retrieveGit(git);
				
		model.addAttribute("git", git);
		model.addAttribute("token", msgUtils.getMessage("token"));
		
		return "gitHub/gitHubSetting";
		
		
	}
}
