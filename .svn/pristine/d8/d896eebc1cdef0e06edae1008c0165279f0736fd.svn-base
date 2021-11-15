package kr.or.ddit.project.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.RequestProjectVO;

@Repository
public interface RequestProjectDAO {
	
	/**
	 * 회원에게 온 프로젝트 초대 요청 리스트 출력
	 * @param memberVO
	 * @return List<RequestProjectVO>
	 */
	public List<RequestProjectVO> selectRequestList(MemberVO memberVO);
	
	/**
	 * 프로젝트 요청 상태 수정 (수락, 대기, 거절) 
	 * @param STATUS_CODE
	 * @return int
	 */
	public int updateRequestProjecStatus(RequestProjectVO requestProjectVO);
	
	/**
	 * 프로젝트 요청 수락 시 해당 회원을 p_mem 테이블에 추가
	 * @param RequestProjectVO
	 * @return int
	 */
	public int InsertProjectMember (RequestProjectVO requestProjectVO);
	

	/**
	 * 프로젝트 멤버 초대 (초대 시 REQ_HISTORY에 추가)
	 * @param projectVO
	 * @return int 
	 */
	public int InsertRequstProjectHistory (RequestProjectVO requestProjectVO);
	
	/**
	 * 프로젝트 멤버 리스트 조회 
	 * @param projectVO
	 * @return List<MemberVO>
	 */
	public List<MemberVO> SelectProjectMemberList (RequestProjectVO requestProjectVO);
	
	
	/**
	 * mem_mapping 에 회원 아이디, 역할 코드 추가
	 * @param requestProjectVO
	 * @return
	 */
	public int InsertMemberMapping (RequestProjectVO requestProjectVO);


	/**
	 * 임시 만듦. 회원 정보 조회 
	 */
	public String selectMemberInfo (String nickName); 
	
	
	/**
	 * 해당 프로젝트 요청 대기 리스트 
	 * @param projectVO
	 * @return
	 */
	public List<RequestProjectVO> listRequestProjectHistory(ProjectVO projectVO);
}
