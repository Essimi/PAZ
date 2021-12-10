package kr.or.ddit.dashboardPl.service;

import java.util.List;

import kr.or.ddit.vo.PLDashboardVO;

public interface PLDashboardService {
	/**
	 * 업무 담당자별 할당 비율
	 * @return
	 */
	public List<PLDashboardVO>  taskManagerRatio(String pCode);
	
	/**
	 * 업무이슈 관리
	 * @return
	 */
	public List<PLDashboardVO> issueManagement(String pCode);
	
	/**
	 * 긴급업무 횟수
	 * @return
	 */
	public List<PLDashboardVO> topTaskStatus(String pCode);
	
	/**
	 * 팀 업무상태 그래프
	 * @return
	 */
	public List<PLDashboardVO> teamState(String pCode);
	
	/**
	 * 팀원 근무시간 그래프
	 * @return
	 */
	public List<PLDashboardVO> teamWorkTime(String pCode);
	
}
