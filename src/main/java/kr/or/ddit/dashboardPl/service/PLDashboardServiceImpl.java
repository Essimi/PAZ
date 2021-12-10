package kr.or.ddit.dashboardPl.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.dashboardPl.dao.PLDashboardDAO;
import kr.or.ddit.vo.PLDashboardVO;

@Service
public class PLDashboardServiceImpl implements PLDashboardService {
	
	@Inject
	private  PLDashboardDAO dao;
	
	@Override
	public List<PLDashboardVO> taskManagerRatio(String pCode) {
		List<PLDashboardVO> plDashboard = dao.taskManagerRatio(pCode);
		if(plDashboard == null) {
			//데이터가 없으면 미출력
		}
		return plDashboard;
	}

	@Override
	public List<PLDashboardVO> issueManagement(String pCode) {
		List<PLDashboardVO> plDashboard = dao.issueManagement(pCode);
		if(plDashboard== null) {
			
		}
		return plDashboard;
	}


	@Override
	public List<PLDashboardVO> topTaskStatus(String pCode) {
		List<PLDashboardVO> plDashboard = dao.topTaskStatus(pCode);
		if(plDashboard== null) {
			
		}
		return plDashboard;
	}

	@Override
	public List<PLDashboardVO> teamState(String pCode) {
		List<PLDashboardVO> plDashboard = dao.teamState(pCode);
		if(plDashboard== null) {
			
		}
		return plDashboard;
	}

	@Override
	public List<PLDashboardVO> teamWorkTime(String pCode) {
		List<PLDashboardVO> plDashboard = dao.teamWorkTime(pCode);
		if(plDashboard== null) {
			
		}
		return plDashboard;
	}
	
}
