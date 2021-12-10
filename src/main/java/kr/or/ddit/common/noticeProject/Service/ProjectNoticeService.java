package kr.or.ddit.common.noticeProject.Service;

import java.util.List;

import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PagingVO;

public interface ProjectNoticeService {

	/**
	 * 프로젝트 공지사항 전체 목록 조회
	 * @param pagingVO
	 * @return
	 */
	public List<NoticeVO> selectProjectNoticeList(PagingVO<NoticeVO> pagingVO);
	
}
