package kr.or.ddit.dashboard.sevice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.dashboard.dao.PEDashBoardDAO;
import kr.or.ddit.vo.CalendarVO;
import kr.or.ddit.vo.DashBoardVO;
import kr.or.ddit.vo.IssueVO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PEDashBoardServiceImpl implements PEDashBoardService {
	
	@Inject
	private PEDashBoardDAO peDashBoardDao;

	@Override
	public DashBoardVO projectMyStatus(DashBoardVO dashBoard) {
		
		DashBoardVO peDashBoard = peDashBoardDao.projectMyStatus(dashBoard);
				
		if(peDashBoard == null) {
			// 데이터가 없을 경우 미출력
		}
		
		return peDashBoard;
	}

	@Override
	public DashBoardVO projectAllTaskStatus(DashBoardVO dashBoard) {
		
		DashBoardVO peDashBoard = peDashBoardDao.projectAllTaskStatus(dashBoard);
		
		if(peDashBoard == null) {
			// 데이터가 없을 경우 미출력
		}
		
		return peDashBoard;
	}

	@Override
	public List<DashBoardVO> topTaskStatus(DashBoardVO dashBoard) {
		
		List<DashBoardVO> peDashBoard = peDashBoardDao.topTaskStatus(dashBoard);
		
		log.info("데이터가 없을 경우는 어떨까????????????????????????????? {}", peDashBoard);
		
		if(peDashBoard == null) {
			// 데이터가 없을 경우 미출력
		}
		
		return peDashBoard;
	}

	@Override
	public List<DashBoardVO> projectMonthIssue(DashBoardVO dashBoard) {
		
		List<DashBoardVO> peDashBoard = peDashBoardDao.projectMonthIssue(dashBoard);
		
		if(peDashBoard == null) {
			// 데이터가 없을 경우 미출력
		}
		
		return peDashBoard;
	}

	@Override
	public DashBoardVO projectTaskProportion(DashBoardVO dashBoardVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DashBoardVO> projectMonthIssueRank(DashBoardVO dashBoard) {
		
		List<DashBoardVO> peDashBoard = peDashBoardDao.projectMonthIssueRank(dashBoard);
		
		if(peDashBoard == null) {
			// 데이터가 없을 경우 미출력
		}
		
		return peDashBoard;
	}

	@Override
	public List<DashBoardVO> myTaskStatus(DashBoardVO dashBoard) {
		
		List<DashBoardVO> peDashBoard = peDashBoardDao.myTaskStatus(dashBoard);
		
		if(peDashBoard == null) {
			// 데이터가 없을 경우 미출력
		}
		
		return peDashBoard;
	}

	@Override
	public List<DashBoardVO> myIssueStatus(DashBoardVO dashBoard) {
		
		List<DashBoardVO> peDashBoard = peDashBoardDao.myIssueStatus(dashBoard);
		
		if(peDashBoard == null) {
			// 데이터가 없을 경우 미출력
		}
		
		return peDashBoard;
	}

	@Override
	public List<DashBoardVO> rootTaskIssue(DashBoardVO dashBoard) {
		
		List<DashBoardVO> peDashBoard = peDashBoardDao.rootTaskIssue(dashBoard);
		
		if(peDashBoard == null) {
			// 데이터가 없을 경우 미출력
		}
		
		return peDashBoard;
	}
	
	// ------------------------------------------------------------------
	// Project Main Page 사용 메소드 입니다.
		
	@Override
	public DashBoardVO projectWorkCount(String pCode) {
		
		DashBoardVO mainDashBoard = peDashBoardDao.projectWorkCount(pCode); 
		
		return mainDashBoard;
		
	}

	@Override
	public List<IssueVO> mainIssueList(String pCode) {
		
		List<IssueVO> mainIssueList = peDashBoardDao.mainIssueList(pCode);
		
		return mainIssueList;
		
	}

	@Override
	public List<DashBoardVO> memberList(String pCode) {
		
		List<DashBoardVO> mainMemberList = peDashBoardDao.memberList(pCode);

		return mainMemberList;
		
	}

	@Override
	public List<CalendarVO> projectMainCalendarList(String pCode) {
		
		List<CalendarVO> projectMainCalendarList = peDashBoardDao.projectMainCalendarList(pCode);
		
		return projectMainCalendarList;
		
	}
}
