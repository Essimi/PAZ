package kr.or.ddit.utils;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.AttatchVO;
import kr.or.ddit.vo.MeetingVO;

@Repository
public interface AttatchDAO {
	/**
	 * 다운로드를 위한 생성 
	 * @param attatch
	 * @return
	 */
	public int intsertAttatches(AttatchVO attatch);
	/**
	 * 다운로드시 사용할 하나의 첨부파일에대한 메타 데이터 조회
	 * @param attatch
	 * @return
	 */
	public AttatchVO selectAttatch(AttatchVO attatch);
	/**
	 * 추가한 첨부파일 삭제
	 * @param attatch
	 * @return
	 */
	public int deleteAttatChes(AttatchVO attatch); 
}
