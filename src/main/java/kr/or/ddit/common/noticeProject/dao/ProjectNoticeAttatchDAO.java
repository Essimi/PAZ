package kr.or.ddit.common.noticeProject.dao;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.AttatchVO;

@Repository
public interface ProjectNoticeAttatchDAO {
	
	/**
	 * 프로젝트 공지사항 첨부파일 등록
	 * @param 
	 * @return
	 */
	public int insertProjectNoticeAttatche(AttatchVO attatch);
	
	/**
	 * 프로젝트 공지사항 첨부파일 삭제
	 * @param 
	 * @return
	 */
	public int deleteProjectNoticeAttatche(String noticeCode);
	
	/**
	 * 프로젝트 공지사항 첨부파일 다운로드에 필요한 메타데이터 조회
	 * @param
	 * @return
	 */
	public AttatchVO selectProjectNoticeAttatch(String noticeCode);

}
