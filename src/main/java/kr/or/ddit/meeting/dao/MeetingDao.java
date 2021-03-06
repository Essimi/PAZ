package kr.or.ddit.meeting.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.DataListVO;
import kr.or.ddit.vo.MeetingVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProjectMemberVO;


@Repository
public interface MeetingDao {
	/**
	 * 회의록 추가
	 * @param meeting TODO
	 * @return > 0 - 성공
	 */
	public int inser1tMeeting(MeetingVO meeting);
	public int inser2tMeeting(MeetingVO meeting);
	/**
	 * 회의록 전체 레코드 수 조회
	 * @param pagingVO TODO
	 * @return
	 */
	public int selectTotalRecord(PagingVO<MeetingVO> pagingVO);
	/**
	 * 회의록 상세조회
	 * @param MeeNo
	 * @return 조건에 맞는 회의록이 없으면, null 반환
	 */
	public MeetingVO selectMeeting(String meeting);
	
	
	/**
	 * 회의록 수정
	 * @param meeting
	 * @return > 0 - 성공
	 */
	public int updateMeeting(MeetingVO meeting);
	/**
	 * 회의록삭제
	 * @param MeeNo
	 * @return
	 */
	public int deleteMeeting(String meeNo);
	
	/**
	 * 회의록 참여인원 삭제 
	 * @param boNo
	 * @return
	 */
	public int deleteMeetingMemberList(MeetingVO meeting);
	
	/**
	 * 회의록  참여 인원 목록 조회
	 * @param pagingVO
	 * @return 조회 데이터가 없다면, size()==0
	 */
	public List<MeetingVO> selectMeetingList(PagingVO<MeetingVO> pagingVO);
	
	
	
	/**
	 * 회의록 참여인원전체 목록 체크박스
	 * @param projectMemberVO
	 * @return
	 */
	public List<ProjectMemberVO> chackmember(DataListVO<ProjectMemberVO> dataListVO);
	
	/**
	 * 수정페이지 참여인원 목록 체크박스와 체크사항
	 * @param dataListVO
	 * @return
	 */
	public List<ProjectMemberVO> chackSelect(DataListVO<ProjectMemberVO> dataListVO);

	
}
