package kr.or.ddit.news.service;

import java.io.IOException;
import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.NewsReplyVO;
import kr.or.ddit.vo.NewsVO;


public interface NewsReplyService {
	
	public ServiceResult createReply(NewsReplyVO newsReply);
	public ServiceResult modifyReply(NewsReplyVO newsReply);
	public ServiceResult removeReply(NewsReplyVO newsReply);
	
	public List<NewsReplyVO> newsReplyList(NewsReplyVO newsReply);
	
	public NewsReplyVO selectNewsReply (NewsReplyVO newsReply);

}
