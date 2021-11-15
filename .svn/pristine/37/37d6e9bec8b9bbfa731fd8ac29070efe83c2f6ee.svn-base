package kr.or.ddit.github.controller;

import java.awt.PageAttributes.MediaType;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.github.service.GitSettingService;
import kr.or.ddit.vo.GitVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class GitRepoSave {
	
	@Inject
	private GitSettingService service;
	
	// 깃허브 레파지토리 저장(PL)
	
	@RequestMapping(value = "project/gitRepoSave.do", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String insertRepo(@RequestParam("gitId") String gitId, @RequestParam("gitRepo") String gitRepo) {
				
		GitVO git = new GitVO();
		
		// 세션에서 현재의 P_CODE 받아와야 합니다.
		
		git.setUserName(gitId);
		git.setRepository(gitRepo);
		
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
