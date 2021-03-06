package kr.or.ddit.project.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.common.authentication.dao.authenticationDAO;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.project.service.ProjectService;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProjectVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ProjectInsertController {
	
	@Inject
	private ProjectService service;


		@RequestMapping(value = "project/projectInsert.do", method=RequestMethod.GET)
		public String projectInsert(
				HttpSession session,
				@AuthenticationPrincipal(expression="authMember") MemberVO authMember
				){
			return "myProject/projectInsert";
		}
		
		@RequestMapping(value = "/project/projectInsert.do", method = RequestMethod.POST)
		public String ProjectController( @ModelAttribute("project") ProjectVO myProject,
				Errors errors,
				Model model,
				@AuthenticationPrincipal(expression="authMember") MemberVO authMember
				) {
			
			log.info("content : {}",myProject.getpContent());
			log.info("start : {}",myProject.getpStartDate());
			log.info("end : {}",myProject.getpEndDate());
			
			
			String viewName = null;
			String message = null;
			
			myProject.setMemId(authMember.getMemId());
			
			System.out.println("sadasufhasf : " +  errors);
			
			if(!errors.hasErrors()) {
				ServiceResult result = service.insertMyProject(myProject);
			
				
				
				switch(result) {
				case OK:
					viewName = "redirect:/project/myprojectList.do";
					break;
				case FAILED:
					viewName = "myProject/projectInsert";
					message = "?????? ??????";
					break;
				}
			}else {
				return "myProject/projectInsert";
			}
			
			model.addAttribute("myProject", myProject);
			model.addAttribute("message", message);
			return viewName;
			
		}
	}
