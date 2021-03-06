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
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.validate.groups.UpdateGroup;
import kr.or.ddit.vo.IssueRecipientVO;
import kr.or.ddit.vo.IssueVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProjectVO;

@Controller
public class IssueSelectController {
	
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
	
	@RequestMapping("project/{pCode}/issue/issueSelect.do")
	public String issueSelect(
			@PathVariable("pCode") String pCode,
			@ModelAttribute("issueVO") IssueVO issue,
			Model model
			) {
		issue.setpCode(pCode);
		IssueVO issueResult= issueService.retrieveIssue(issue);
		model.addAttribute("issue", issueResult);
		
		return "issue/issueSelect";
	}
	
	@RequestMapping("project/{pCode}/issue/issueModify.do")
	public String issueModify(
			@PathVariable("pCode") String pCode,
			@ModelAttribute("issueVO") IssueVO issue,
			Model model
			) {
		issue.setpCode(pCode);
		IssueVO issueResult = issueService.retrieveIssue(issue);
		model.addAttribute("issue", issueResult);
		
		return "issue/issueWrite";
	}
	
	@RequestMapping(value="project/{pCode}/issue/issueModify.do", method=RequestMethod.POST)
	public String issueModifyPost(
			@PathVariable("pCode") String pCode,
			@Validated(UpdateGroup.class) @ModelAttribute("issue") IssueVO issue,
			Errors error,
			@RequestParam("Recipients") String[] recipients,
			RedirectAttributes redirect,
			Model model
			) {
		String viewName = null;
		ResultStatus status = ResultStatus.FAIL;
		if(!error.hasErrors() && recipients.length > 0) {
			ArrayList<IssueRecipientVO> issueRecipients = new ArrayList<>();
			for(String memId : recipients) {
				IssueRecipientVO recipient = new IssueRecipientVO();
				recipient.setMemId(memId);
				issueRecipients.add(recipient);
			}
			issue.setIssueRecipients(issueRecipients);
			issue.setpCode(pCode);
			
			ServiceResult result =  issueService.modifyIssue(issue);
			switch (result) {
			case OK:
				viewName = "redirect:/project/" + pCode + "/issue/issueList.do";
				status = ResultStatus.UPDATE;
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
	
	@RequestMapping("project/{pCode}/issue/issueDelete.do")
	public String issueDelete(
			@PathVariable("pCode") String pCode,
			@ModelAttribute("issueVO") IssueVO issue,
			RedirectAttributes redirect,
			Model model
			) {
		issue.setpCode(pCode);
		ServiceResult result =  issueService.deleteIssue(issue);
		ResultStatus status = null;
		switch (result) {
		case OK:
			status = ResultStatus.DELETE;
			break;
		default:
			status = ResultStatus.FAIL;
			break;
		}
		
		redirect.addFlashAttribute("status", status);
		
		return "redirect:/project/" + pCode + "/issue/issueList.do";
	}
}
