package kr.or.ddit.news.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.NewsReplyVO;

@Repository
public interface NewsReplyDAO {
	
	public int insertNewsReply(NewsReplyVO newsReply);
	
	public int updateNewsReply(NewsReplyVO newsReply);
	
	public int deleteNewsReply(NewsReplyVO newsReply);
	
	public List<NewsReplyVO> newsReplyList (NewsReplyVO newsReply);
	
	public NewsReplyVO selectNewsReply (NewsReplyVO newsReply);

}
