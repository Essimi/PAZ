package kr.or.ddit.timer.service;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.TimerVO;

public interface TimerService {
	
	/**
	 * 해당 회원의 출퇴근 상태를 불러옵니다.
	 * @param time
	 * @return
	 */
	public TimerVO OnOffInfo(String memId);
	
	/**
	 * 시작한 시간을 기록합니다.
	 * @param time
	 * @return
	 */
	public ServiceResult timerStart(TimerVO timer);
	
	/**
	 * 종료한 시간을 기록합니다.
	 * @param time
	 * @return
	 */
	public ServiceResult timerEnd(TimerVO timer);

}
