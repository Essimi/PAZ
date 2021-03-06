package kr.or.ddit.github.controller;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.github.service.GitSettingService;
import kr.or.ddit.vo.GitVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class GitRepoSave {
	
	@Inject
	private GitSettingService service;
	
	// 깃허브 레파지토리 저장(PL)
	
	@RequestMapping(value = "project/{pCode}/gitHub/gitRepoSave.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String insertRepo(@RequestParam("gitId") String gitId, @RequestParam("gitRepo") String gitRepo, 
								@PathVariable("pCode") String pCode,
								@AuthenticationPrincipal(expression="authMember") MemberVO authMember) {
				
		GitVO git = new GitVO();
		
		git.setUserName(gitId);
		git.setRepository(gitRepo);
		git.setpCode(pCode);
		git.setMemId(authMember.getMemId());
		
		log.info("git test : {}", git);
		
		ServiceResult result = service.createGitRepo(git);
		
		String message = null;
		
		if(result == ServiceResult.FAILED) {
			message = "알 수 없는 오류입니다. 다시 시도해주세요";
		}else {
			message = "등록이 완료되었습니다.";
		}
				
		return message;
	}
}
