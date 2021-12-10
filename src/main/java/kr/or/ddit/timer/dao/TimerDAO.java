package kr.or.ddit.timer.dao;

import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.TimerVO;

@Repository
public interface TimerDAO {
	
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
	public int timerStart(TimerVO timer);
	
	/**
	 * 종료한 시간을 기록합니다.
	 * @param time
	 * @return
	 */
	public int timerEnd(TimerVO timer);

}
