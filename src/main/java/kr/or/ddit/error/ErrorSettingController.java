package kr.or.ddit.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/errorPage/errors")
class ErrorSettingController {
	
	private static String message;
	
//	web.xml Exception 처리 입니다.
	
	@RequestMapping(value = "/throwable")
	public ModelAndView	throwable(HttpServletRequest req, Model model) {
		
		log.info("==============================error log==============================");
		log.info("throwable.........");
		pageErrorLog(req);
		log.info("==============================error end==============================");
		
		message = "알 수 없는 예외입니다. 문의해주세요.";
		
		ModelAndView re = new ModelAndView();
		re.setViewName("errorPage/totalErrorPage");
		re.addObject("message", message);
		re.addObject("code", HttpStatus.BAD_REQUEST);
		re.addObject("codeNumber", "400");
		re.addObject("url", req.getAttribute("javax.servlet.error.request_uri"));
		
		return re;
	}
	
	@RequestMapping(value = "/exception")
	public ModelAndView	exception(HttpServletRequest req, Model model) {
		
		log.info("==============================error log==============================");
		log.info("exception.........");
		pageErrorLog(req);
		log.info("==============================error end==============================");
		
		message = "알 수 없는 예외입니다. 문의해주세요.";
		
		ModelAndView re = new ModelAndView();
		re.setViewName("errorPage/totalErrorPage");
		re.addObject("message", message);
		re.addObject("code", HttpStatus.BAD_REQUEST);
		re.addObject("codeNumber", "400");
		re.addObject("url", req.getAttribute("javax.servlet.error.request_uri"));
		
		return re;
	}
	
	@RequestMapping(value = "/400")
	public ModelAndView	pagerError400(HttpServletRequest req, Model model) {
		
		log.info("==============================error log==============================");
		log.info("400.........");
		pageErrorLog(req);
		log.info("==============================error end==============================");
		
		message = "요청의 문법이 잘못되었거나 요청을 처리할 수 없습니다.";
		
		ModelAndView re = new ModelAndView();
		re.setViewName("errorPage/totalErrorPage");
		re.addObject("message", message);
		re.addObject("code", HttpStatus.BAD_REQUEST);
		re.addObject("codeNumber", "400");
		re.addObject("url", req.getAttribute("javax.servlet.error.request_uri"));
		
		return re;
	}
	
	@RequestMapping(value = "/403")
	public ModelAndView	pagerError403(HttpServletRequest req, Model model) {
		
		log.info("==============================error log==============================");
		log.info("400.........");
		pageErrorLog(req);
		log.info("==============================error end==============================");
		
		message = "허용되지 않은 접근입니다.";
		
		ModelAndView re = new ModelAndView();
		re.setViewName("errorPage/totalErrorPage");
		re.addObject("message", message);
		re.addObject("code", HttpStatus.BAD_REQUEST);
		re.addObject("codeNumber", "403");
		re.addObject("url", req.getAttribute("javax.servlet.error.request_uri"));
		
		return re;
	}
	
	@RequestMapping(value = "/404")
	public ModelAndView	pagerError404(HttpServletRequest req, Model model) {
		
		log.info("==============================error log==============================");
		log.info("400.........");
		pageErrorLog(req);
		log.info("==============================error end==============================");
		
		message = "요청하신 페이지는 존재하지 않습니다.";
		
		ModelAndView re = new ModelAndView();
		re.setViewName("errorPage/totalErrorPage");
		re.addObject("message", message);
		re.addObject("code", HttpStatus.NOT_FOUND);
		re.addObject("codeNumber", "404");
		re.addObject("url", req.getAttribute("javax.servlet.error.request_uri"));
		
		return re;
	}
	
	@RequestMapping(value = "/405")
	public ModelAndView	pagerError405(HttpServletRequest req, Model model) {
		
		log.info("==============================error log==============================");
		log.info("400.........");
		pageErrorLog(req);
		log.info("==============================error end==============================");
		
		message = "요청된 메소드가 허용되지 않습니다.";
		
		ModelAndView re = new ModelAndView();
		re.setViewName("errorPage/totalErrorPage");
		re.addObject("message", message);
		re.addObject("code", HttpStatus.BAD_REQUEST);
		re.addObject("codeNumber", "405");
		re.addObject("url", req.getAttribute("javax.servlet.error.request_uri"));
		
		return re;
	}
	
	@RequestMapping(value = "/500")
	public ModelAndView	pagerError500(HttpServletRequest req, Model model) {
		
		log.info("==============================error log==============================");
		log.info("400.........");
		pageErrorLog(req);
		log.info("==============================error end==============================");
		
		message = "서버에 오류가 발생하였습니다.";
		
		ModelAndView re = new ModelAndView();
		re.setViewName("errorPage/totalErrorPage");
		re.addObject("message", message);
		re.addObject("code", HttpStatus.BAD_REQUEST);
		re.addObject("codeNumber", "500");
		re.addObject("url", req.getAttribute("javax.servlet.error.request_uri"));
		
		return re;
	}
	
	@RequestMapping(value = "/503")
	public ModelAndView	pagerError503(HttpServletRequest req, Model model) {
		
		log.info("==============================error log==============================");
		log.info("400.........");
		pageErrorLog(req);
		log.info("==============================error end==============================");
		
		message = "해당 서비스를 사용할 수 없습니다..";
		
		ModelAndView re = new ModelAndView();
		re.setViewName("errorPage/totalErrorPage");
		re.addObject("message", message);
		re.addObject("code", HttpStatus.BAD_REQUEST);
		re.addObject("codeNumber", "503");
		re.addObject("url", req.getAttribute("javax.servlet.error.request_uri"));
		
		return re;
	}
	
	@RequestMapping(value = "/PKNotFound")
	public ModelAndView	PKNotFound(HttpServletRequest req, Model model) {
		
		log.info("==============================error log==============================");
		log.info("400.........");
		pageErrorLog(req);
		log.info("==============================error end==============================");
		
		message = "글번호를 찾을수 없습니다.";
		
		ModelAndView re = new ModelAndView();
		re.setViewName("errorPage/totalErrorPage");
		re.addObject("message", message);
		re.addObject("code", HttpStatus.BAD_REQUEST);
		re.addObject("codeNumber", "400");
		re.addObject("url", req.getAttribute("javax.servlet.error.request_uri"));
		
		return re;
	}
	
	private void pageErrorLog(HttpServletRequest req) {
		
		log.info("Status code : " + req.getAttribute("javax.servlet.error.status_code"));
		log.info("Exception Type : " + req.getAttribute("javax.servlet.error.exception_type"));
		log.info("Message : " + req.getAttribute("javax.servlet.error.message"));
		log.info("Request Uri : " + req.getAttribute("javax.servlet.error.request_uri"));
		log.info("Exception : " + req.getAttribute("javax.servlet.error.exception"));
		log.info("Servlet Name : " + req.getAttribute("javax.servlet.error.servlet_name"));
	}
}
