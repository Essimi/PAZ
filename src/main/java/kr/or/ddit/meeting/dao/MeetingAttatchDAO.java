package kr.or.ddit.meeting.dao;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.AttatchVO;
import kr.or.ddit.vo.MeetingVO;
import kr.or.ddit.vo.NoticeVO;

@Repository
public interface MeetingAttatchDAO {
	
	/**
	 * 첨부파일 등록
	 * @param 
	 * @return
	 */
	public int insertMeetingAttatche(AttatchVO attatch);
	
	
	/**
	 * 첨부파일의 메타데이터 조회
	 * @param 
	 * @return
	 */
	public AttatchVO selectMeetingAttatch(String fileCode);
	
	
	/**
	 * 첨부파일 삭제
	 * @param 
	 * @return
	 */
	public int deleteMeetingAttatche(String meeting);
	

}
