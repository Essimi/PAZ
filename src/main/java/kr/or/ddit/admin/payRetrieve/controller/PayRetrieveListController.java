package kr.or.ddit.admin.payRetrieve.controller;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.admin.payRetrieve.service.PayRetrieveService;
import kr.or.ddit.payment.pay.dao.PayDAO;
import kr.or.ddit.payment.pay.service.PayService;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.PayVO;
import kr.or.ddit.vo.SearchVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller

public class PayRetrieveListController {
	@Inject
	private PayRetrieveService service;
	
	@RequestMapping("admin/payRetrieve/List.do")
	public String selectPayRetrieveList(
			@RequestParam(value="page",required=false, defaultValue="1") int currentPage
			,Model medel
			
			) {
		PagingVO<PayVO> pagingVO = new PagingVO<>(10,5);
		
		pagingVO.setCurrentPage(currentPage);
		
		//결제 환불정보
		service.selectPayRetrieveList(pagingVO);
		
		medel.addAttribute("pagingVO",pagingVO);
		
		
		
		return "admin/payRetrieveList";
	}
	
	
	@RequestMapping(value = "admin/payRetrieve/List.do", method = RequestMethod.POST)
	public String payList (
			@RequestParam(value = "page", defaultValue = "1") int page,
			@ModelAttribute("pay") PayVO pay,
			Model model){
		
		PagingVO<PayVO> pagingVO = new PagingVO<PayVO>(10,5);
		
		pagingVO.setCurrentPage(page);
    	pagingVO.setDetailSearch(pay);
		
		service.selectPayRetrieveList(pagingVO);
		
		model.addAttribute("pagingVO", pagingVO);
		
		
		return "admin/payRetrieveList";
	}
}
