package kr.or.ddit.admin.member.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PagingVO;

public interface AdminMemberService {
	
	/**
	 * 전체 회원 리스트 출력 
	 * @return
	 */
	public List<MemberVO> selectAllMemberList(PagingVO<MemberVO> pagingVO);
	
	
	/**
	 * 회원 탈퇴
	 * @param memberVO
	 * @return
	 */
	public ServiceResult updateMemberOutCode (MemberVO memberVO);

}
