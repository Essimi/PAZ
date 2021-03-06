package kr.or.ddit.dashboard.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.CalendarVO;
import kr.or.ddit.vo.DashBoardVO;
import kr.or.ddit.vo.IssueVO;

@Repository
public interface PEDashBoardDAO {
	
	/**
	 * 해당 프로젝트에서의 내 총 업무 수량과, 지금까지 완료한 업무의 수량을 출력합니다.
	 * @param dashBoard
	 * @return
	 */
	public DashBoardVO projectMyStatus(DashBoardVO dashBoard);
	
	/**
	 * 해당 프로젝트에서의 총 업무 수량과 현재 날짜 기준 일주일 안에 발생한 업무의 수량을 나타냅니다.
	 * @param dashBoard
	 * @return
	 */
	public DashBoardVO projectAllTaskStatus(DashBoardVO dashBoard);
	
	/**
	 * 최상위업무(LEVEL 1) 와 해당 상위업무들의 이름, 진행도를 나타냅니다.
	 * @param dashBoard
	 * @return
	 */
	public List<DashBoardVO> topTaskStatus(DashBoardVO dashBoard);

	/**
	 * 해당 프로젝트의 올해 발생 이슈들의 달 값만 추출한 후 해당 달의 이슈 발생건을 출력합니다.
	 * @param dashBoard
	 * @return
	 */
	public List<DashBoardVO> projectMonthIssue(DashBoardVO dashBoard);
	
	/**
	 * 최상위업무(LEVEL 1) 의 업무 등록 비율을 나타냅니다.(쿼리 미구현)
	 * @param dashBoardVO
	 * @return
	 */
	public DashBoardVO projectTaskProportion(DashBoardVO dashBoardVO);
	
	/**
	 * 해당 프로젝트의 올해 진행기간 중 가장 많은 이슈가 발생한 달 순으로(4등 까지) 추출합니다.
	 * @param dashBoard
	 * @return
	 */
	public List<DashBoardVO> projectMonthIssueRank(DashBoardVO dashBoard);
	
	/**
	 * 해당 프로젝트에서 나의 업무들의 상태를 추출합니다.
	 * @param dashBoard
	 * @return
	 */
	public List<DashBoardVO> myTaskStatus(DashBoardVO dashBoard);
	
	/**
	 * 해당 프로젝트에서 나의 이슈들의 상태 수 를 추출합니다.
	 * @param dashBoard
	 * @return
	 */
	public List<DashBoardVO> myIssueStatus(DashBoardVO dashBoard);
	
	/**
	 * 해당 프로젝트에서 개인의 가장 상위 업무의 이슈 발생건 을 추출합니다.
	 * @param dashBoard
	 * @return
	 */
	public List<DashBoardVO> rootTaskIssue(DashBoardVO dashBoard);
	
	// ------------------------------------------------------------------
	// Project Main Page 사용 메소드 입니다.
	
	/**
	 * 로그인한 프로젝트의 총 업무 수량, 진행중인 업무 수량, 완료된 업무 수량을 불러옵니다.
	 * @param dashBoardVO
	 * @return
	 */
	public DashBoardVO projectWorkCount(String pCode);
	
	/**
	 * 로그인한 프로젝트의 긴급 이슈 리스트를 출력합니다.
	 * @param issue
	 * @return
	 */
	public List<IssueVO> mainIssueList(String pCode);
	
	/**
	 * 해당 프로젝트의 참여자들을 불러옵니다.
	 * @param dashBoard
	 * @return
	 */
	public List<DashBoardVO> memberList(String pCode);
	
	/**
	 * 해당 프로젝트의 스케쥴 리스트를 불러옵니다.
	 * @param dashBoard
	 * @return
	 */
	public List<CalendarVO> projectMainCalendarList(String pCode);
	
}
