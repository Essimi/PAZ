package kr.or.ddit.utils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class videoContoller {
	@RequestMapping("project/{pCode}/util/teamvideo.do")
	public String Access() {
		return "util/teamvideo";
	}
}
