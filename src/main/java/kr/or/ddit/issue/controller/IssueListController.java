package kr.or.ddit.issue.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.issue.service.IssueService;
import kr.or.ddit.project.service.ProjectService;
import kr.or.ddit.vo.IssueRecipientVO;
import kr.or.ddit.vo.IssueVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProjectVO;

@Controller
public class IssueListController {
	
	@Inject
	private IssueService issueService;
	
	@Inject
	private ProjectService projectService;
	
	@RequestMapping("project/{pCode}/issue/issueList.do")
	public String issueList(
			@PathVariable("pCode") String pCode,
			Model model
			){
		ProjectVO project = new ProjectVO();
		project.setpCode(pCode);
		List<ProjectVO> memList = projectService.listProjectMember(project);
		model.addAttribute("memList", memList);
		
		return "issue/issueList";
	}
	
	@RequestMapping(value="project/{pCode}/issue/issueList.do", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public PagingVO<IssueVO> issueListAjax(
			@PathVariable("pCode") String pCode,
			@RequestParam(value="page", required=false, defaultValue="1") int currentPage,
			@RequestParam(value="recipient", required=false, defaultValue="") String recipient,
			@ModelAttribute("issueVO") IssueVO issue,
			Model model
			){
		issue.setpCode(pCode);
		IssueRecipientVO issueRecipient = new IssueRecipientVO();
		issueRecipient.setMemId(recipient);
		List<IssueRecipientVO> list = new ArrayList<>();
		list.add(issueRecipient);
		issue.setIssueRecipients(list);
		
		PagingVO<IssueVO> pagingVO = new PagingVO<>(10, 5);
		pagingVO.setCurrentPage(currentPage);
		pagingVO.setDetailSearch(issue);
		
		issueService.retrieveIssueList(pagingVO);
		model.addAttribute("pagingVO", pagingVO);
		
		return pagingVO;
	}
}
