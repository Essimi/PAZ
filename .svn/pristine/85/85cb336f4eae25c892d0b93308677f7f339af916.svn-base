package kr.or.ddit.review.dao;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.ReviewVO;

@Repository
public interface ReviewDAO {
	
	
	/**
	 * 리뷰 상태 변경 - 상태가 1인 사람들에게 리뷰 요청 보냄 
	 * @return
	 */
	public int updateReviewStatus();
	
	
	/**
	 * 리뷰 등록
	 * @param review
	 * @return
	 */
	public int insertReview(ReviewVO review);

	
	/**
	 * 리뷰 등록한 사람들의 리뷰 상태 변경 - 1에서 0으로
	 * @return
	 */
	public int updateReviewFinish(ReviewVO review);
}
