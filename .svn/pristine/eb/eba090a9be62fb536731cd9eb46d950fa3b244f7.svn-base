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

}
