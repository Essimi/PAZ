package kr.or.ddit.project.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.project.service.ProjectService;
import kr.or.ddit.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ProjectDeleteController {

	@Inject
	ProjectService service;

		@RequestMapping("project/projectDelete.do")
		@ResponseBody
		public String Access(@RequestParam("value") String pCode){
			log.info("굿");
			
			ProjectVO projectVO = new ProjectVO();
			
			projectVO.setpCode(pCode);
			
			ServiceResult result = service.deletProject(projectVO);
			
			log.info(projectVO.getpCode());

			return result.toString();
		}
	}