package kr.or.ddit.common.authentication.dao;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.MemberVO;


public interface authenticationDAO {
	
	/**
	 * 로그인을 위해 회원의 정보를 가져옴
	 * @param member
	 * @return
	 */
	public MemberVO authenticateMember(MemberVO member);
}
