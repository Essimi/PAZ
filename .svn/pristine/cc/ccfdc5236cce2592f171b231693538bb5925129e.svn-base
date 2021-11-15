package kr.or.ddit.member.dao;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.MemberVO;

@Repository
public interface MemberDAO {
	/**
	 * 회원 가입
	 * @param memberVO
	 * @return
	 */
	public int insertMember(MemberVO memberVO);
	
	/**
	 * 한 회원의 정보를 가져옴
	 * @param memberVO
	 * @return
	 */
	public MemberVO selectMember(MemberVO memberVO);
	
	/**
	 * 한 회원의 역할을 모두 가져옴
	 * @param memId
	 * @return
	 */
	public MemberVO selectMemberForAuth(String memId);
}
