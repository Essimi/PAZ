package kr.or.ddit.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletException;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.admin.dashboard.service.DashboardService;
import kr.or.ddit.admin.member.service.AdminMemberService;
import kr.or.ddit.admin.payRetrieve.service.PayRetrieveService;
import kr.or.ddit.vo.AdminDashboardVO;
import kr.or.ddit.vo.DataListVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.PayVO;
import kr.or.ddit.vo.SearchVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class AdminMain {
	
	//결제 대시보드
	@Inject
	private DashboardService service;
	
	@Inject
	private PayRetrieveService payservice;
	
	@Inject
	AdminMemberService memberservice;
	
	@RequestMapping("admin/adminMain.do")
	public String adminMain (
			@RequestParam(value="page", required=false, defaultValue="1")int currentPage
			,Model model
			) throws ServletException, IOException {

		//회원 목록 리스트
		PagingVO<MemberVO> memberpagingVO = new PagingVO<MemberVO>(4,5);
		memberpagingVO.setCurrentPage(1);
		memberservice.selectAllMemberList(memberpagingVO);
		model.addAttribute("memberpagingVO",memberpagingVO);

		//결제 목록 리스트 
		PagingVO<PayVO> paypagingVO = new PagingVO<PayVO>(6,9);
		paypagingVO.setCurrentPage(1);
		payservice.selectPayRetrieveList(paypagingVO);
		model.addAttribute("paypagingVO",paypagingVO);
		//결제 대시보드 
		List<AdminDashboardVO> payDataList = service.payInfoList();
		model.addAttribute("payDataList",payDataList);
		//성별 대시보드
		List<AdminDashboardVO> genderDataList = service.memGenderList();
		model.addAttribute("genderDataList",genderDataList);
		//소속분야 대시보드
		List<AdminDashboardVO> classification = service.memClassificationList();
		model.addAttribute("classification",classification);
		//로그인/로그아웃 시간별 빈도수 
		Map<String, List> loginMap = service.loginInfoList();
		model.addAttribute("loginMap",loginMap);
		//나이대별 대시보드
		List<AdminDashboardVO> ageDataList = service.memAgeList();
		model.addAttribute("ageDataList",ageDataList);
		//분야별 프로젝트 생성 수
		List<AdminDashboardVO> projectClassDataList = service.projectPartList();
		model.addAttribute("projectClassDataList",projectClassDataList);
		//평점 수치 그래프
		List<AdminDashboardVO> dataListV = service.projectFunctiontCountList();
		model.addAttribute("dataListVO",dataListV);
		//평점 텍스트 리스트

		//특정 단어 입력 스택 버블
		List<AdminDashboardVO> wordStack = service.wordStackList();
		model.addAttribute("wordStack",wordStack);
		
		
		return "admin/adminPageStatistic";
	}

	@RequestMapping(value="admin/adminMain.do", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody 
	public PagingVO<AdminDashboardVO> admintextList(
			@RequestParam(value="page", required = false, defaultValue="1") int currentPage,
			Model model) throws ServletException, IOException{
		
		//평점 텍스트 리스트
			PagingVO<AdminDashboardVO> pagingVO  =new PagingVO<AdminDashboardVO>();
			pagingVO.setCurrentPage(currentPage);
			service.projectFunctiontTextList(pagingVO);
				
			
				
		return pagingVO;
	}
	
}
