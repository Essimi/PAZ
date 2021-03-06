package kr.or.ddit.github.controller;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.github.service.GitSettingService;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class GitRepoDelete {
	
	@Inject
	private GitSettingService service;
	
	// 깃허브 레파지토리 연결 해제(PL)
	
	@RequestMapping(value = "project/{pCode}/gitHub/gitRepoDelete.do", produces = "application/text; charset=utf8")
	@ResponseBody
	public String insertRepo(@PathVariable("pCode") String pCode) {
		
		ServiceResult result = service.removeGitRepo(pCode);
		
		log.info("????");
		log.info("{}", pCode);
		
		String message = null;
		
		if(result == ServiceResult.FAILED) {
			message = "알 수 없는 오류입니다. 다시 시도해주세요";
		}else {
			message = "해제가 완료되었습니다.";
		}
			
		return message;
	}
}
