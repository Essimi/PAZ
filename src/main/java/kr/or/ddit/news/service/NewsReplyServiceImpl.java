package kr.or.ddit.news.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.news.dao.NewsReplyDAO;
import kr.or.ddit.vo.NewsReplyVO;

@Service
public class NewsReplyServiceImpl implements NewsReplyService {

	@Inject
	private NewsReplyDAO newsReplyDAO;

	@Override
	public ServiceResult createReply(NewsReplyVO reply) {

		ServiceResult result = null;

		int rowcnt = newsReplyDAO.insertNewsReply(reply);

		if (rowcnt > 0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}

		return result;
	}

	@Override
	public ServiceResult modifyReply(NewsReplyVO reply) {
		ServiceResult result = null;

		int rowcnt = newsReplyDAO.insertNewsReply(reply);

		if (rowcnt > 0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}

		return result;
	}

	@Override
	public ServiceResult removeReply(NewsReplyVO reply) {
		ServiceResult result = null;

		int rowcnt = newsReplyDAO.insertNewsReply(reply);

		if (rowcnt > 0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}

		return result;
	}

	@Override
	public List<NewsReplyVO> newsReplyList(NewsReplyVO reply) {
		return newsReplyDAO.newsReplyList(reply);
	}

}
