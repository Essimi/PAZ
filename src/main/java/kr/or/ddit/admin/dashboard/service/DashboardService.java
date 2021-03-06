package kr.or.ddit.admin.dashboard.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.AdminDashboardVO;
import kr.or.ddit.vo.DataListVO;
import kr.or.ddit.vo.MeetingVO;
import kr.or.ddit.vo.PagingVO;

public interface DashboardService {

	/**
	 * 결제/환불 대시보드 리스트
	 * @param dataListVO
	 * @return
	 */
	public List<AdminDashboardVO> payInfoList();

	/**
	 * 회원 연령별 대시보드 리스트
	 * @param dataListVO
	 * @return
	 */
	public List<AdminDashboardVO> memAgeList();

	/**
	 * 회원 소속분류별 대시보드 리스트
	 * @param dataListVO
	 * @return
	 */
	public List<AdminDashboardVO> memClassificationList();

	
	/**
	 * 회원 성별 비율 대시보드 리스트
	 * @param dataListVO
	 * @return
	 */
	public List<AdminDashboardVO> memGenderList();

	/**
	 * 프로젝트 파트 대시보드 리스트
	 * @param dataListVO
	 * @return
	 */
	public List<AdminDashboardVO> projectPartList();

	/**
	 * 프로젝트 기능별 평점 대시보드 리스트
	 * @param dataListVO
	 * @return
	 */
	public List<AdminDashboardVO> projectFunctiontCountList();

	/**
	 * 프로젝트 기능별 한줄평 리스트
	 * @param pagingVO
	 * @return
	 */
	public List<AdminDashboardVO> projectFunctiontTextList(PagingVO<AdminDashboardVO> pagingVO);

	/**
	 * 로그인/로그아웃 관리
	 * @param pagingVO
	 * @return
	 */
	public Map<String, List> loginInfoList();
	
	public List<AdminDashboardVO> wordStackList();
	
}
