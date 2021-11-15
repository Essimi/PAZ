package kr.or.ddit.team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeamMemberInviteController {
	@RequestMapping("team/TeamMemberInvite.do")
	public String Access(){
		return "setting/plSetting";
	}
}
