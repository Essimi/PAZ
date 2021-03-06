package kr.or.ddit.admin.dashboard.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.admin.dashboard.dao.DashboardDAO;
import kr.or.ddit.vo.AdminDashboardVO;
import kr.or.ddit.vo.DataListVO;
import kr.or.ddit.vo.PagingVO;

@Service
public class DashboardServiceImpl implements DashboardService {
	@Inject
	private DashboardDAO dao;
	
	//통합할때 객체 한번에 모으기
	@Override
	public List<AdminDashboardVO> payInfoList() {
		List<AdminDashboardVO> payInfo = dao.selectPayDashInfo();
		return payInfo;
	}

	@Override
	public List<AdminDashboardVO> memAgeList() {
		List<AdminDashboardVO> memInfo = dao.selectMemAgeDash();
		return memInfo;
	}

	@Override
	public List<AdminDashboardVO> memClassificationList() {
		List<AdminDashboardVO> memClassification = dao.selectClassification();

		return memClassification;
	}

	@Override
	public List<AdminDashboardVO> memGenderList() {
		List<AdminDashboardVO> memGender = dao.selectGenderDashboard();
		return memGender;
	}

	@Override
	public List<AdminDashboardVO> projectPartList() {
		List<AdminDashboardVO> projectPart = dao.selectPorjectPartDashboard();
		return projectPart;
	}

	@Override
	public List<AdminDashboardVO> projectFunctiontCountList() {
		List<AdminDashboardVO> projectFunctiontCount = dao.selectProjectFunctionAvgDashboard();
		return projectFunctiontCount;
	}

	@Override
	public List<AdminDashboardVO> projectFunctiontTextList(PagingVO<AdminDashboardVO> pagingVO) {
		List<AdminDashboardVO>  projectFunctiontText = dao.selectProjectFunctionTextDashboard(pagingVO);
		pagingVO.setTotalRecord(dao.selectTotalRecord(pagingVO));
		pagingVO.setDataList(projectFunctiontText);
		return projectFunctiontText;
	}

	@Override
	public Map<String, List> loginInfoList() {
		List<AdminDashboardVO> loginInfo = dao.selectlogInDashboard();
		List<AdminDashboardVO> logoutInfo = dao.selectlogOutDashboard();
		
		Map<String,List> loginMap = new HashMap<String, List>();
		loginMap.put("loginInfo", loginInfo);
		loginMap.put("logoutInfo", logoutInfo);
		
		return loginMap;
	}

	@Override
	public List<AdminDashboardVO> wordStackList() {
		List<AdminDashboardVO> wordStack = dao.selectWordDashboard();
		return wordStack;
	}

	
	
}
