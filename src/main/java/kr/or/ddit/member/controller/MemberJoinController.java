package kr.or.ddit.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.or.ddit.enumpkg.ResultStatus;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.validate.groups.KakaoGroup;
import kr.or.ddit.vo.MemberVO;

@SessionAttributes({"emailAuthKey","emailConfirm"})
@Controller
public class MemberJoinController {
	
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value="login/join.do", method=RequestMethod.POST)
	public String Access(
			@Validated(InsertGroup.class) @ModelAttribute("member") MemberVO member,
			Errors errors,
			HttpServletRequest request,
			Model model
			) throws Exception {
		String viewName = null;
		String message = null;
		ServletContext application = request.getServletContext();
		String emailConfirm = (String) application.getAttribute("emailConfirm");
		if(emailConfirm.equals("OK")) {
			if(!errors.hasErrors()) {
				ServiceResult result = memberService.createMember(member);
				switch (result) {
				case OK:
					viewName = "redirect:/";
					HttpSession session = request.getSession();
					session.setAttribute("memberStatus", ResultStatus.INSERT);
					break;
				default:
					viewName = "login/login";
					message = "????????? ????????? ?????? ?????????????????? ????????????.";
					break;
				}
			}else {
				viewName = "login/join";
			}
		}else {
			viewName = "login/join";
			message = "????????? ????????? ?????? ????????? ?????????.";
		}
		
		model.addAttribute("message", message);
		
		return viewName;
	}
	
	@RequestMapping(value="login/idCheck.do", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, String> Access(
			@ModelAttribute("member") MemberVO member
			) {
		
		String status = null;
		String message = null;
		String color = null;
		ServiceResult result = memberService.memberIdCheck(member);
		switch (result) {
		case OK:
			message = "?????? ????????? ??????????????????.";
			color = "green";
			status = "OK";
			break;
		default:
			message = "?????? ???????????? ??????????????????.";
			color = "red";
			status = "FAIL";
			break;
		}
		
		Map<String, String> dataMap = new HashMap<>();
		dataMap.put("message", message);
		dataMap.put("color", color);
		dataMap.put("status", status);
		
		return dataMap;
	}
	
	@RequestMapping(value="login/emailCheck", method=RequestMethod.POST)
	@ResponseBody
	public ServiceResult emailCheck(
			@ModelAttribute("member") MemberVO member,
			@RequestParam("sessionId") String sessionId,
			HttpServletRequest request,
			Model model
			) {
		Map<String, String> map = memberService.sendMail(member, sessionId);
		ServiceResult result = null;
		String status = map.get("status");
		switch (status) {
		case "OK":
			ServletContext application = request.getServletContext();
			application.setAttribute("emailAuthKey", map.get("emailAuthKey"));
			result = ServiceResult.OK;
			break;
		default:
			result = ServiceResult.FAILED;
			break;
		}
		
		return result;
	}
	
	// ??????????????? ??????????????? ????????? ????????? ????????? ????????? ?????? ????????? ???????????????.
	@RequestMapping(value="login/emailConfirm", method=RequestMethod.GET)
	public String emailCheck(
			@RequestParam("key") String sendKey,
			HttpServletRequest request,
			Model model
			) {
		ServletContext application = request.getServletContext();
		String saveKey = (String) application.getAttribute("emailAuthKey");
		if(sendKey.equals(saveKey)){
			application.setAttribute("emailConfirm", "OK");
			model.addAttribute("emailConfirmMsg", "????????? ????????? ?????????????????????. ???????????? ???????????? ???????????? ?????? ??????????????? ???????????????.");
		}else {
			application.setAttribute("emailConfirm", "FAILED");
			model.addAttribute("emailConfirmMsg", "????????? ????????? ?????????????????????. ?????? ??????????????????.");
		}
	
		String sessionId = sendKey.substring(sendKey.lastIndexOf("~") + 1);
		model.addAttribute("sessionId", sessionId);
		
		return "login/emailAuthentication";
	}
	
	@RequestMapping("login/kakaoJoin.do")
	public String kakaoJoinGet() {
		return "login/kakaoJoin";
	}
	
	@RequestMapping(value="login/kakaoJoin.do", method=RequestMethod.POST)
	public String kakaoJoinPost(
			@Validated(KakaoGroup.class) @ModelAttribute("member") MemberVO member,
			Errors errors,
			@SessionAttribute(name="userInfo", required=false) MemberVO userInfo,
			Model model,
			HttpSession session,
			SessionStatus sessionStatus
			) {
		String viewName = null;
		if(!errors.hasErrors()) {
			ServiceResult result = memberService.createKakaoMember(member, userInfo.getMemIkon().getRealName());
			switch (result) {
			case OK:
				viewName = "redirect:/";
				sessionStatus.setComplete();
				session.setAttribute("memberStatus", ResultStatus.INSERT);
				break;
			default:
				viewName = "login/kakaoJoin";
				break;
			}
		}else {
			viewName = "login/kakaoJoin";
		}
		
		return viewName;
	}
}
