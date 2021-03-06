package kr.or.ddit.common.noticeProject.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PagingVO;

@Repository
public interface ProjectNoticeDAO {
	
	/**
	 * 프로젝트 공지사항 전체 레코드 수 조회
	 * @param pagingVO TODO
	 * @return
	 */
	public int selectTotalRecord(PagingVO<NoticeVO> pagingVO);
	
	/**
	 * 공지사항 목록 조회
	 * @param pagingVO
	 * @return 조회 데이터가 없다면, size()==0
	 */
	public List<NoticeVO> selectProjectNoticeList(PagingVO<NoticeVO> pagingVO);
	
	/**
	 * 공지사항 상세 조회
	 * @param String noticeCode
	 * @return NoticeVO
	 */
	public NoticeVO selectProjectNotice(String noticeCode);
	
	/**
	 * 공지사항 글 코드 생성 및 조회
	 * @param 
	 * @return
	 */
	public String selectProjectNoticeCode();
	
	/**
	 * 프로젝트 공지사항 등록
	 * @param NoticeVO
	 * @return
	 */
	public int insertProjectNotice(NoticeVO notice);
	
	/**
	 * 프로젝트 공지사항 수정
	 * @param NoticeVO
	 * @return
	 */
	public int updateProjectNotice(NoticeVO notice);
	
	/**
	 * 프로젝트 공지사항 삭제
	 * @param
	 * @return
	 */
	public int deleteProjectNotice(String noticeCode);

}
