package kr.or.ddit.common.qna.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.QnaVO;

/**
* QnA 게시판 관리
* @author essimi
*
*/
public interface QnAService {
	
	/**
	 * QnA 게시판 글 목록 조회(관리자)
	 * @param pagingVO
	 * @return
	 */
	public List<QnaVO> retrieveQnAList(PagingVO<QnaVO> pagingVO);
	
	/**
	 * 관리자 입장에서의 삭제된 글만 조회
	 * @param pagingVO
	 * @return
	 */
	public List<QnaVO> retrieveQnADeleteList(PagingVO<QnaVO> pagingVO);
	
	/**
	 * QnA 답변글이 달리지 않은 글만 조회(관리자)
	 * @param pagingVO
	 * @return
	 */
	public List<QnaVO> retrieveNotAnswerQnAList(PagingVO<QnaVO> pagingVO);
	
	/**
	 * 개인 회원 입장에서의 개인이 작성한 글(삭제하지 않은 것만)
	 * @param pagingVO
	 * @return
	 */
	public List<QnaVO> retrieveQnAListUser(PagingVO<QnaVO> pagingVO);
	
	/**
	 * QnA 글 상세조회
	 * @param qandaCode
	 * @return
	 */
	public QnaVO retrieveQnA(String qandaCode);
	
	/**
	 * 회원의 질문글 작성과 관리자의 답변글 작성
	 * @param qna
	 * @return
	 */
	public ServiceResult createQnA(QnaVO qna);
	
	/**
	 * 작성 글 수정
	 * @param qna
	 * @return
	 */
	public ServiceResult modifyQnA(QnaVO qna);

	/**
	 * 회원의 글 삭제
	 * @param qna
	 * @return
	 */
	public ServiceResult removeQnA(String qandaCode);
	
	
}
