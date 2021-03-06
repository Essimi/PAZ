package kr.or.ddit.common.noticeAdmin.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.common.PKNotFoundException;
import kr.or.ddit.common.noticeAdmin.dao.NoticeAttatchDAO;
import kr.or.ddit.common.noticeAdmin.dao.NoticeDAO;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.AttatchVO;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PagingVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Inject
	private NoticeDAO noticeDao;
	
	@Inject
	private NoticeAttatchDAO attatchDao;
	
	
	@Value("#{appInfo.attatchPath}")
	private File saveFolder;
	
	private int processAttatche(NoticeVO notice) {
		
		int rowcnt = 0;
		
		AttatchVO attatch = notice.getAttatch();
		
		if(attatch!=null) {
			
			attatch.setPostCode(notice.getNoticeCode());
			
			rowcnt = attatchDao.insertNoticeAttatche(attatch);
			
			log.info("파일 첨부가 수행이 되는가 {}", rowcnt);
			
			try {
				attatch.saveTo(saveFolder);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		return rowcnt;
	}

	@Override
	public List<NoticeVO> selectNoticeList(PagingVO<NoticeVO> pagingVO) {
		
		List<NoticeVO> noticeList = noticeDao.selectNoticeList(pagingVO);
		pagingVO.setTotalRecord(noticeDao.selectTotalRecord(pagingVO));
		pagingVO.setDataList(noticeList);
		return noticeList;
		
	}

	@Override
	public NoticeVO selectNotice(String noticeCode) {
		
		NoticeVO notice = noticeDao.selectNotice(noticeCode);
		
		return notice;
	}

	@Transactional
	@Override
	public ServiceResult insertNotice(NoticeVO notice) {
		
		ServiceResult result = null;
		
		// 글의 코드를 먼저 생성
		String noticeCode = noticeDao.selectNoticeCode();
		log.info("글 코드 메서드 실행 값 {}", noticeCode);
		
		// 글의 코드를 Notice VO에 저장한다.
		notice.setNoticeCode(noticeCode);
		
		log.info("글 코드 메서드 실행 값 {}", notice.getNoticeCode());
		
		int rowcnt = noticeDao.insertNotice(notice);
		
		if(rowcnt > 0) {
			rowcnt += processAttatche(notice);
			result = ServiceResult.OK;		
		}else {
			result = ServiceResult.FAILED;
		}
		
		return result;
	}

	@Override
	public AttatchVO download(String noticeCode) {
		
		AttatchVO attatch = attatchDao.selectAttatch(noticeCode);
		
		if(attatch==null) {
			throw new PKNotFoundException(noticeCode+"파일이 존재하지 않음.");
		}
		
		return attatch;
		
	}

	@Transactional
	@Override
	public ServiceResult updateNotice(NoticeVO notice) {
		
		// 수정을 클릭하는 회원이 글쓴 회원과 동일한지 확인한다.
		// 수정할 글의 코드를 전달해준다.
		boolean authenticated = authenticated(notice.getNoticeCode());
		
		ServiceResult result = null;
		
		if(authenticated) {
			
			// 공지사항의 내용 수정
			int rowcnt = noticeDao.updateNotice(notice);
			
			
			// 내용 수정이 성공했을 경우
			if(rowcnt > 0) {
				
				// 삭제 파일 처리
				if (notice.getNoticeFile() != null) {
					
					FileUtils.deleteQuietly(new File(saveFolder, notice.getAttatch().getSaveName()));
					attatchDao.deleteNoticeAttatche(notice.getNoticeCode());
					
				}
				
				// 파일 처리
				processAttatche(notice);
				
			}
			
			result = ServiceResult.OK;
			
		} else {
			
			// 검증 통과 실패 (회원의 아이디가 글쓴 회원의 아이디와는 다른 경우)
			result = ServiceResult.FAILED;
		}
		
		return result;
		
	}
	
	@Transactional
	@Override
	public ServiceResult deleteNotice(String noticeCode) {
		
		boolean authenticated = authenticated(noticeCode);
		
		ServiceResult result = null;
		
		if(authenticated) {
			
			// 첨부파일에 대한 정보를 가져와 실제 첨부파일을 삭제한다.
			AttatchVO attatch = attatchDao.selectAttatch(noticeCode);
			
			if (attatch != null) {
				FileUtils.deleteQuietly(new File(saveFolder, attatch.getSaveName()));
			}
			
			// 파일 삭제 실행
			if (attatch != null) {
				attatchDao.deleteNoticeAttatche(noticeCode);
			}
			
			// 공지사항 삭제 실행
			noticeDao.deleteNotice(noticeCode);
			
			result = ServiceResult.OK;
			
		}else {
			
			result = ServiceResult.FAILED;
			
		}
		
		return result;
	}
	
	
	
	private boolean authenticated(String noticeCode){
		
		// 현재 세션에 저장되어 있는 아이디를 가져온다.
		String savedId = "admin";
		
		// 글의 코드의 작성자를 확인한다.
		
		NoticeVO notice = noticeDao.selectNotice(noticeCode);
		
		String noticeId = notice.getMemId();
		
		log.info("글을 작성한 회원의 아이디 {}", noticeId);
		log.info("같은 아이디 인가 다른 아이디 인가 {}", savedId.equals(noticeId));
		
		// 동일 아이디인지 아닌지를 판단한다.
	
		if (savedId.equals(noticeId)) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
}