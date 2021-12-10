package kr.or.ddit.admin.payRetrieve.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.admin.payRetrieve.service.PayRetrieveService;
import kr.or.ddit.vo.PayVO;

@Controller
public class PayRetrieveSelectContoller {
	
	@Inject
	private PayRetrieveService service;
	
	@RequestMapping("admin/payRetrieve/select.do")
	public String selectPayRetrieve(
			@RequestParam(value="payCode",required=true) String payCode
			,Model model
			) {
		
		PayVO payVO = service.selectPayRetrieve(payCode);
		
		model.addAttribute("payVO",payVO);
		
		return "admin/payRetrieveSelect";
	}
}
