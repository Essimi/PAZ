package kr.or.ddit.payment.pay.dao;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.PayVO;

/**
 * 결제 정보 저장
 * @author essimi
 *
 */
@Repository
public interface PayDAO {
	
	/**
	 * 결제 기록 저장
	 * @param pay
	 * @return
	 */
	public int insertPayRecord(PayVO pay);
	
	/**
	 * 결제 완료 후 회원의 상태코드 변경
	 * @param pay
	 * @return
	 */
	public int updateMemberStatus(PayVO pay);
	
	/**
	 * 결제 완료 후 회원의 사용기한 변경
	 * @param pay
	 * @return
	 */
	public int updateMemberPayDate(PayVO pay);
	
	/**
	 * 추가 결제
	 * @param pay
	 * @return
	 */
	public int createPlusPayRecord(PayVO pay);
	
	/**
	 * 추가 결제 후 이용기한 연장
	 * @param pay
	 * @return
	 */
	public int updateMemberPayPlusDate(PayVO pay);


}
