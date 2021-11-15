package kr.or.ddit.project.controller;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.project.service.ProjectService;
import kr.or.ddit.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("project/projectUpdate.do")
public class ProjectUpdateController {

		@Inject
		ProjectService service;

		@RequestMapping(method=RequestMethod.POST)
		public String Access(@RequestParam("value") String pCode, 
							 Model model){
			
			log.info("값 받았음! {}", pCode);
			
			ProjectVO projectVO = new ProjectVO();
			
			projectVO.setpCode(pCode);
			
			projectVO = service.selectProject(projectVO);
			
			log.info("여기 vo : {}", projectVO);
			
			projectVO.setpCode(pCode);
			
			model.addAttribute("project", projectVO);
			
			log.info("pCode TEST : {}", projectVO.getpCode());
			
			return "myProjectEdit";
		}
		
		
		@RequestMapping
		@ResponseBody
		public String updateGet(@ModelAttribute ProjectVO project) throws Exception{
			
			log.info(project.toString());
			ServiceResult result = service.updateProject(project);
			
			return result.toString();
		}
	}

