package kr.or.ddit.issue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IssueWriteController {
	@RequestMapping("issue/issueWrite.do")
	public String Access() {
		return "issue/issueWrite";
	}
}
