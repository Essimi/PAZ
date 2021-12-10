package kr.or.ddit.payment.refund.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.PayRefundVO;
import kr.or.ddit.vo.PayVO;

@Repository
public interface PayRefundDAO {
	
	/**
	 * 결제 정보 조회
	 * @param pay
	 * @return
	 */
	public List<PayVO> payInfo(String pCode);
	
	/**
	 * 환불 정보 저장
	 * @param payRefund
	 * @return
	 */
	public int insertRefundInfo(PayRefundVO payRefund);
	
	/**
	 * 환불 완료시 개인의 데드라인 변경
	 * @param pCode
	 * @return
	 */
	public int updateRefundDeadLine(PayRefundVO payRefund);
	
	/**
	 * 환불 완료시 환불 정보 환불 상태로 변경
	 * @param pCode
	 * @return
	 */
	public int updateChangePayStatus(PayRefundVO payRefund);
	
	/**
	 * 데드라인 검증
	 * @param pCode
	 * @return
	 */
	public String memberDeadLineInfo(String memId);
	
	/**
	 * 데드라인 검증에 걸렸을경우, 회원의 결제 정보 변경
	 * @param pCode
	 * @return
	 */
	public int memberDeadLineChange(String memId);

}
