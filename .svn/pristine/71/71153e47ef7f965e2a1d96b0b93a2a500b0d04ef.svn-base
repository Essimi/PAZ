package kr.or.ddit.admin.payRetrieve.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.admin.payRetrieve.dao.PayRetrieveDAO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.PayVO;

@Service
public class PayRetrieveServiceImpl implements PayRetrieveService {
	@Inject
	private PayRetrieveDAO Dao;
	
	@Override
	public List<PayVO> selectPayRetrieveList(PagingVO<PayVO> pagingVO){
		
		pagingVO.setTotalRecord(Dao.selectTotalRecord(pagingVO));
		List<PayVO> payRetrieveList = Dao.selectPayRetrieveList(pagingVO);
		pagingVO.setDataList(payRetrieveList);
		
		return payRetrieveList;
	}

	@Override
	public PayVO selectPayRetrieve(String payCode) {
		PayVO payRetrieve = Dao.selectPayRetrieve(payCode);
		return payRetrieve;
	}
	
	
}
