package kr.or.ddit.news.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.NewsReplyVO;

@Repository
public interface NewsReplyDAO {
	
	public int insertNewsReply(NewsReplyVO reply);
	
	public int updateNewsReply(NewsReplyVO reply);
	
	public int deleteNewsReply(NewsReplyVO reply);
	
	public List<NewsReplyVO> newsReplyList (NewsReplyVO newsReply);

}
