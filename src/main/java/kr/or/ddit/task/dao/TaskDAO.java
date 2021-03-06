package kr.or.ddit.task.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.ModifyHistoryVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.TaskVO;

@Repository
public interface TaskDAO {
	
	/**
	 * 전체 업무 리스트 갯수 조회
	 * @param pagingVO
	 * @return int
	 */
	public int selectTaskTotalRecord(PagingVO<TaskVO> pagingVO);
	
	/**
	 * 해당 프로젝트의 업무 리스트 출력
	 * @param pCode
	 * @return List<TaskVO>
	 */
	public List<TaskVO> selectTaskList (PagingVO<TaskVO> pagingVO); 
	

	/**
	 * 상위 업무 이름 출력
	 * @param taskVO
	 * @return
	 */
	public TaskVO selectTopTaskName (TaskVO taskVO);
	
	/**
	 * 상위 업무 검색 리스트 조회
	 * @param taskVO
	 * @return
	 */
	public List<TaskVO> selectTopTaskSearchList (TaskVO taskVO); 
	
	public List<TaskVO> justTaskList (TaskVO taskVO);
	public List<TaskVO> justKanbanList (TaskVO task);
	
	//업무 상태 업데이트 
		public int stateCard(TaskVO kanban);
	/**
	 * 업무 상세 정보 수정 
	 * @param taskVO
	 * @return
	 */
	public int updateTask(TaskVO taskVO);
	
	
	/**
	 * 업무 수정 내역 저장
	 * @param taskVO
	 * @return
	 */
	public int insertModifyHistory (ModifyHistoryVO modifyHistoryVO);
	
	
	/**
	 * 업무 상세 정보 조회
	 * @param taskVO
	 * @return
	 */
	public TaskVO selectTask (TaskVO taskVO);
	

	/**
	 * 업무 삭제
	 * @param taskVO
	 * @return
	 */
	public int deleteTask (TaskVO taskVO);
	
	
	/**
	 * 업무 등록
	 * @param taskVO
	 * @return
	 */
	public int insertTask (TaskVO taskVO);
	
}
