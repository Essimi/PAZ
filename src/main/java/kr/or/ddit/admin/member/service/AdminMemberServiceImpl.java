package kr.or.ddit.admin.member.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PagingVO;

@Service
public class AdminMemberServiceImpl implements AdminMemberService{

	@Inject
	MemberDAO memberDao;
	
	/**
	 * 전체 회원 리스트 
	 */
	@Override
	public List<MemberVO> selectAllMemberList(PagingVO<MemberVO> pagingVO) {
		
		List<MemberVO> memberList = memberDao.selectAllMemberList(pagingVO);
		
		pagingVO.setTotalRecord(memberDao.selectMemberTotal(pagingVO));
		pagingVO.setDataList(memberList);
		
		return memberList;
	}

	/**
	 * 회원 탈퇴
	 */
	@Override
	@Transactional
	public ServiceResult updateMemberOutCode(MemberVO memberVO) {
		
		ServiceResult result = null;
		
		// 회원 outCode 변경
		int cnt1 = memberDao.updateMemberOutCode(memberVO);
		
		// pMem에 outCod 변경
		memberDao.updatePmemOutStatus(memberVO);
		
		if(cnt1 > 0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		
		return result;
	}

}
