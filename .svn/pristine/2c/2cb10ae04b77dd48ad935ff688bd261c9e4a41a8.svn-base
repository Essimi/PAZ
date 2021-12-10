package kr.or.ddit.admin.payRetrieve.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.PayVO;
@Repository
public interface PayRetrieveDAO {
	
	/**
	 * 페이징 하기위한 데이터 레코드 세기
	 * @param pagingVO
	 * @return
	 */
	public int selectTotalRecord(PagingVO<PayVO> pagingVO);
	
	/**
	 * 결제 조회 리스트
	 * @param pagingVO
	 * @return
	 */
	public List<PayVO> selectPayRetrieveList(PagingVO<PayVO> pagingVO);
	
	/**
	 * 결제 상세조회
	 * @param payCode
	 * @return
	 */
	public PayVO selectPayRetrieve(String payCode);
	
}
