package kr.or.ddit.payment.refund.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.common.PKNotFoundException;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.payment.refund.dao.PayRefundDAO;
import kr.or.ddit.vo.PayRefundVO;
import kr.or.ddit.vo.PayVO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PayRefundServiceImpl implements PayRefundService {
	
	@Inject
	private PayRefundDAO payRefundDao;

	@Override
	public List<PayVO> payInfo(String memId) {
		
		List<PayVO> resultPay = payRefundDao.payInfo(memId);
		
		if(resultPay == null) {
			throw new PKNotFoundException("결재내역이 없습니다.");
		}
		return resultPay;
	}

	@Transactional
	@Override
	public ServiceResult createPayRefundInfo(PayRefundVO payRefund) {
		
		ServiceResult result = null;
		
		int rowcnt = payRefundDao.insertRefundInfo(payRefund);
		
		if(rowcnt > 0) {
			
			int rowcnt2 = payRefundDao.updateRefundDeadLine(payRefund);
			
			if(rowcnt2 > 0) {
				
				int rowcnt3 = payRefundDao.updateChangePayStatus(payRefund);
				
				if(rowcnt3 > 0) {
				
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
	public String memberDeadLineInfo(String memId) {
		
		String result = payRefundDao.memberDeadLineInfo(memId);
				
		return result;
	}

	@Transactional
	@Override
	public ServiceResult memberDeadLineChange(String memId) {
		
		ServiceResult result = null;
		
		int rowcnt = payRefundDao.memberDeadLineChange(memId);
		
		if(rowcnt > 0) {
			
			result = ServiceResult.OK;
			
		}else {
			
			result = ServiceResult.FAILED;
			
		}
		
		return result;
	}
}
