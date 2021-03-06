package kr.or.ddit.task.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.task.dao.TaskDAO;
import kr.or.ddit.vo.ModifyHistoryVO;
import kr.or.ddit.vo.PagingVO;
import kr.or.ddit.vo.TaskVO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TaskServiceImpl implements TaskService{
	
	@Inject
	TaskDAO dao;

	// 업무 리스트 출력
	@Override
	public List<TaskVO> retrieveTaskList(PagingVO<TaskVO> pagingVO) {
		
		List<TaskVO> taskList = dao.selectTaskList(pagingVO);
		
		pagingVO.setTotalRecord(dao.selectTaskTotalRecord(pagingVO));
		pagingVO.setDataList(taskList);
		
		return taskList;
	}

	// 상위 업무 검색 리스트
	@Override
	public List<TaskVO> selectTopTaskSearchList(TaskVO taskVO) {
		
		return dao.selectTopTaskSearchList(taskVO);
	}

	
	// 업무 수정
	@Override
	@Transactional
	public ServiceResult updateTask(TaskVO newTask){
		
		ServiceResult result = null;
		
		// taskVO 받은거로 기존 데이터 가져오기.
		TaskVO beforeTask = selectTask(newTask);
		
		
		// taskVO 리스트에 넣을거임 !
		List<ModifyHistoryVO> modifyHistoryList = new ArrayList<>();
		
		ModifyHistoryVO modifyTask = new ModifyHistoryVO();
		
		modifyTask.setWorkCode(newTask.getWorkCode());
		modifyTask.setModifierId(newTask.getModifierId());
		
		
		log.info("beforeTask : {} " , beforeTask.toString());
		log.info("newTask : {} " , newTask.toString());
		
		int flag = 1;
		
		// 만약 상위업무가 없었다면 넣어주기  
		if(StringUtils.isEmpty(beforeTask.getTopWorkCode())) {
			beforeTask.setTopWorkCode("null");
		}
		
		// 상위 업무 수정 시
		// null ㅣㅇ ㄹ때,.. 해라... 
		if(newTask.getTopWorkCode() != "null" && !beforeTask.getTopWorkCode().equals(newTask.getTopWorkCode())) {
			
			log.info("asdaslf :{}", newTask.getTopWorkCode());
			// List<ModifyHistoryVO> modifyHistoryList; 에 넣기
			modifyTask.setColumnKey("상위 업무");
			modifyTask.setBeforeValue(beforeTask.getTopWorkCode());
			modifyTask.setAfterValue(newTask.getTopWorkCode());
			
			int res = dao.insertModifyHistory(modifyTask);
			
			if(res > 0) {
				flag = flag * 1;
			}else  {
				flag = flag * 0;
			}

		}
		
		
		// 업무 이름 수정 시
		if(!beforeTask.getWorkName().equals(newTask.getWorkName())) {
			
			modifyTask.setColumnKey("업무 이름");
			modifyTask.setBeforeValue(beforeTask.getWorkName());
			modifyTask.setAfterValue(newTask.getWorkName());
			
			int res = dao.insertModifyHistory(modifyTask);
			
			if(res > 0) {
				flag = flag * 1;
			}else  {
				flag = flag * 0;
			}	
			
		}
		
		// 업무 내용 수정 시
		if(!beforeTask.getWorkContents().equals(newTask.getWorkContents())) {
			
			modifyTask.setColumnKey("업무 내용");
			modifyTask.setBeforeValue(beforeTask.getWorkContents());
			modifyTask.setAfterValue(newTask.getWorkContents());
			
			int res = dao.insertModifyHistory(modifyTask);
			
			if(res > 0) {
				flag = flag * 1;
			}else  {
				flag = flag * 0;
			}

		}
		
		
		// 업무 시작일 수정 시
		if(!beforeTask.getWorkStart().equals(newTask.getWorkStart())) {
			
			modifyTask.setColumnKey("업무 시작일");
			modifyTask.setBeforeValue(beforeTask.getWorkStart());
			modifyTask.setAfterValue(newTask.getWorkStart());
			
			int res = dao.insertModifyHistory(modifyTask);
			
			if(res > 0) {
				flag = flag * 1;
			}else  {
				flag = flag * 0;
			}

		}
		
		
		// 업무 진척도 수정 시
		if(!beforeTask.getProgress().equals(newTask.getProgress())) {
			
			modifyTask.setColumnKey("진척도");
			modifyTask.setBeforeValue(beforeTask.getProgress());
			modifyTask.setAfterValue(newTask.getProgress());
			
			int res = dao.insertModifyHistory(modifyTask);
			
			if(res > 0) {
				flag = flag * 1;
			}else  {
				flag = flag * 0;
			}

		}
		
		
		// 업무 중요도 수정 시
		if(!beforeTask.getImportance().equals(newTask.getImportance())) {
			
			modifyTask.setColumnKey("중요도");
			modifyTask.setBeforeValue(beforeTask.getImportance());
			modifyTask.setAfterValue(newTask.getImportance());
			
			int res = dao.insertModifyHistory(modifyTask);
			
			if(res > 0) {
				flag = flag * 1;
			}else  {
				flag = flag * 0;
			}

		}
		
		
		// 업무 상태 수정 시
		if(!beforeTask.getWorkStatus().equals(newTask.getWorkStatus())) {
			
			modifyTask.setColumnKey("현황");
			modifyTask.setBeforeValue(beforeTask.getWorkStatus());
			modifyTask.setAfterValue(newTask.getWorkStatus());
			
			int res = dao.insertModifyHistory(modifyTask);
			
			if(res > 0) {
				flag = flag * 1;
			}else  {
				flag = flag * 0;
			}

		}

		
		log.info("모디파이 리스트 ; {} ",modifyHistoryList.toString());
		
		

		// 바뀐 값이 없고 null 이면.
		if (newTask.getTopWorkCode() == "null" ) {
			newTask.setTopWorkCode(beforeTask.getTopWorkCode());
		}
		
		// 변경된 값 update  진행.
		int update = dao.updateTask(newTask);
		
		if(update > 0 && flag > 0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		
		return result;
	}
	
	
	// 업무 상세 조회
	public TaskVO selectTask (TaskVO taskVO) {
		
		return dao.selectTask(taskVO);
	}
	

	@Override
	public ServiceResult deleteTask(TaskVO taskVO) {
		
		ServiceResult result = null;
		
		int cnt = dao.deleteTask(taskVO);
		
		if (cnt > 0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		
		return result;
	}
	

	@Override
	public List<TaskVO> justTaskList(TaskVO taskVO) {
		
		return dao.justTaskList(taskVO);
	}
	

	@Override
	public List<TaskVO> justKanbanList(TaskVO task) {
		// TODO Auto-generated method stub
		return dao.justKanbanList(task);
	}

	@Override
	public ServiceResult insertTask(TaskVO taskVO) {
		
		ServiceResult result = null;
		
		int cnt = dao.insertTask(taskVO);
		
		if(cnt> 0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		
		return result;
	}

	@Override
	public ServiceResult stateCard(TaskVO kanban) {
		ServiceResult result = null;
		
		int cnt = dao.stateCard(kanban);
		
		if(cnt> 0) {
			result = ServiceResult.OK;
		}else {
			result = ServiceResult.FAILED;
		}
		
		return result;
	}

 
}
