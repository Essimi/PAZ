package kr.or.ddit.payment.refund.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RefundController {
	@RequestMapping("payment/refund.do")
	public String Access() {
		return "payment/refundList";
	}
}
