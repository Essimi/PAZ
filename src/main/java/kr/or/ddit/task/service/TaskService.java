package kr.or.ddit.task.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.TaskVO;


public interface TaskService {
	
	/**
	 * 	업무 리스트 출력
	 * @param pagingVO
	 * @return
	 */
	public List<TaskVO> retrieveTaskList(PagingVO<TaskVO> pagingVO);
	
	
	/**
	 * 상위 업무 검색 리스트 조회
	 * @param taskVO
	 * @return
	 */
	public List<TaskVO> selectTopTaskSearchList (TaskVO taskVO);
	
	
	/**
	 * 업무 정보 수정 
	 * @param taskVO
	 * @return
	 */
	public ServiceResult updateTask (TaskVO taskVO);
	
	
	/**
	 * 업무 정보 상세 조회
	 * @param taskVO
	 * @return
	 */
	public TaskVO selectTask (TaskVO taskVO);
	
	
	/**
	 * 업무 삭제
	 * @param taskVO
	 * @return
	 */
	public ServiceResult deleteTask (TaskVO taskVO);
	
	public List<TaskVO> justTaskList (TaskVO taskVO);
	
	public List<TaskVO> justKanbanList(TaskVO taskVO);
	public ServiceResult stateCard(TaskVO kanban);
	
	/**
	 * 업무 등록
	 * @param taskVO
	 * @return
	 */
	public ServiceResult insertTask (TaskVO taskVO);

}
