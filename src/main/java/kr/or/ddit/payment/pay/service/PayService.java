package kr.or.ddit.payment.pay.service;


import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.PayVO;

/**
 * 결제 정보 저장
 * @author essimi
 *
 */
public interface PayService {
	
	/**
	 * 결제 기록 저장
	 * @param pay
	 * @return
	 */
	public ServiceResult createPayRecord(PayVO pay);
	
	/**
	 * 추가 결제 기록 저장
	 * @param pay
	 * @return
	 */
	public ServiceResult createPlusPayRecord(PayVO pay);
	

}
