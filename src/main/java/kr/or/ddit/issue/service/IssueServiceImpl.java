package kr.or.ddit.issue.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.common.PKNotFoundException;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.issue.dao.IssueDAO;
import kr.or.ddit.vo.IssueVO;
import kr.or.ddit.vo.PagingVO;

@Service
public class IssueServiceImpl implements IssueService{

	@Inject
	private IssueDAO issueDAO;
	
	@Override
	public List<IssueVO> retrieveIssueList(PagingVO<IssueVO> paging) {
		paging.setTotalRecord(issueDAO.selectTotalRecord(paging));
		List<IssueVO> dataList = issueDAO.selectIssueList(paging);
		paging.setDataList(dataList);
		return dataList;
	}

	@Override
	public IssueVO retrieveIssue(IssueVO issue) {
		IssueVO issueResult = issueDAO.selectIssueBoard(issue);
		if(issueResult == null) {
			throw new PKNotFoundException("게시물을 찾을 수가 없음.");
		}
		
		return issueResult;
	}
	
	@Override
	public ServiceResult createIssue(IssueVO issue) {
		int cnt = issueDAO.insertIssueBoard(issue);
		ServiceResult result = ServiceResult.FAILED;
		if(cnt > 0) {
			result = ServiceResult.OK;
		}
		
		return result;
	}

	@Transactional
	@Override
	public ServiceResult modifyIssue(IssueVO issue) {
		int updateCnt = issueDAO.updateIssueBoard(issue);
		int deleteCnt = issueDAO.deleteIssueRecipients(issue);
		int insertCnt = issueDAO.insertIssueRecipients(issue);
		
		ServiceResult result = ServiceResult.FAILED;
		if(updateCnt > 0 && deleteCnt > 0 && insertCnt > 0) {
			result = ServiceResult.OK;
		}
		
		return result;
	}

	@Transactional
	@Override
	public ServiceResult deleteIssue(IssueVO issue) {
		int cntRecipient = issueDAO.deleteIssueRecipients(issue);
		int cntBoard = issueDAO.deleteIssueBoard(issue);
		ServiceResult result = ServiceResult.FAILED;
		if(cntRecipient > 0 && cntBoard > 0) {
			result = ServiceResult.OK;
		}
		
		return result;
	}

	

}
