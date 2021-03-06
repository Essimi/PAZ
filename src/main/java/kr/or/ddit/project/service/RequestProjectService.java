package kr.or.ddit.project.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProjectVO;
import kr.or.ddit.vo.RequestProjectVO;

public interface RequestProjectService {
	
	/**
	 * 회원에게 온 프로젝트 초대 요청 리스트 출력
	 * @param memberVO
	 * @return List<RequestProjectVO>
	 */
	public List<RequestProjectVO> selectRequestList(MemberVO memberVO);
	
	/**
	 * 요청 수락 시 요청 상태, p_mem 추가, mem_mapping 추가 까지 한번
	 * @param STATUS_CODE
	 * @return OK, FAILD
	 * @throws Exception 
	 */
	public ServiceResult updateRequestProjecOk (RequestProjectVO requestProjectVO);
	
	/**
	 * 프로젝트 요청 수락 시 해당 회원을 p_mem 테이블에 추가
	 * @param memberVO
	 * @return OK, FAILD
	 */
//	public ServiceResult InsertProjectMember (RequestProjectVO requestProjectVO);

	/**
	 * 프로젝트 멤버 초대 (초대 시 REQ_HISTORY에 추가)
	 * @param projectVO
	 * @return ServiceResult OK, FAILD
	 */
	public ServiceResult InsertRequstProjectHistory (RequestProjectVO requestProjectVO);

	/**
	 * 프로젝트 멤버 리스트 조회 
	 * @param projectVO
	 * @return List<MemberVO>
	 */
	public List<MemberVO> SelectProjectMemberList (RequestProjectVO requestProjectVO);
	
	
	/**
	 * 프로젝트 요청 상태만 수정 (거절) 
	 * @return OK, FAILD
	 */
	public ServiceResult updateRequestProjectStatus(RequestProjectVO requestProjectVO);
	
	
	/**
	 * 임시 회원 존재 여부 판별 
	 * @param memberVO
	 * @return
	 */
	public ServiceResult selectMemberInfo(String nickName);
	
	
	/**
	 * 해당 프로젝트 요청 대기 리스트
	 * @param projectVO
	 * @return
	 */
	public List<RequestProjectVO> listRequestProjectHistory(ProjectVO projectVO);
	
	
	/**
	 * 프로젝트에서 탈퇴한 회원 초대 시 outCode 변경 
	 * @param projectVO
	 * @return
	 */
	public ServiceResult updatePmemOutCode (ProjectVO projectVO);
	
}
