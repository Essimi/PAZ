package kr.or.ddit.news.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.PKNotFoundException;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.news.dao.NewsReplyDAO;
import kr.or.ddit.vo.NewsReplyVO;
import kr.or.ddit.vo.NewsVO;

@Service
public class NewsReplyServiceImpl implements NewsReplyService {

	@Inject
	private NewsReplyDAO newsReplyDAO;

	@Override
	public ServiceResult createReply(NewsReplyVO newsReply) {

		ServiceResult result = null;

		int rowcnt = newsReplyDAO.insertNewsReply(newsReply);

		if (rowcnt > 0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}

		return result;
	}

	@Override
	public ServiceResult modifyReply(NewsReplyVO newsReply) {
		ServiceResult result = null;

		int rowcnt = newsReplyDAO.updateNewsReply(newsReply);

		if (rowcnt > 0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}

		return result;
	}

	@Override
	public ServiceResult removeReply(NewsReplyVO newsReply) {
		ServiceResult result = null;

		int rowcnt = newsReplyDAO.deleteNewsReply(newsReply);
		if (rowcnt > 0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}

		return result;
	}

	@Override
	public List<NewsReplyVO> newsReplyList(NewsReplyVO newsReply) {
		return newsReplyDAO.newsReplyList(newsReply);
	}

	@Override
	public NewsReplyVO selectNewsReply (NewsReplyVO newsReply) {
		NewsReplyVO newsReplyOne = newsReplyDAO.selectNewsReply(newsReply);
		if(newsReplyOne == null) {
			throw new PKNotFoundException(newsReply + "없음");
		}
		return newsReplyOne;
	}

}
