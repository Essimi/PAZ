package kr.or.ddit.common.noticeAdmin.dao;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.AttatchVO;
import kr.or.ddit.vo.NoticeVO;

@Repository
public interface NoticeAttatchDAO {
	
	/**
	 * 첨부파일 등록
	 * @param 
	 * @return
	 */
	public int insertNoticeAttatche(AttatchVO attatch);
	
	/**
	 * 첨부파일 삭제
	 * @param 
	 * @return
	 */
	public int deleteNoticeAttatche(String noticeCode);
	
	/**
	 * 다운로드에 필요한 첨부파일에 대한 메타데이터 조회
	 * @param
	 * @return
	 */
	public AttatchVO selectAttatch(String noticeCode);
	
}
