package kr.or.ddit.admin.dashboard.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.AdminDashboardVO;
import kr.or.ddit.vo.DataListVO;
import kr.or.ddit.vo.MeetingVO;
import kr.or.ddit.vo.PagingVO;

@Repository
public interface DashboardDAO {
	
	/**
	 * 결제/환불 대시보드
	 * @param 
	 * @return
	 */
	public List<AdminDashboardVO> selectPayDashInfo();
	
	/**
	 * 연령별 대시보드
	 * @param 
	 * @return
	 */
	public List<AdminDashboardVO> selectMemAgeDash();
	
	/**
	 * 소속별 대시보드
	 * @param 
	 * @return
	 */
	public List<AdminDashboardVO> selectClassification();


	/**
	 * 회원 성비 그래프
	 * @param 
	 * @return
	 */
	public List<AdminDashboardVO> selectGenderDashboard();

	/**
	 * 프로젝트 파트 대시보드
	 * @param 
	 * @return
	 */
	public List<AdminDashboardVO> selectPorjectPartDashboard();
	
	/**
	 * 프로젝트 기능(세팅)평점 (평균)
	 * @param 
	 * @return
	 */
	public List<AdminDashboardVO>selectProjectFunctionAvgDashboard();
	
	/**
	 * 프로젝트 기능 작성글 리스트 페이지 수
	 * @param dataListVO
	 * @return
	 */
	public int selectTotalRecord(PagingVO<AdminDashboardVO> pagingVO);
	
	/**
	 * 프로젝트 기능 작성글 리스트
	 * @param dataListVO
	 * @return
	 */
	public List<AdminDashboardVO> selectProjectFunctionTextDashboard(PagingVO<AdminDashboardVO> pagingVO);
	
	/**
	 * 로그인 시간 / 카운트 
	 * @param 
	 * @return
	 */
	public List<AdminDashboardVO> selectlogInDashboard();
	
	/**
	 *로그아웃 시간 / 카운트 
	 * @param 
	 * @return
	 */
	public List<AdminDashboardVO> selectlogOutDashboard();
	
	/**
	 * 특정 단어 입력 통계
	 * @return
	 */
	public List<AdminDashboardVO> selectWordDashboard();
	
	
	
}
