package kr.or.ddit.common.noticeProject.Service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.AttatchVO;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PagingVO;

public interface ProjectNoticeService {

	/**
	 * 프로젝트 공지사항 전체 목록 조회
	 * @param pagingVO
	 * @return
	 */
	public List<NoticeVO> selectProjectNoticeList(PagingVO<NoticeVO> pagingVO);
	
	/**
	 * 프로젝트 공지사항 상세 조회
	 * @param String noticeCode
	 * @return NoticeVO
	 */
	public NoticeVO selectProjectNotice(String noticeCode);
	
	/**
	 * 프로젝트 공지사항 첨부파일 다운로드
	 * @param
	 * @return
	 */
	public AttatchVO downloadProjectAttatch(String noticeCode);
	
	/**
	 * 프로젝트 공지사항 등록
	 * @param NoticeVO
	 * @return
	 */
	public ServiceResult insertProjectNotice(NoticeVO notice);
	
	/**
	 * 프로젝트 공지사항 수정
	 * @param
	 * @return
	 */
	public ServiceResult updateProjectNotice(NoticeVO notice);
	
	/**
	 * 프로젝트 공지사항 삭제
	 * @param
	 * @return
	 */
	public ServiceResult deleteProjectNotice(String noticeCode);
	
}
