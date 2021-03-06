package kr.or.ddit.news.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import kr.or.ddit.common.PKNotFoundException;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.news.dao.NewsDAO;
import kr.or.ddit.vo.CalendarVO;
import kr.or.ddit.vo.NewsVO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NewsServiceImpl implements NewsService {
	
	@Inject
	private NewsDAO newsDAO; 

	
	

	@Override
	public ServiceResult createNews(NewsVO news) throws IOException {
		
		ServiceResult result = null;
		
		int rowcnt = newsDAO.insertNews(news);
		
		log.info("여기 service : {}", rowcnt);
		
		if(rowcnt > 0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		
		log.info("여기 service 나올 떄 : {}", rowcnt);
		
		return result;
	}

	@Override
	public List<NewsVO> newsList(NewsVO news) {
		
		
		return newsDAO.newsList(news);
	}

	@Override
	public ServiceResult modifyNews(NewsVO news) {
		ServiceResult result = null;
		int rowcnt = newsDAO.updateNews(news);
		
		if(rowcnt > 0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		
		return result;
	}

	@Override
	public ServiceResult removeNews(NewsVO news) {
		ServiceResult result = null;
		int rowcnt = newsDAO.deleteNews(news);
		
		if(rowcnt > 0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		
		return result;
	}

	@Override
	public NewsVO selectNews(NewsVO news) {
		NewsVO newsOne = newsDAO.selectNews(news);
		if(newsOne == null) {
			throw new PKNotFoundException(news + "없음");
		}
		return newsOne;
	}
	




}
