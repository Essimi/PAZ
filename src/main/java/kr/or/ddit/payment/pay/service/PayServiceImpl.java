package kr.or.ddit.payment.pay.service;


import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.payment.pay.dao.PayDAO;
import kr.or.ddit.vo.PayVO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PayServiceImpl implements PayService {
	
	@Inject
	private PayDAO payDao;

	@Transactional
	@Override
	public ServiceResult createPayRecord(PayVO pay) {
		
		ServiceResult result = null;
		
		// 결제정보 추가
		int rowcnt = payDao.insertPayRecord(pay);
		
		if(rowcnt > 0) {
			
			// 회원 상태 업데이트
			int update = payDao.updateMemberStatus(pay);
			
			if(update > 0) {
				
				// 회원 이용기한 업데이트
				int update2 = payDao.updateMemberPayDate(pay);
				
				if(update2 > 0) {
					
					result = ServiceResult.OK;
					
				}else {
					
					result = ServiceResult.FAILED;
				}
				
			}else {
				
				result = ServiceResult.FAILED;
			}
			
		}else {
			result = ServiceResult.FAILED;
		}
		
		return result;
	}

	@Override
	public ServiceResult createPlusPayRecord(PayVO pay) {
		
		ServiceResult result = null;
		
		// 결제정보 추가
		int rowcnt = payDao.createPlusPayRecord(pay);
		
		if(rowcnt > 0) {
			// 회원 이용기한 업데이트
			int update2 = payDao.updateMemberPayPlusDate(pay);
			
			if(update2 > 0) {
				
				result = ServiceResult.OK;
				log.info("여기?1");
				
			}else {
				
				result = ServiceResult.FAILED;
				log.info("여기?2");
			}
			
		}else {
			result = ServiceResult.FAILED;
			log.info("여기?3");
		}
		
		return result;
	}
}
