package kr.or.ddit.member.service;

import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{

	@Inject
	private MemberDAO memberDAO;
	
	// 비밀번호 암호화 객체
//	@Inject
//	private PasswordEncoder encoder;
	
	// 비밀번호를 암호화해 MemberVO에 세팅
	private void encryptPassword(MemberVO member) {
//		member.setMemPass(encoder.encode(member.getMemPass()));
	}
	
	@Override
	public ServiceResult createMember(MemberVO memberVO) throws Exception {
		ServiceResult result = null;
		if(memberDAO.selectMember(memberVO) == null) {
			encryptPassword(memberVO);
			
			int rowCnt = memberDAO.insertMember(memberVO);
			if(rowCnt > 0) {
				result = ServiceResult.OK;
			}else {
				result = ServiceResult.FAILED;
			}
		}else {
			result = ServiceResult.PKDUPLICATED;
		}
		
		return result;
	}

}
