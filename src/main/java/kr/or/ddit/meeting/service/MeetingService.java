package kr.or.ddit.meeting.service;

import java.io.IOException;
import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.DataListVO;
import kr.or.ddit.vo.MeetingVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProjectMemberVO;

public interface MeetingService {
	/**
	 * 회의록 생성 
	 * @param meeting
	 * @return
	 */
	 
	public ServiceResult createMeeting(MeetingVO meeting);
	/**
	 * 회의록 상세조회
	 * @param Meeting
	 * @return
	 */
	public MeetingVO meetingSelect(String meeNo);
	
	/**
	 * 프로젝트 맴버 목록
	 * @param meeting
	 * @return
	 */
	
	public List<ProjectMemberVO> chackmember(DataListVO<ProjectMemberVO> dataListVO);
	
	
	/**
	 * 페이징 처리와 목록 리스트
	 * @param pagingVO
	 * @return
	 */
	public List<MeetingVO> meetingPageList(PagingVO<MeetingVO> pagingVO);
	
	
	/**
	 * 회의록 수정
	 * @param Meeting
	 * @return
	 * @throws IOException 
	 */
//	public ServiceResult meetingModify(MeetingVO meeting) throws IOException;
	/**
	 * 회의록 삭제 
	 * @param meeting
	 * @return
	 * @throws IOException 
	 */
//	public ServiceResult meetingDelete(MeetingVO meeting) throws IOException;
}