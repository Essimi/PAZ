package kr.or.ddit.common.noticeAdmin.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PagingVO;

@Repository
public interface NoticeDAO {
	
	/**
	 * 공지사항 전체 레코드 수 조회
	 * @param pagingVO TODO
	 * @return
	 */
	public int selectTotalRecord(PagingVO<NoticeVO> pagingVO);
	
	/**
	 * 공지사항 목록 조회
	 * @param pagingVO
	 * @return 조회 데이터가 없다면, size()==0
	 */
	public List<NoticeVO> selectNoticeList(PagingVO<NoticeVO> pagingVO);
	
	/**
	 * 공지사항 상세 조회
	 * @param String noticeCode
	 * @return NoticeVO
	 */
	public NoticeVO selectNotice(String noticeCode);
	
	
	/**
	 * 공지사항 글 코드 조회
	 * @param 
	 * @return
	 */
	public String selectNoticeCode();
	
	/**
	 * 공지사항 등록
	 * @param NoticeVO
	 * @return
	 */
	public int insertNotice(NoticeVO notice);
	

}
