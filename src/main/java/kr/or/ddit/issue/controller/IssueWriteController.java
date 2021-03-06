package kr.or.ddit.issue.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.enumpkg.ResultStatus;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.issue.service.IssueService;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.project.service.ProjectService;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.vo.IssueRecipientVO;
import kr.or.ddit.vo.IssueVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProjectVO;
import oracle.security.crypto.cert.ext.IssuerAltNameExtension;

@Controller
public class IssueWriteController {
	
	@Inject
	private IssueService issueService;
	
	@Inject
	private MemberService memberService;
	
	@ModelAttribute("memList")
	public List<MemberVO> getProjectList(
			@PathVariable("pCode") String pCode
			) {
		ProjectVO project = new ProjectVO();
		project.setpCode(pCode);
		return memberService.projectMemberList(project);
	}
	
	@RequestMapping("project/{pCode}/issue/issueWrite.do")
	public String issueInsertGet(
			@PathVariable("pCode") String pCode,
			Model model
			) {
		return "issue/issueWrite";
	}
	
	@RequestMapping(value="project/{pCode}/issue/issueWrite.do", method=RequestMethod.POST)
	public String issueInsert(
			@PathVariable("pCode") String pCode,
			@Validated(InsertGroup.class) @ModelAttribute("issue") IssueVO issue,
			Errors error,
			@RequestParam("Recipients") String[] recipients,
			RedirectAttributes redirect,
			Model model
			) {
		ResultStatus status = ResultStatus.FAIL;
		String viewName = null;
		if(!error.hasErrors() && recipients.length > 0) {
			ArrayList<IssueRecipientVO> issueRecipients = new ArrayList<>();
			for(String memId : recipients) {
				IssueRecipientVO recipient = new IssueRecipientVO();
				recipient.setMemId(memId);
				issueRecipients.add(recipient);
			}
			issue.setIssueRecipients(issueRecipients);
			issue.setpCode(pCode);
			
			ServiceResult result = issueService.createIssue(issue);
			switch (result) {
			case OK:
				viewName = "redirect:/project/" + pCode + "/issue/issueList.do";
				status = ResultStatus.INSERT;
				redirect.addFlashAttribute("status", status);
				break;
			default:
				viewName = "issue/issueWrite";
				break;
			}
		}else {
			viewName = "issue/issueWrite";
			if(recipients.length <= 0) {
				model.addAttribute("recipientsMsg", "??????????????? ????????? ?????????????????????.");
			}
		}
		
		model.addAttribute("status", status);
		
		return viewName;
	}
}
