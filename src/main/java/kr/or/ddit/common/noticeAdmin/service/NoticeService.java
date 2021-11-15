package kr.or.ddit.common.noticeAdmin.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.MeetingVO;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PagingVO;

public interface NoticeService {
	
	/**
	 * 공지사항 전체 목록 조회
	 * @param pagingVO
	 * @return
	 */
	public List<NoticeVO> selectNoticeList(PagingVO<NoticeVO> pagingVO);
	
	/**
	 * 공지사항 상세 조회
	 * @param String noticeCode
	 * @return NoticeVO
	 */
	public NoticeVO selectNotice(String noticeCode);
	
	
	/**
	 * 공지사항 등록
	 * @param NoticeVO
	 * @return
	 */
	public ServiceResult insertNotice(NoticeVO notice);
	

}
