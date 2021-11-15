package kr.or.ddit.common.qna.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.QnaVO;

/**
 * QnA 게시판 관리
 * @author essimi
 *
 */
@Repository
public interface QnADAO {

	/**
	 * QnA 게시판 전체 레코드 수 조회
	 * @param pagingVO
	 * @return
	 */
	public int selectQnATotalRecord(PagingVO<QnaVO> pagingVO);
	
	/**
	 * QnA 게시판 전체 레코드 수 조회(답변글이 없는 글들)
	 * @param pagingVO
	 * @return
	 */
	public int selectNotAnswerQnATotalRecord(PagingVO<QnaVO> pagingVO);
	
	/**
	 * 관리자 입장에서의 삭제된 글의 개수(페이징 처리용)
	 * @param pagingVO
	 * @return
	 */
	public int selectQnADeleteTotalRecord(PagingVO<QnaVO> pagingVO);
	
	/**
	 * 개인 회원 입장에서의 개인이 작성한 글의 개수 조회(삭제하지 않은 것만) (페이징 처리용)
	 * @param pagingVO
	 * @return
	 */
	public int selectQnAListUserRecord(PagingVO<QnaVO> pagingVO);
	
	
	/**
	 * QnA 게시판 글 목록 조회(관리자)
	 * @param pagingVO
	 * @return
	 */
	public List<QnaVO> selectQnAList(PagingVO<QnaVO> pagingVO);
	
	
	/**
	 * 관리자 입장에서의 삭제된 글만 조회
	 * @param pagingVO
	 * @return
	 */
	public List<QnaVO> selectQnADeleteList(PagingVO<QnaVO> pagingVO);
	
	/**
	 * QnA 답변글이 달리지 않은 글만 조회(관리자)
	 * @param pagingVO
	 * @return
	 */
	public List<QnaVO> selectNotAnswerQnAList(PagingVO<QnaVO> pagingVO);
	
	/**
	 * 개인 회원 입장에서의 개인이 작성한 글(삭제하지 않은 것만)
	 * @param pagingVO
	 * @return
	 */
	public List<QnaVO> selectQnAListUser(PagingVO<QnaVO> pagingVO);
	
	/**
	 * QnA 글 상세조회
	 * @param qandaCode
	 * @return
	 */
	public QnaVO selectQnA(String qandaCode);
	
	/**
	 * 회원의 질문글 작성과 관리자의 답변글 작성
	 * @param qna
	 * @return
	 */
	public int insertQnA(QnaVO qna);
	
	/**
	 * 글 수정
	 * @param qna
	 * @return
	 */
	public int updateQnA(QnaVO qna);
	
	/**
	 * 회원의 작성 글 삭제
	 * @param qandaCode
	 * @return
	 */
	public int deleteQnA(String qandaCode);
	
	
	
	
	
	
	
}
