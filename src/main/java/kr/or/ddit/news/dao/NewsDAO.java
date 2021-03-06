package kr.or.ddit.news.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.CalendarVO;
import kr.or.ddit.vo.NewsVO;

@Repository
public interface NewsDAO {
	
	public List<NewsVO> newsList(NewsVO news);
	
	public int insertNews (NewsVO news);
	public int updateNews (NewsVO news);
	public int deleteNews (NewsVO news);
	public NewsVO selectNews(NewsVO news);
	
	
	
	

}
