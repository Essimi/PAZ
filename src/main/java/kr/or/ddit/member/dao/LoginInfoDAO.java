package kr.or.ddit.member.dao;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.MemberVO;

@Repository
public interface LoginInfoDAO {
	
	/**
	 * 회원의 로그인 시간에 정보를 입력
	 * @param member
	 * @return
	 */
	public int insertLoginInfo(String memId);
	
	/**
	 * 회원의 로그아웃 시간에 정보를 입력
	 * @param member
	 * @return
	 */
	public int insertLogoutInfo(String memId);
}
