package kr.or.ddit.member.service;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.MemberVOWrapper;

@Service("userDetailService")
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Inject
	private MemberDAO memberDAO;

	@Override
	public UserDetails loadUserByUsername(String memId) throws UsernameNotFoundException {
		
		MemberVO member = memberDAO.selectMemberForAuth(memId);
		if(member==null)
			throw new UsernameNotFoundException(memId+"에 해당하는 사용자가 없음.");
		
		return new MemberVOWrapper(member);
	}

}
