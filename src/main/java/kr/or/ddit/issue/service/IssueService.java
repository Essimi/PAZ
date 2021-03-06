package kr.or.ddit.issue.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.IssueVO;
import kr.or.ddit.vo.PagingVO;

public interface IssueService {
	
	/**
	 * 이슈 리스트 조회
	 * @param paging
	 * @return
	 */
	public List<IssueVO> retrieveIssueList(PagingVO<IssueVO> paging);
	
	/**
	 * 이슈 상세조회
	 * @param issue
	 * @return
	 */
	public IssueVO retrieveIssue(IssueVO issue);
	
	/**
	 * 이슈 게시글 등록
	 * @param issue
	 * @return OK, FAILED
	 */
	public ServiceResult createIssue(IssueVO issue);
	
	/**
	 * 이슈 게시글 수정
	 * @param issue
	 * @return OK, FAILED, NOTEXIST
	 */
	public ServiceResult modifyIssue(IssueVO issue);
	
	/**
	 * 이슈 게시글 삭제
	 * @param issue
	 * @return OK, FAILED, NOTEXIST
	 */
	public ServiceResult deleteIssue(IssueVO issue);
}
