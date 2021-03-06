package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProjectVO;

public interface MemberService {
	/**
	 * 회원 가입
	 * @param memberVO
	 * @return OK, FAILED
	 * @throws Exception
	 */
	public ServiceResult createMember(MemberVO member);
	
	/**
	 * 카카오 회원가입
	 * @param member
	 * @param imgURL TODO
	 * @return
	 */
	public ServiceResult createKakaoMember(MemberVO member, String imgURL);
	
	/**
	 * 프로젝트 회원목록 조회
	 * @param member
	 * @return
	 */
	public List<MemberVO> projectMemberList(ProjectVO project);
	
	/**
	 * 한 회원의 정보 조회
	 * @param member
	 * @return
	 */
	public MemberVO selectMember(MemberVO member);
	
	/**
	 * 회원가입시 아이디 중복 체크
	 * @param member
	 * @return OK, PKDUPLICATED
	 */
	public ServiceResult memberIdCheck(MemberVO member);
	
	/**
	 * 인증 메일 전송
	 * @param member
	 * @param sessionId TODO
	 */
	public Map<String, String> sendMail(MemberVO member, String sessionId);
	
	/**
	 * 회원의 이메일 주소 체크
	 * @param member
	 * @return
	 */
	public ServiceResult memberEmailCheck(MemberVO member); 
	
	/**
	 * 회원의 정보 수정
	 * @param member
	 * @return
	 */
	public ServiceResult memberUpdate(MemberVO member);
	
	/**
	 * 로그인한 회원의 결제유무를 판단합니다.
	 * @param memId
	 * @return
	 */
	public ServiceResult memperPay(String memId);
	
	/**
	 * 데드라인이 현재 날짜보다 작은 멤버들만 구해옵니다.
	 * @return
	 */
	public List<Map<Object, String>> memberDeadLineInfo();
	
	/**
	 * 기한이 지난 멤버의 상태를 변경합니다.
	 * @return
	 */
	public ServiceResult memberDeadLineChangePayment(List<String> memId);
	
}
