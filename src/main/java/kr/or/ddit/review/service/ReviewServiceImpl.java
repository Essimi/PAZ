package kr.or.ddit.review.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.review.dao.ReviewDAO;
import kr.or.ddit.vo.ReviewVO;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Inject
	ReviewDAO dao;

	@Override
	@Transactional
	public ServiceResult updateReviewStatus() {
		
		ServiceResult result = null;
		
		int cnt = dao.updateReviewStatus();
		
		if(cnt > 0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	@Override
	@Transactional
	public ServiceResult insertreview(ReviewVO reviewVO) {
		
		ServiceResult result = null;
		
		// 리뷰 등록 시 리뷰 상태 코드 업데이트 해야해 !!
		int cnt1 = dao.insertReview(reviewVO);
		
		int cnt2 = dao.updateReviewFinish(reviewVO);
		
		if(cnt1 > 0 && cnt2 > 0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		
		return result;
	}

}
