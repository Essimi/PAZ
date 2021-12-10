package kr.or.ddit.github.controller;

import javax.inject.Inject;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.github.service.GitSettingService;
import kr.or.ddit.vo.GitVO;
import kr.or.ddit.vo.MemberVO;


@Controller
public class GitHubTeam {
	
	@Inject
	GitSettingService servies;
	
	// 깃허브 팀 페이지 입니다.
	
	// 저장된 레파지토리가 있는지 확인합니다.
	@RequestMapping("project/{pCode}/gitHub/gitTeam.do")
	public String gitTeam(Model model, @PathVariable("pCode") String pCode, 
							@AuthenticationPrincipal(expression="authMember") MemberVO authMember) {
		
		GitVO git = new GitVO();
		
		git.setMemId(authMember.getMemId());
		git.setpCode(pCode);
				
		git = servies.retrieveGit(git);		
		
		model.addAttribute("git", git);
		
		return "gitHub/gitHubTeam";
		
	}

}
