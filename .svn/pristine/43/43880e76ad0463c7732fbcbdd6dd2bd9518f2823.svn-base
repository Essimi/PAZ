package kr.or.ddit.admin.member.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.admin.member.service.AdminMemberService;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("admin/adminMemberList.do")
public class AdminMemberList {
	
	@Inject
	AdminMemberService service;
	
	@RequestMapping
	public String Access(@RequestParam(value="page", required=false, defaultValue = "1") int currentPage,
						 Model model) {
		
		PagingVO<MemberVO> pagingVO = new PagingVO<MemberVO>(10,5);
		
		pagingVO.setCurrentPage(currentPage);
		
		// 전체 회원리스트 
		service.selectAllMemberList(pagingVO);
		
		model.addAttribute("pagingVO", pagingVO);
		
		log.info("pagingVO:{}", pagingVO.getDataList());
		
		return "admin/adminMember";
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String memberList (@RequestParam(value="page", defaultValue = "1") int page,
							  @ModelAttribute("member") MemberVO member,
							  Model model) {
		
		PagingVO<MemberVO> pagingVO = new PagingVO<MemberVO>(10,5);
		
		pagingVO.setCurrentPage(page);
    	pagingVO.setDetailSearch(member);
		
		service.selectAllMemberList(pagingVO);
		
		model.addAttribute("pagingVO", pagingVO);
		
		
		return "admin/adminMember";
	}
}
