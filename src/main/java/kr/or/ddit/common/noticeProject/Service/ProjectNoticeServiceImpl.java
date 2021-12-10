package kr.or.ddit.common.noticeProject.Service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.noticeProject.dao.ProjectNoticeDAO;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PagingVO;

@Service
public class ProjectNoticeServiceImpl implements ProjectNoticeService {
	
	@Inject
	private ProjectNoticeDAO dao;

	@Override
	public List<NoticeVO> selectProjectNoticeList(PagingVO<NoticeVO> pagingVO) {
		
		List<NoticeVO> noticeList = dao.selectProjectNoticeList(pagingVO);
		pagingVO.setTotalRecord(dao.selectTotalRecord(pagingVO));
		pagingVO.setDataList(noticeList);
		return noticeList;
		
	}

}
