package kr.or.ddit.payment.refund.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.PayRefundVO;
import kr.or.ddit.vo.PayVO;

/**
 * 환불 관련 
 * @author essimi
 *
 */
public interface PayRefundService {
	
	/**
	 * 결제 정보 조회
	 * @param pay
	 * @return
	 */
	public  List<PayVO> payInfo(String memId);
	
	/**
	 * 환불 내역 저장
	 * @param payRefund
	 * @return
	 */
	public ServiceResult createPayRefundInfo(PayRefundVO payRefund);
	
	/**
	 * 데드라인 검증
	 * @param payRefund
	 * @return
	 */
	public String memberDeadLineInfo(String memId);
	
	/**
	 * 데드라인 검증에 걸렸을경우, 회원의 결제 정보 변경
	 * @param pCode
	 * @return
	 */
	public ServiceResult memberDeadLineChange(String memId);


}
