package kr.or.ddit.news.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.PKNotFoundException;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.AttatchVO;
import kr.or.ddit.vo.CalendarVO;
import kr.or.ddit.vo.NewsVO;


public interface NewsService {

	public ServiceResult createNews(NewsVO news) throws IOException;

	public List<NewsVO> newsList(NewsVO news);

	public ServiceResult modifyNews(NewsVO news);

	public ServiceResult removeNews(NewsVO news);
	
	public NewsVO selectNews(NewsVO news);
	


}
