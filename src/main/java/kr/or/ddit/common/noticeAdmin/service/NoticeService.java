package kr.or.ddit.common.noticeAdmin.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.AttatchVO;
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
	
	
	/**
	 * 공지사항 첨부파일 다운로드
	 * @param
	 * @return
	 */
	public AttatchVO download(String noticeCode);
	
	
	/**
	 * 공지사항 수정
	 * @param
	 * @return
	 */
	public ServiceResult updateNotice(NoticeVO notice);
	
	
	/**
	 * 공지사항 삭제
	 * @param
	 * @return
	 */
	public ServiceResult deleteNotice(String noticeCode);
	

}
