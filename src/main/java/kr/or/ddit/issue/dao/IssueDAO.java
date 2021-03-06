package kr.or.ddit.issue.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.IssueVO;
import kr.or.ddit.vo.PagingVO;

@Repository
public interface IssueDAO {
	
	/**
	 * 이슈 리스트 조회
	 * @param paging
	 * @return
	 */
	public List<IssueVO> selectIssueList(PagingVO<IssueVO> paging);
	
	/**
	 * 이슈 게시물 총 개수 조회
	 * @param paging
	 * @return
	 */
	public int selectTotalRecord(PagingVO<IssueVO> paging);
	
	/**
	 * 이슈 게시물 상세 조회
	 * @param issue
	 * @return
	 */
	public IssueVO selectIssueBoard(IssueVO issue);
	
	/**
	 * 이슈 게시물 등록
	 * @param issue
	 * @return
	 */
	public int insertIssueBoard(IssueVO issue);
	
	/**
	 * 이슈 게시물 수정
	 * @param issue
	 * @return
	 */
	public int updateIssueBoard(IssueVO issue);
	
	/**
	 * 이슈 게시물 삭제
	 * @param issue
	 * @return
	 */
	public int deleteIssueBoard(IssueVO issue);
	
	/**
	 * 해당 게시물의 수신자 모두 삭제
	 * @param issue
	 * @return
	 */
	public int deleteIssueRecipients(IssueVO issue);
	
	/**
	 * 해당 게시물의 수신자 등록
	 * @param issue
	 * @return
	 */
	public int insertIssueRecipients(IssueVO issue);
}
