package kr.or.ddit.dashboardPl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.DashBoardVO;
import kr.or.ddit.vo.PLDashboardVO;

@Repository
public interface PLDashboardDAO {
	
	/**
	 * 업무 담당자별 할당 비율 
	 * @return
	 */
	public List<PLDashboardVO> taskManagerRatio(String pCode);
	
	
	/**
	 * 업무 요청건 받은건
	 * @return
	 */
	public List<PLDashboardVO> issueManagement(String pCode);

	
	/**
	 * 최상위업무(LEVEL 1) 와 해당 상위업무들의 이름, 진행도를 나타냅니다.
	 * @param dashBoard
	 * @return
	 */
	public List<PLDashboardVO> topTaskStatus(String pCode);
	
	/**
	 * 팀원 업무 상태 그래프
	 * @return
	 */
	public List<PLDashboardVO> teamState(String pCode);
	
	/**
	 * 팀원 근무시간 그래프
	 * @return
	 */
	public List <PLDashboardVO> teamWorkTime(String pCode);
}