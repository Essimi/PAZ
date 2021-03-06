package kr.or.ddit.common.noticeProject.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.common.PKNotFoundException;
import kr.or.ddit.common.noticeProject.dao.ProjectNoticeAttatchDAO;
import kr.or.ddit.common.noticeProject.dao.ProjectNoticeDAO;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.AttatchVO;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProjectNoticeServiceImpl implements ProjectNoticeService {
	
	@Value("#{appInfo.attatchPath}")
	private File saveFolder;
	
	@Inject
	private ProjectNoticeDAO dao;
	
	@Inject
	private ProjectNoticeAttatchDAO attatchDAO;
	
	private int processAttatche(NoticeVO notice) {
		
		int rowcnt = 0;
		
		AttatchVO attatch = notice.getAttatch();
		
		if(attatch!=null) {
			
			log.info("공지사항코드{}", notice.getNoticeCode());
			log.info("프로젝트코드{}", notice.getPartCode());
			
			attatch.setPostCode(notice.getNoticeCode());
			attatch.setPCode(notice.getPartCode());
			
			log.info("여기까지오는지 {}", "여기까지 온다");
			
			rowcnt = attatchDAO.insertProjectNoticeAttatche(attatch);
			
			try {
				attatch.saveTo(saveFolder);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		return rowcnt;
		
	}

	@Override
	public List<NoticeVO> selectProjectNoticeList(PagingVO<NoticeVO> pagingVO) {
		
		List<NoticeVO> noticeList = dao.selectProjectNoticeList(pagingVO);
		pagingVO.setTotalRecord(dao.selectTotalRecord(pagingVO));
		pagingVO.setDataList(noticeList);
		return noticeList;
		
	}

	@Override
	public NoticeVO selectProjectNotice(String noticeCode) {
		NoticeVO notice = dao.selectProjectNotice(noticeCode);
		return notice;
	}
	
	@Transactional
	@Override
	public ServiceResult insertProjectNotice(NoticeVO notice) {
		
		ServiceResult result = null;
		
		// 글의 코드를 먼저 생성시킨다.
		String noticeCode = dao.selectProjectNoticeCode();
		log.info("noticeCode : {}", noticeCode);
		
		// 글의 코드를 Notice VO에 저장한다.
		notice.setNoticeCode(noticeCode);
		
		int rowcnt = dao.insertProjectNotice(notice);
		
		if (rowcnt > 0) {
			rowcnt += processAttatche(notice);
			result = ServiceResult.OK;	
		} else {
			result = ServiceResult.FAILED;
		}
		
		return result;
		
	}

	@Override
	public AttatchVO downloadProjectAttatch(String noticeCode) {
		
		AttatchVO attatch = attatchDAO.selectProjectNoticeAttatch(noticeCode);
		
		if(attatch==null) {
			throw new PKNotFoundException(noticeCode + " 이 존재하지 않는다.");
		}
		
		return attatch;
	}

	@Override
	public ServiceResult updateProjectNotice(NoticeVO notice) {
		
		ServiceResult result = ServiceResult.FAILED;
		
		int rowcnt = dao.updateProjectNotice(notice);
		
		// 내용 변경이 완료되었을 경우
		if(rowcnt > 0) {
			
			// 첨부파일 삭제 처리
			if (notice.getNoticeFile() != null) {
				
				FileUtils.deleteQuietly(new File(saveFolder, notice.getAttatch().getSaveName()));
				attatchDAO.deleteProjectNoticeAttatche(notice.getNoticeCode());
				
			}
			
			// 새로운 첨부파일에 대한 처리
			processAttatche(notice);
			
		}
		
		result = ServiceResult.OK;
		
		return result;
	}

	@Override
	public ServiceResult deleteProjectNotice(String noticeCode) {
		
		ServiceResult result = ServiceResult.FAILED;
		
		// 첨부파일에 대한 정보를 가져와 실제 첨부파일을 삭제한다.
		AttatchVO attatch = attatchDAO.selectProjectNoticeAttatch(noticeCode);
		
		// 실제 파일 위치에서 삭제
		if (attatch != null) {
			FileUtils.deleteQuietly(new File(saveFolder, attatch.getSaveName()));
		}
		
		// DB 정보 삭제 실행
		if (attatch != null) {
			attatchDAO.deleteProjectNoticeAttatche(noticeCode);
		}
		
		// 공지사항 삭제 실행
		int cnt = dao.deleteProjectNotice(noticeCode);
		
		if (cnt > 0) {
			result = ServiceResult.OK;
		}
		
		return result;
	}

}
