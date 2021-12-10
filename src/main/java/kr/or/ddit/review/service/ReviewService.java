package kr.or.ddit.review.service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.ReviewVO;

public interface ReviewService {

	/**
	 * 리뷰 호출 여부 변경 
	 * @return
	 */
	public ServiceResult updateReviewStatus();
	
	
	/**
	 * 리뷰 등록
	 * @param reviewVO
	 * @return
	 */
	public ServiceResult insertreview(ReviewVO reviewVO);
}
