package kr.or.ddit.kanban.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.kanban.dao.KanbanDAO;
import kr.or.ddit.vo.KanbanVO;
import kr.or.ddit.vo.TaskVO;

@Service
public class KanbanServiceImpl implements KanBanService {

/*	@Inject
	KanbanDAO kanbanDao;
	//인터페이스에 세개 
	//map으로 세개 선언 해서 이름을 키로 잡아서 entry세개를 집어넣지, service에서 이름 세개를 설정해서 가져올 수 있도록 한다 

	@Override
	public List<TaskVO> selectKanbanList(TaskVO kanban) {
		return kanbanDao.selectKanbanList(kanban);
	}



	@Override
	public TaskVO selectCard(KanbanVO card) {
		return null;
	}

	@Override
	public ServiceResult moveCard(KanbanVO card) {
		KanbanVO droppedCard = kanbanDao.selectCard(card);
		KanbanVO preCard = null;
		KanbanVO nextCard = null;
		
		//드랍된 카드의 preCard정보
		if(droppedCard.next != null) {
			preCard = kanbanDao.selectCard(droppedCard.next);
		}
		
		//드랍된 카드의 현재 다음 카드 정보 
		if(nextCard != null) {
			nextCard = kanbanDao.selectCard(nextCard);
		}
		
		//preCard가 droppedCard의 pre를 pre로 가진다 
		
		
		return null;
	}



	@Override
	public ServiceResult stateCard(TaskVO kanban) {
		return kanbanDao.stateCard(kanban);
	}*/



}
