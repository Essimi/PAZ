package kr.or.ddit.common.qna.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.common.PKNotFoundException;
import kr.or.ddit.common.qna.dao.QnADAO;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.QnaVO;

@Service
public class QnAServiceImpl implements QnAService {
	
	@Inject
	private QnADAO qnaDao;

	@Override
	public List<QnaVO> retrieveQnAList(PagingVO<QnaVO> pagingVO) {
		
		List<QnaVO> QnAList = qnaDao.selectQnAList(pagingVO);
		
		pagingVO.setTotalRecord(qnaDao.selectQnATotalRecord(pagingVO));
		
		pagingVO.setDataList(QnAList);
		
		return QnAList;
	}
	
	@Override
	public List<QnaVO> retrieveQnADeleteList(PagingVO<QnaVO> pagingVO) {
		
		List<QnaVO> QnAList = qnaDao.selectQnADeleteList(pagingVO);
		
		pagingVO.setTotalRecord(qnaDao.selectQnADeleteTotalRecord(pagingVO));
		
		pagingVO.setDataList(QnAList);
		
		return QnAList;
	}

	@Override
	public List<QnaVO> retrieveNotAnswerQnAList(PagingVO<QnaVO> pagingVO) {
		
		List<QnaVO> QnAList = qnaDao.selectNotAnswerQnAList(pagingVO);
		
		pagingVO.setTotalRecord(qnaDao.selectNotAnswerQnATotalRecord(pagingVO));
		
		pagingVO.setDataList(QnAList);
		
		return QnAList;
	}
	
	@Override
	public List<QnaVO> retrieveQnAListUser(PagingVO<QnaVO> pagingVO) {
		
		List<QnaVO> QnAList = qnaDao.selectQnAListUser(pagingVO);
		
		pagingVO.setTotalRecord(qnaDao.selectQnAListUserRecord(pagingVO));
		
		pagingVO.setDataList(QnAList);
		
		return QnAList;
	}

	@Override
	public QnaVO retrieveQnA(String qandaCode)  throws PKNotFoundException{
		
		QnaVO qna = qnaDao.selectQnA(qandaCode);
		
		if(qna == null) {
			throw new PKNotFoundException(qandaCode + " 번 글이 없음.");
		}
		
		return qna;
	}

	@Transactional
	@Override
	public ServiceResult createQnA(QnaVO qna) {
		
		ServiceResult result = null;
		
		int rowcnt = qnaDao.insertQnA(qna);
		
		if(rowcnt > 0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		
		return result;
	}
	
	@Transactional
	@Override
	public ServiceResult modifyQnA(QnaVO qna) {
		
		ServiceResult result = null;
		
		int rowcnt = qnaDao.updateQnA(qna);
		
		if(rowcnt > 0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		
		return result;
	}

	@Transactional
	@Override
	public ServiceResult removeQnA(String qandaCode) {
		
		ServiceResult result = null;
		
		int rowcnt = qnaDao.deleteQnA(qandaCode);
		
		if(rowcnt > 0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		
		return result;
	}
}
