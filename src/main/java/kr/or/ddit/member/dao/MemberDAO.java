package kr.or.ddit.member.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.MemberIkonVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.ProjectVO;

@Repository
public interface MemberDAO {
	/**
	 * 회원 가입
	 * @param memberVO
	 * @return
	 */
	public int insertMember(MemberVO member);
	
	/**
	 * 회원가입된 회원 기본 역할 부여
	 * @param member
	 * @return
	 */
	public int insertMemberRole(MemberVO member);
	
	/**
	 * 프로젝트 회원 리스트 조회
	 * @param member
	 * @return
	 */
	public List<MemberVO> projectMemberList(ProjectVO project);
	
	/**
	 * 한 회원의 정보를 가져옴
	 * @param member
	 * @return
	 */
	public MemberVO selectMember(MemberVO member);
	
	/**
	 * 한 회원의 역할을 모두 가져옴
	 * @param memId
	 * @return
	 */
	public MemberVO selectMemberForAuth(String memId);
	
	/**
	 * 등록된 회원의 이메일 중복 체크
	 * @param member
	 * @return
	 */
	public MemberVO selectMemberEmail(MemberVO member);
	
	/**
	 * 등록된 회원의 정보를 수정
	 * @param member
	 * @return
	 */
	public int updateMember(MemberVO member);
	
	/**
	 * 임시 비밀번호로 변경
	 * @param member
	 * @return
	 */
	public int updatePassword(MemberVO member);
	
	/**
	 * 회원의 프로필 이미지 삭제
	 * @param memIkon
	 * @return
	 */
	public int deleteMemberImage(MemberIkonVO memIkon);
	
	/**
	 * 회원의 프로필 이미지 추가
	 * @param memIkon
	 * @return
	 */
	public int insertMemberImage(MemberIkonVO memIkon);
	
	// =====================================================================================================================================
	
		/**
		 * 관리자 - 모든 회원 리스트
		 * @param pagingVO
		 * @return
		 */
		public List<MemberVO> selectAllMemberList(PagingVO<MemberVO> pagingVO);
		
		
		/**
		 * 관리자 - 총 회원 수 
		 * @param pagingVO
		 * @return
		 */
		public int selectMemberTotal(PagingVO<MemberVO> pagingVO);
		
		
		/**
		 * 관리자 - 회원 탈퇴
		 * @param memberVO
		 * @return
		 */
		public int updateMemberOutCode (MemberVO memberVO);
		
		/**
		 * 회원 탈퇴시 프로젝트 참여멤버에서도 빠짐
		 * @param memberVO
		 * @return
		 */
		public int updatePmemOutStatus (MemberVO memberVO);
		
		/**
		 * 로그인한 회원의 결제유무를 판단합니다.
		 * @param memId
		 * @return
		 */
		public String memberPay(String memId);
		
		/**
		 * 데드라인이 현재날짜보다 작은 멤버만 출력합니다.(scheduler)
		 * @return
		 */
		public List<Map<Object, String>> memberDeadLineInfo();
		
		/**
		 * 기한이 지난 멤버의 상태를 변경합니다.
		 * @return
		 */
		public int memberDeadLineChangePayment(List<String> memId);
}
